package rastreio;

import java.io.IOException;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
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
 * Get tracking object data by scrapping Correios' HTML server response.
 * 
 * Example of tracking an object in another thread:
 * 
 * <pre>
 *   Rastreio.track("JT124720455BR", new Rastreio.Listener() {
 *     public void onSuccess(TrackObject trackObject) {
 *       // Use this tracking object
 *     }
 *   
 *     public void onFailure(Exception e) {
 *       // Report exception
 *       e.printStackTrace();
 *     }
 *   });
 * </pre>
 * 
 * See {@link Rastreio#track(String, Listener)} for more information.
 * 
 * Also it is possible to wait until operation is completed in the same thread:
 * 
 * <pre>
 *   try {
 *     TrackObject trackObject = Rastreio.trackSync("JT124720455BR");
 *     // Use this tracking object
 *   } catch (IOException e) {
 *     // Report exception
 *     e.printStackTrace();
 *   }
 * </pre>
 * 
 * See {@link Rastreio#trackSync(String)} for more information.
 * 
 * @see Listener
 * @see TrackObject
 */
public class Rastreio {
  private static final OkHttpClient HTTP_CLIENT = new OkHttpClient();
  private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss SSS");

  private Rastreio() {}

  /**
   * Track an object by its code asynchronously.
   * 
   * When track operation finishes listener is called with result.
   * 
   * @param objectCode string representing object track code
   * @param listener listener to be called when object tracking is completed
   * @throws NullPointerException if {@code objectCode} or {@code listener} is null
   * @throws IllegalArgumentException if {@code objectCode} is empty or invalid
   * @see Listener
   * @see TrackObject
   */
  public static void track(String objectCode, Listener listener) {
    if (objectCode == null || listener == null) {
      throw new NullPointerException("Rastreio.track: null listener or object code");
    }
    // Validate object code
    if (objectCode.isEmpty() || !TrackObject.Code.validate(objectCode)) {
      throw new IllegalArgumentException("Rastreio.track: invalid object code");
    }
    HTTP_CLIENT.newCall(newRequest(objectCode)).enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        listener.onFailure(new Exception("Rastreio.track: unable to fullfill HTTP request", e));
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        if (response == null || !response.isSuccessful()) {
          listener.onFailure(new IOException("Rastreio.track: erroneous HTTP response " + response));
        }
        try (ResponseBody responseBody = response.body()) {
          // Parse response and notify listener about new tacking object
          listener.onSuccess(parseResponse(objectCode, responseBody.string()));
        } catch (IOException e) {
          listener.onFailure(new Exception("Rastreio.track: unable to fullfill HTTP request", e));
        }
      }
    });
  }

  /**
   * Track an object by its code synchronously.
   * 
   * @param objectCode string representing object track code
   * @throws IOException if an network error occur
   * @throws NullPointerException if {@code objectCode} is null
   * @throws IllegalArgumentException if {@code objectCode} is empty or invalid
   * @return new tracking object to query tracking data
   */
  public static TrackObject trackSync(String objectCode) throws IOException {
    if (objectCode == null) {
      throw new NullPointerException("Rastreio.trackSync: null object code");
    }
    // Validate object code
    if (objectCode.isEmpty() || !TrackObject.Code.validate(objectCode)) {
      throw new IllegalArgumentException("Rastreio.trackSync: invalid object code");
    }
    try (Response response = HTTP_CLIENT.newCall(newRequest(objectCode)).execute()) {
      if (!response.isSuccessful()) {
        throw new IOException("Rastreio.trackSync: erroneous HTTP response code " + response);
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
      .build();

    Request request = new Request.Builder()
      .url(Magic.URL)
      .post(formBody)
      .build();
    
    return request;
  }

  /**
   * Parse response data and create new tracking object.
   * @param objectCode tracking object code
   * @param response response data to be parsed
   * @return new tracking object
   */
  private static TrackObject parseResponse(String objectCode, String response) {
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

    for (Element eventListItem : elements.first().getElementsByTag("tr")) {
      // Event data
      String locale = null;
      String description = null;
      String details = null;
      String eventDate = null;
      String eventTime = null;

      elements = eventListItem.getElementsByTag("td");

      if (elements.size() != 2) {
        System.out.println("Rastreio.parseResponse: couldn't find enough table data elements");
        continue; // Skip invalid table row
      }

      Element eventListFirstData = elements.first();
      Element eventListLastData = elements.last();

      String eventListFirstDataHtml = eventListFirstData.html();
      String[] eventListFirstDataPieces = eventListFirstDataHtml.trim().split("<br>");

      if (eventListFirstDataPieces.length != 3) {
        System.out.println("Rastreio.parseResponse: couldn't parse first table data element properly");
        continue; // Skip invalid table row
      }

      eventDate = eventListFirstDataPieces[0].trim();
      eventTime = eventListFirstDataPieces[1].trim();

      elements = eventListFirstData.getElementsByTag("label");

      if (!elements.isEmpty()) {
        locale = elements.first().text().trim();
      } else {
        locale = eventListFirstDataPieces[2].trim();
      }

      String eventListLastDataHtml = eventListLastData.html();
      String[] eventListLastDataPieces = eventListLastDataHtml.trim().split("<br>");

      elements = eventListLastData.getElementsByTag("strong");

      if (!elements.isEmpty()) {
        // Get `strong` node content
        description = elements.first().text().trim();
      } else if (eventListLastDataPieces.length > 0) {
        // Get first string element as event description
        description = eventListLastDataPieces[0].trim();
      } 
      
      if (description == null || description.isEmpty()) {
        System.out.println("Rastreio.parseResponse: couldn't parse last table data element properly");
        continue; // Skip invalid table row
      }

      if (eventListLastDataPieces.length > 1) {
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

  public static interface Listener {
    /**
     * Called when object tracking is completed with success
     * @param trackObject tracking object result
     */
    void onSuccess(TrackObject trackObject);

    /**
     * Called when object tracking fails
     * @param exception failure explanation
     */
    void onFailure(Exception exception);
  }
}