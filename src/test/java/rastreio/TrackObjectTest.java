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
    assertFalse(trackObject.isDelivered());
    assertFalse(trackObject.isValid());
  }

  @Test
  public void testEventDefaultCtor() {
    TrackObject.Event event = new TrackObject.Event();
    assertNull(event.getDescription());
    assertNull(event.getDetails());
    assertNull(event.getLocale());
    assertNull(event.getTrackedAt());
  }

  @Test
  public void testValidateObjectCode() {
    // Invalid object codes
    assertFalse(TrackObject.Code.validate(null));
    assertFalse(TrackObject.Code.validate(""));
    assertFalse(TrackObject.Code.validate("ab999cd"));
    assertFalse(TrackObject.Code.validate("AB12345678CD"));
    assertFalse(TrackObject.Code.validate("Lorem Ipsum is simply dummy text of the printing and typesetting industry."));

    // Valid object codes
    assertTrue(TrackObject.Code.validate("AB123456789CD"));
    assertTrue(TrackObject.Code.validate("JT124720455BR"));
    assertTrue(TrackObject.Code.validate("LO637869431CN"));
    assertTrue(TrackObject.Code.validate("LB107580877SG"));
  }
}
