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

      fail("Should have thrown NullPointerException");
    } catch (NullPointerException e) {
      assertTrue(true);
    } catch (Exception e) {
      fail(e.getMessage());
    }

    try {
      Rastreio.track("JT124720455BR", null);

      fail("Should have thrown NullPointerException");
    } catch (NullPointerException e) {
      assertTrue(true);
    } catch (Exception e) {
      fail(e.getMessage());
    }

    try {
      Rastreio.track("", dummyListener);

      fail("Should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    } catch (Exception e) {
      fail(e.getMessage());
    }

    try {
      Rastreio.track("JT124720455BR", new Rastreio.Listener() {
      
        @Override
        public void onSuccess(TrackObject trackObject) {
          assertNotNull(trackObject);
          assertEquals("JT124720455BR", trackObject.getCode());
          assertFalse(trackObject.isValid());
          assertEquals(Error.OBJECT_NOT_FOUND, trackObject.getError());
        }
      
        @Override
        public void onFailure(Exception e) {
          fail(e.getMessage());
        }
      });
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testTrackSync() {
    try {
      Rastreio.trackSync(null);

      fail("Should have thrown NullPointerException");
    } catch (NullPointerException e) {
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
      assertFalse(trackObject.isValid());
      assertEquals(Error.OBJECT_NOT_FOUND, trackObject.getError());
    } catch (IOException e) {
      fail(e.getMessage());
    }

    try {
      TrackObject trackObject = Rastreio.trackSync("LO637869431CN");

      Calendar calendar = Calendar.getInstance();

      assertNotNull(trackObject);
      assertEquals("LO637869431CN", trackObject.getCode());
      assertTrue(trackObject.isValid());
      assertTrue(trackObject.isDelivered());
      assertEquals(Error.NO_ERROR, trackObject.getError());
      calendar.set(2019, 11, 17, 13, 22, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), trackObject.getPostedAt());
      calendar.set(2020, 1, 5, 14, 52, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), trackObject.getUpdatedAt());
      assertNotNull(trackObject.getEvents());
      assertEquals(10, trackObject.getEvents().size());
      // First event
      TrackObject.Event event = trackObject.getEvents().get(0);
      assertNotNull(event);
      assertEquals("Objeto postado", event.getDescription());
      assertNull(event.getDetails());
      assertEquals("CHINA /", event.getLocale());
      calendar.set(2019, 11, 17, 13, 22, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // Event with details
      event = trackObject.getEvents().get(5);
      assertNotNull(event);
      assertEquals("Objeto encaminhado", event.getDescription());
      assertEquals("de Unidade de Distribuição em CURITIBA / PR para Unidade de Tratamento em CAJAMAR / SP", event.getDetails());
      assertEquals("CURITIBA / PR", event.getLocale());
      calendar.set(2020, 0, 28, 10, 2, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // Last event
      event = trackObject.getEvents().get(9);
      assertNotNull(event);
      assertEquals("Objeto entregue ao destinatário", event.getDescription());
      assertNull(event.getDetails());
      assertEquals("Extremoz / RN", event.getLocale());
      calendar.set(2020, 1, 5, 14, 52, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
    } catch (IOException e) {
      fail(e.getMessage());
    }

    try {
      TrackObject trackObject = Rastreio.trackSync("LB107580877SG");

      Calendar calendar = Calendar.getInstance();

      assertNotNull(trackObject);
      assertEquals("LB107580877SG", trackObject.getCode());
      assertTrue(trackObject.isValid());
      assertTrue(trackObject.isDelivered());
      assertEquals(Error.NO_ERROR, trackObject.getError());
      calendar.set(2020, 0, 16, 21, 2, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), trackObject.getPostedAt());
      calendar.set(2020, 1, 11, 15, 44, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), trackObject.getUpdatedAt());
      assertNotNull(trackObject.getEvents());
      assertEquals(9, trackObject.getEvents().size());
      // First event
      TrackObject.Event event = trackObject.getEvents().get(0);
      assertNotNull(event);
      assertEquals("Objeto encaminhado", event.getDescription());
      assertEquals("de País em CINGAPURA / para País em Unidade de Tratamento Internacional / BR", event.getDetails());
      assertEquals("CINGAPURA /", event.getLocale());
      calendar.set(2020, 0, 16, 21, 2, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // Event with details
      event = trackObject.getEvents().get(5);
      assertNotNull(event);
      assertEquals("Objeto encaminhado", event.getDescription());
      assertEquals("de Unidade de Tratamento em RECIFE / PE para Unidade de Distribuição em NATAL / RN", event.getDetails());
      assertEquals("RECIFE / PE", event.getLocale());
      calendar.set(2020, 0, 30, 23, 0, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // Last event
      event = trackObject.getEvents().get(8);
      assertNotNull(event);
      assertEquals("Objeto entregue ao destinatário", event.getDescription());
      assertNull(event.getDetails());
      assertEquals("Natal / RN", event.getLocale());
      calendar.set(2020, 1, 11, 15, 44, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }
}
