package rastreio;

import java.io.IOException;
import java.util.Calendar;

import org.junit.Test;
import static org.junit.Assert.*;

public class RastreioTest {
  @Test
  public void testTrack() {
    Rastreio.Listener dummyListener = new Rastreio.Listener() {
      @Override
      public void onSuccess(TrackObject trackObject) {
      }

      @Override
      public void onFailure(Exception e) {
      }
    };

    try {
      Rastreio.track(null, dummyListener);

      fail("Should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    } catch (IOException e) {
      fail(e.getMessage());
    }

    try {
      Rastreio.track("", dummyListener);

      fail("Should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    } catch (IOException e) {
      fail(e.getMessage());
    }

    try {
      Rastreio.track("JT124720455BR", new Rastreio.Listener() {
      
        @Override
        public void onSuccess(TrackObject trackObject) {
          assertNotNull(trackObject);
          assertEquals("JT124720455BR", trackObject.getCode());
          assertFalse(trackObject.IsValid());
          assertEquals(Error.OBJECT_NOT_FOUND, trackObject.getError());
        }
      
        @Override
        public void onFailure(Exception e) {
          fail(e.getMessage());
        }
      });
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testTrackSync() {
    try {
      Rastreio.trackSync(null);

      fail("Should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    } catch (IOException e) {
      fail(e.getMessage());
    }

    try {
      Rastreio.trackSync("");

      fail("Should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    } catch (IOException e) {
      fail(e.getMessage());
    }
    
    try {
      TrackObject trackObject = Rastreio.trackSync("JT124720455BR");

      assertNotNull(trackObject);
      assertEquals("JT124720455BR", trackObject.getCode());
      assertFalse(trackObject.IsValid());
      assertEquals(Error.OBJECT_NOT_FOUND, trackObject.getError());
    } catch (IOException e) {
      fail(e.getMessage());
    }

    try {
      TrackObject trackObject = Rastreio.trackSync("LO637869431CN");

      Calendar calendar = Calendar.getInstance();

      assertNotNull(trackObject);
      assertEquals("LO637869431CN", trackObject.getCode());
      assertTrue(trackObject.IsValid());
      assertTrue(trackObject.IsDelivered());
      assertEquals(Error.NO_ERROR, trackObject.getError());
      calendar.set(2019, 11, 17, 13, 22, 0);
      assertEquals(calendar.getTime().getDate(), trackObject.getPostedAt().getDate());
      assertEquals(calendar.getTime().getMonth(), trackObject.getPostedAt().getMonth());
      assertEquals(calendar.getTime().getYear(), trackObject.getPostedAt().getYear());
      assertEquals(calendar.getTime().getHours(), trackObject.getPostedAt().getHours());
      assertEquals(calendar.getTime().getMinutes(), trackObject.getPostedAt().getMinutes());
      calendar.set(2020, 1, 5, 14, 52, 0);
      assertEquals(calendar.getTime().getDate(), trackObject.getUpdatedAt().getDate());
      assertEquals(calendar.getTime().getMonth(), trackObject.getUpdatedAt().getMonth());
      assertEquals(calendar.getTime().getYear(), trackObject.getUpdatedAt().getYear());
      assertEquals(calendar.getTime().getHours(), trackObject.getUpdatedAt().getHours());
      assertEquals(calendar.getTime().getMinutes(), trackObject.getUpdatedAt().getMinutes());
      assertNotNull(trackObject.getEvents());
      assertEquals(10, trackObject.getEvents().size());
      // First event
      TrackObject.Event event = trackObject.getEvents().get(0);
      assertNotNull(event);
      assertEquals("Objeto postado", event.getDescription());
      assertNull(event.getDetails());
      assertEquals("CHINA /", event.getLocale());
      // Event with details
      event = trackObject.getEvents().get(5);
      assertNotNull(event);
      assertEquals("Objeto encaminhado", event.getDescription());
      assertEquals("de Unidade de Distribuição em CURITIBA / PR para Unidade de Tratamento em CAJAMAR / SP", event.getDetails());
      assertEquals("CURITIBA / PR", event.getLocale());
      // Last event
      event = trackObject.getEvents().get(9);
      assertNotNull(event);
      assertEquals("Objeto entregue ao destinatário", event.getDescription());
      assertNull(event.getDetails());
      assertEquals("Extremoz / RN", event.getLocale());
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }
}
