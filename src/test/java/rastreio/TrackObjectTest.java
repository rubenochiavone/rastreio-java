package rastreio;

import org.junit.Test;
import static org.junit.Assert.*;

public class TrackObjectTest {
  @Test
  public void testDefaultCtor() {
    TrackObject trackObject = new TrackObject();
    assertNull(trackObject.getCode());
    assertNull(trackObject.getEvents());
    assertNull(trackObject.getPostedAt());
    assertNull(trackObject.getUpdatedAt());
    assertNull(trackObject.getError());
    assertFalse(trackObject.IsDelivered());
    assertFalse(trackObject.IsValid());
  }

  @Test
  public void testEventDefaultCtor() {
    TrackObject.Event event = new TrackObject.Event();
    assertNull(event.getDescription());
    assertNull(event.getDetails());
    assertNull(event.getLocale());
    assertNull(event.getTrackedAt());
  }
}
