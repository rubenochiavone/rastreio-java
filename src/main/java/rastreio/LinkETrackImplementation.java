package rastreio;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import okhttp3.Request;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Implementation for Link&Track API available at https://github.com/chipytux/correiosApi.
 */
public class LinkETrackImplementation extends ImplementationWithUrlToken {

  /**
   * Create new request object.
   * @param objectCode tracking object code
   * @return new request object
   */
  @Override
  protected Request newRequest(String objectCode) {
    Request request = new Request.Builder()
        .url(mUrlToken + "&codigo=" + objectCode)
        .method("GET", null)
        .build();
    
    return request;
  }

  /**
   * Parse response data and create new tracking object.
   * @param objectCode tracking object code
   * @param response response data to be parsed
   * @return new tracking object
   */
  @Override
  protected TrackObject parseResponse(String objectCode, String response) {
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
    
    JSONObject jsonObject = new JSONObject(response);
    JSONArray eventsJson = jsonObject.getJSONArray("eventos");

    ArrayList<TrackObject.Event> events = new ArrayList<TrackObject.Event>();

    for (int i = 0; i < eventsJson.length(); i++) {
      JSONObject eventJson = eventsJson.getJSONObject(i);
      TrackObject.Event event = new TrackObject.Event();

      event.setLocale(eventJson.getString("local"));
      event.setDescription(eventJson.getString("status"));

      if (eventJson.has("subStatus")) {
        JSONArray subStatuses = eventJson.getJSONArray("subStatus");
        event.setDetails(subStatuses.length() > 0
            ? subStatuses.getString(0) : null);
      } else {
        event.setDetails(null);
      }

      try {
        event.setTrackedAt(DATE_FORMAT.parse(eventJson.getString("data")
            + " " + eventJson.getString("hora") + ":00 000"));
      } catch (ParseException e) {
        System.out.println("Rastreio.parseResponse: couldn't parse event date and time properly");
        continue; // Skip invalid table row
      }

      events.add(0, event);
    }

    if (events.isEmpty()) {
      return trackObject;
    }
    
    events.sort(new Comparator<TrackObject.Event>() {
      @Override
      public int compare(TrackObject.Event e1, TrackObject.Event e2) {
        return e1.getTrackedAt() != null
            && e2.getTrackedAt() != null
            ? e1.getTrackedAt().compareTo(e2.getTrackedAt())
            : 0;
      }
    });

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
}
