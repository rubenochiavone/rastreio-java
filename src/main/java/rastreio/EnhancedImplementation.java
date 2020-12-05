package rastreio;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Enhanced implementation using OkHttp and Jsoup (from DefaultImplementation).
 */
public class EnhancedImplementation implements Implementation {
  private static final OkHttpClient HTTP_CLIENT;
  private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss SSS");

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
          listener.onSuccess(parseResponse(objectCode, responseBody.string()));
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
      return parseResponse(objectCode, response.body().string());
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
   * Parse response data and create new tracking object.
   * @param objectCode tracking object code
   * @param response response data to be parsed
   * @return new tracking object
   */
  private TrackObject parseResponse(String objectCode, String response) {
    TrackObjectServiceType serviceType = TrackObjectServiceType.UNKNOWN;

    try {
      serviceType = TrackObjectServiceType.valueOf(objectCode.substring(0, 2));
    } catch (Exception e) {
      // ignore
    }

    TrackObject trackObject = new TrackObject();
    trackObject.setCode(objectCode);
    trackObject.setServiceType(serviceType);
    trackObject.setError(Error.OBJECT_NOT_FOUND);
    trackObject.setValid(false);
    trackObject.setDelivered(false);

    Document document = Jsoup.parse(response);
    Elements elements = document.getElementsByClass("listEvent");

    if (elements.isEmpty()) {
      return trackObject;
    }

    ArrayList<TrackObject.Event> events = new ArrayList<TrackObject.Event>();

    for (Element eventListItem : elements) {
      elements = eventListItem.getElementsByTag("tr").first().getElementsByTag("td");

      if (elements.size() != 2) {
        System.out.println("Rastreio.parseResponse: couldn't find enough table data elements");
        continue; // Skip invalid table row
      }

      final Element eventListFirstData = elements.first();
      final Element eventListLastData = elements.last();

      String eventListFirstDataHtml = eventListFirstData.html();
      String[] eventListFirstDataPieces = eventListFirstDataHtml.trim().split("<br>");

      if (eventListFirstDataPieces.length != 3) {
        System.out
            .println("Rastreio.parseResponse: couldn't parse first table data element properly");
        continue; // Skip invalid table row
      }

      String eventDate = eventListFirstDataPieces[0].trim();
      String eventTime = eventListFirstDataPieces[1].trim();

      elements = eventListFirstData.getElementsByTag("label");

      String locale = null;

      if (!elements.isEmpty()) {
        locale = elements.first().text().trim();
      } else {
        locale = eventListFirstDataPieces[2].trim();
      }

      String eventListLastDataHtml = eventListLastData.html();
      String[] eventListLastDataPieces = eventListLastDataHtml.trim().split("<br>");

      elements = eventListLastData.getElementsByTag("strong");

      String description = null;

      if (!elements.isEmpty()) {
        // Get `strong` node content
        description = elements.first().text().trim();
      } else if (eventListLastDataPieces.length > 0) {
        // Get first string element as event description
        description = eventListLastDataPieces[0].trim();
      } 
      
      if (description == null || description.isEmpty()) {
        System.out
            .println("Rastreio.parseResponse: couldn't parse last table data element properly");
        continue; // Skip invalid table row
      }

      String details = null;

      if (eventListLastDataPieces.length > 1
          && !eventListLastDataPieces[1].trim().startsWith("<!--")) {
        // Get second string element as event details
        details = eventListLastDataPieces[1].trim();
      }

      TrackObject.Event event = new TrackObject.Event();
      event.setLocale(locale);
      event.setDescription(description);
      event.setDetails(details);
      try {
        event.setTrackedAt(DATE_FORMAT.parse(eventDate + " " + eventTime + ":00 000"));
      } catch (ParseException e) {
        System.out.println("Rastreio.parseResponse: couldn't parse event date and time properly");
        continue; // Skip invalid table row
      }

      events.add(0, event);
    }

    if (events.isEmpty()) {
      return trackObject;
    }

    TrackObject.Event first = events.get(0);
    TrackObject.Event last = events.get(events.size() - 1);

    trackObject.setError(Error.NO_ERROR);
    trackObject.setValid(true);
    trackObject.setEvents(events);
    trackObject.setDelivered(last.getDescription().toLowerCase().contains("objeto entregue"));
    trackObject.setPostedAt(first.getTrackedAt());
    trackObject.setUpdatedAt(last.getTrackedAt());

    return trackObject;
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
