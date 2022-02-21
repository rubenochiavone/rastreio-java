package rastreio;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Rastreio implementation abstract class.
 */
public abstract class Implementation {
  protected static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss SSS");
  protected final OkHttpClient mHttpClient;

  protected Implementation(OkHttpClient httpClient) {
    mHttpClient = httpClient;
  }

  public Implementation() {
    mHttpClient = new OkHttpClient();
  }

  /**
   * Track an object by its code asynchronously.
   * 
   * <p>When track operation finishes listener is called with result.</p>
   * 
   * @param objectCode string representing object track code
   * @param listener listener to be called when object tracking is completed
   * @see Rastreio.Listener
   */
  void track(String objectCode, Rastreio.Listener listener) {
    mHttpClient.newCall(newRequest(objectCode)).enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        e.printStackTrace();
        listener.onFailure(new Exception("Rastreio.track: unable to fullfill HTTP request", e));
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        if (response == null || !response.isSuccessful()) {
          listener.onFailure(new IOException("Rastreio.track: erroneous HTTP response "
              + response));
        }
        try (ResponseBody responseBody = response.body()) {
          // Parse response and notify listener about new tacking object
          listener.onSuccess(parseResponse(objectCode, responseBody.string()));
        } catch (IOException e) {
          listener.onFailure(new Exception("Rastreio.track: unable to fullfill HTTP request",
              Implementation.this instanceof ImplementationWithUrlToken
              ? new Exception("Suppressed exception: " + e.getCause()) : e));
        }
      }
    });
  }

  /**
   * Track an object by its code synchronously.
   * 
   * @param objectCode string representing object track code
   * @return new tracking object to query tracking data
   * @throws java.io.IOException if a network error occur
   * @see TrackObject
   */
  public TrackObject trackSync(String objectCode) throws IOException {
    try (Response response = mHttpClient.newCall(newRequest(objectCode)).execute()) {
      if (response == null || !response.isSuccessful()) {
        throw new IOException("Rastreio.trackSync: erroneous HTTP response code " + response);
      }

      // Parse response and return new tacking object
      return parseResponse(objectCode, response.body().string());
    } catch (IOException e) {
      throw new IOException("Rastreio.trackSync: unable to fullfill HTTP request",
          this instanceof ImplementationWithUrlToken
          ? new Exception("Suppressed exception: " + e.getCause()) : e);
    }
  }

  /**
   * Create new request object.
   * @param objectCode tracking object code
   * @return new request object
   */
  protected abstract Request newRequest(String objectCode);

  /**
   * Parse response data and create new tracking object.
   * @param objectCode tracking object code
   * @param response response data to be parsed
   * @return new tracking object
   */
  protected abstract TrackObject parseResponse(String objectCode, String response);
}
