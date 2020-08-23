package rastreio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Enhanced implementation using OkHttp and Jsoup (from DefaultImplementation).
 */
public class EnhancedImplementation implements Implementation {
  private static final OkHttpClient HTTP_CLIENT;

  static {
    HTTP_CLIENT = new OkHttpClient.Builder()
        .cookieJar(new InMemoryCookieJar())
        .followRedirects(true)
        .build();
  }

  @Override
  public void track(String objectCode, Rastreio.Listener listener) {
    HTTP_CLIENT.newCall(newRequest(objectCode)).enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        listener.onFailure(new Exception("Rastreio.track: unable to fullfill HTTP request", e));
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        if (response == null || !response.isSuccessful()) {
          listener.onFailure(
                new IOException("Rastreio.track: erroneous HTTP response " + response));
        }
        try (ResponseBody responseBody = response.body()) {
          // Parse response and notify listener about new tacking object
          listener.onSuccess(DefaultImplementation.parseResponse(objectCode,
              responseBody.string()));
        } catch (IOException e) {
          listener.onFailure(new Exception("Rastreio.track: unable to fullfill HTTP request", e));
        }
        // Clear cookie jar after each response
        if (HTTP_CLIENT.cookieJar() instanceof InMemoryCookieJar) {
          ((InMemoryCookieJar) HTTP_CLIENT.cookieJar()).clear();
        }
      }
    });
  }

  @Override
  public TrackObject trackSync(String objectCode) throws IOException {
    try (Response response = HTTP_CLIENT.newCall(newRequest(objectCode)).execute()) {
      if (response == null || !response.isSuccessful()) {
        throw new IOException("Rastreio.trackSync: erroneous HTTP response code " + response);
      }
      // Clear cookie jar after each response
      if (HTTP_CLIENT.cookieJar() instanceof InMemoryCookieJar) {
        ((InMemoryCookieJar) HTTP_CLIENT.cookieJar()).clear();
      }
      // Parse response and return new tacking object
      return DefaultImplementation.parseResponse(objectCode, response.body().string());
    } catch (IOException e) {
      throw new IOException("Rastreio.trackSync: unable to fullfill HTTP request", e);
    }
  }

  /**
   * Create new request object.
   * @param objectCode tracking object code
   * @return new request object
   */
  private static Request newRequest(String objectCode) {
    RequestBody formBody = new FormBody.Builder()
        .add("objetos", objectCode)
        .add("acao", "track")
        .build();

    Request request = new Request.Builder()
        .url(Magic.URL2)
        .post(formBody)
        .build();

    // Clear cookie jar before each request
    if (HTTP_CLIENT.cookieJar() instanceof InMemoryCookieJar) {
      ((InMemoryCookieJar) HTTP_CLIENT.cookieJar()).clear();
    }

    return request;
  }

  /**
   * In memory cookie jar implementation.
   * Inspired by https://github.com/square/okhttp/issues/2890#issuecomment-600171522.
   */
  private static class InMemoryCookieJar implements CookieJar {
    // Set is preferable to avoid duplicates
    private Set<Cookie> mCache = Collections.synchronizedSet(new HashSet<Cookie>());

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
      Set<Cookie> cookiesToRemove = new HashSet<Cookie>();
      List<Cookie> cookiesForRequest = new ArrayList<Cookie>();

      for (Cookie cookie : mCache) {
        if (cookie.expiresAt() < System.currentTimeMillis()) { // Check if cookie has expired
          cookiesToRemove.add(cookie);
        } else if (cookie.matches(url)) {
          cookiesForRequest.add(cookie);
        }
      }

      mCache.removeAll(cookiesToRemove); // Remove expired cookies

      return cookiesForRequest;
    }

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
      Set<Cookie> cookiesToAdd = new HashSet<Cookie>();

      for (Cookie cookie : cookies) {
        cookiesToAdd.add(cookie);
      }

      mCache.removeAll(cookiesToAdd); // Remove duplicates
      mCache.addAll(cookiesToAdd);
    }

    /**
     * Clear all the cookies from persistence and from the cache.
     */
    public void clear() {
      mCache.clear();
    }
  }
}
