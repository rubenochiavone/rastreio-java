package rastreio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Calendar;
import okhttp3.OkHttpClient;
import org.junit.Test;

public class RastreioTest {
  @Test
  public void testTrack() {
    final long syncTimeout = (long) new OkHttpClient().readTimeoutMillis();

    Implementation[] implementations = new Implementation[] {
      new EnhancedImplementation(),
      new DefaultImplementation()
    };

    for (Implementation implementation : implementations) {
      try {
        Rastreio.setImplementation(implementation);
      } catch (Exception e) {
        fail(e.getMessage());
      }

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
        Rastreio.track("invalid", dummyListener);
  
        fail("Should have thrown IllegalArgumentException");
      } catch (IllegalArgumentException e) {
        assertTrue(true);
      } catch (Exception e) {
        fail(e.getMessage());
      }

      try {
        final Object syncObject = new Object();

        Rastreio.track("JT124720455BR", new Rastreio.Listener() {
        
          @Override
          public void onSuccess(TrackObject trackObject) {
            synchronized (syncObject) {
              syncObject.notify();
            }

            assertNotNull(trackObject);
            assertEquals("JT124720455BR", trackObject.getCode());
            assertEquals(TrackObjectServiceType.JT, trackObject.getServiceType());
            assertEquals("JT", trackObject.getServiceType().getInitials());
            assertEquals("REGISTRADO URGENTE", trackObject.getServiceType().getDescription());
            assertFalse(trackObject.isValid());
            assertEquals(Error.OBJECT_NOT_FOUND, trackObject.getError());
          }
        
          @Override
          public void onFailure(Exception e) {
            synchronized (syncObject) {
              syncObject.notify();
            }

            fail(e.getMessage());
          }
        });

        synchronized (syncObject) {
          syncObject.wait(syncTimeout);
        }
      } catch (Exception e) {
        fail(e.getMessage());
      }
    }
  }

  @Test
  public void testTrackSync() {
    final Calendar calendar = Calendar.getInstance();

    Implementation[] implementations = new Implementation[] {
      new EnhancedImplementation(),
      new DefaultImplementation()
    };

    for (Implementation implementation : implementations) {
      try {
        Rastreio.setImplementation(implementation);
      } catch (Exception e) {
        fail(e.getMessage());
      }

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
        Rastreio.trackSync("invalid");
  
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
        assertEquals(TrackObjectServiceType.JT, trackObject.getServiceType());
        assertEquals("JT", trackObject.getServiceType().getInitials());
        assertEquals("REGISTRADO URGENTE", trackObject.getServiceType().getDescription());
        assertFalse(trackObject.isValid());
        assertEquals(Error.OBJECT_NOT_FOUND, trackObject.getError());
      } catch (IOException e) {
        fail(e.getMessage());
      }

      try {
        TrackObject trackObject = Rastreio.trackSync("LO637869431CN");

        assertNotNull(trackObject);
        assertEquals("LO637869431CN", trackObject.getCode());
        assertEquals(TrackObjectServiceType.UNKNOWN, trackObject.getServiceType());
        assertEquals("", trackObject.getServiceType().getInitials());
        assertEquals("", trackObject.getServiceType().getDescription());
        assertFalse(trackObject.isValid());
        assertEquals(Error.OBJECT_NOT_FOUND, trackObject.getError());
      } catch (IOException e) {
        fail(e.getMessage());
      }

      try {
        TrackObject trackObject = Rastreio.trackSync("LB107580877SG");

        assertNotNull(trackObject);
        assertEquals("LB107580877SG", trackObject.getCode());
        assertEquals(TrackObjectServiceType.LB, trackObject.getServiceType());
        assertEquals("LB", trackObject.getServiceType().getInitials());
        assertEquals("LOGÍSTICA REVERSA SIMULTÂNEA SEDEX",
            trackObject.getServiceType().getDescription());
        assertFalse(trackObject.isValid());
        assertEquals(Error.OBJECT_NOT_FOUND, trackObject.getError());
      } catch (IOException e) {
        fail(e.getMessage());
      }

      try {
        TrackObject trackObject = Rastreio.trackSync("RH117939038TR");

        assertNotNull(trackObject);
        assertEquals("RH117939038TR", trackObject.getCode());
        assertEquals(TrackObjectServiceType.RH, trackObject.getServiceType());
        assertEquals("RH", trackObject.getServiceType().getInitials());
        assertEquals("REGISTRADO COM AR DIGITAL", trackObject.getServiceType().getDescription());
        assertFalse(trackObject.isValid());
        assertEquals(Error.OBJECT_NOT_FOUND, trackObject.getError());
      } catch (IOException e) {
        fail(e.getMessage());
      }

      try {
        TrackObject trackObject = Rastreio.trackSync("LO823618663CN");

        assertNotNull(trackObject);
        assertEquals("LO823618663CN", trackObject.getCode());
        assertEquals(TrackObjectServiceType.UNKNOWN, trackObject.getServiceType());
        assertFalse(trackObject.isValid());
        assertEquals(Error.OBJECT_NOT_FOUND, trackObject.getError());
      } catch (IOException e) {
        fail(e.getMessage());
      }

      try {
        TrackObject trackObject = Rastreio.trackSync("LX639826650CN");

        assertNotNull(trackObject);
        assertEquals("LX639826650CN", trackObject.getCode());
        assertEquals(TrackObjectServiceType.LX, trackObject.getServiceType());
        assertEquals("LX", trackObject.getServiceType().getInitials());
        assertEquals("OBJETO INTERNACIONAL PACKET ECONOMIC",
            trackObject.getServiceType().getDescription());
        assertFalse(trackObject.isValid());
        assertEquals(Error.OBJECT_NOT_FOUND, trackObject.getError());
      } catch (IOException e) {
        fail(e.getMessage());
      }
      
      try {
        TrackObject trackObject = Rastreio.trackSync("LB941561336SE");

        assertNotNull(trackObject);
        assertEquals("LB941561336SE", trackObject.getCode());
        assertEquals("LB", trackObject.getServiceType().getInitials());
        assertEquals("LOGÍSTICA REVERSA SIMULTÂNEA SEDEX",
            trackObject.getServiceType().getDescription());
        assertTrue(trackObject.isValid());
        assertTrue(trackObject.isDelivered());
        assertEquals(Error.NO_ERROR, trackObject.getError());
        calendar.set(2020, 11, 12, 9, 56, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), trackObject.getPostedAt());
        calendar.set(2021, 0, 11, 15, 17, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), trackObject.getUpdatedAt());
        assertNotNull(trackObject.getEvents());
        assertEquals(8, trackObject.getEvents().size());
        // First event
        TrackObject.Event event = trackObject.getEvents().get(0);
        assertNotNull(event);
        assertEquals("Objeto recebido pelos Correios do Brasil", event.getDescription());
        assertNull(event.getDetails());
        assertEquals("CURITIBA / PR", event.getLocale());
        calendar.set(2020, 11, 12, 9, 56, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), event.getTrackedAt());
        // Last event
        event = trackObject.getEvents().get(7);
        assertNotNull(event);
        assertEquals("Objeto entregue ao destinatário",
            event.getDescription());
        assertNull(event.getDetails());
        assertEquals("Extremoz / RN", event.getLocale());
        calendar.set(2021, 0, 11, 15, 17, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), event.getTrackedAt());
      } catch (IOException e) {
        fail(e.getMessage());
      }

      try {
        TrackObject trackObject = Rastreio.trackSync("LB918031405SE");

        assertNotNull(trackObject);
        assertEquals("LB918031405SE", trackObject.getCode());
        assertEquals(TrackObjectServiceType.LB, trackObject.getServiceType());
        assertEquals("LB", trackObject.getServiceType().getInitials());
        assertEquals("LOGÍSTICA REVERSA SIMULTÂNEA SEDEX",
            trackObject.getServiceType().getDescription());
        assertTrue(trackObject.isValid());
        assertTrue(trackObject.isDelivered());
        assertEquals(Error.NO_ERROR, trackObject.getError());
        calendar.set(2020, 10, 30, 9, 53, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), trackObject.getPostedAt());
        calendar.set(2020, 11, 10, 15, 37, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), trackObject.getUpdatedAt());
        assertNotNull(trackObject.getEvents());
        assertEquals(6, trackObject.getEvents().size());
        // First event
        TrackObject.Event event = trackObject.getEvents().get(0);
        assertNotNull(event);
        assertEquals("Fiscalização aduaneira finalizada", event.getDescription());
        assertNull(event.getDetails());
        assertEquals("CURITIBA / PR", event.getLocale());
        calendar.set(2020, 10, 30, 9, 53, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), event.getTrackedAt());
        // Event with details
        event = trackObject.getEvents().get(1);
        assertNotNull(event);
        assertEquals("Objeto em trânsito - por favor aguarde", event.getDescription());
        assertEquals(
            "de Unidade de Logística Integrada em CURITIBA / PR para Unidade de Tratamento em "
            + "CAJAMAR / SP",
            event.getDetails());
        assertEquals("CURITIBA / PR", event.getLocale());
        calendar.set(2020, 10, 30, 9, 55, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), event.getTrackedAt());
        // Last event
        event = trackObject.getEvents().get(5);
        assertNotNull(event);
        assertEquals("Objeto entregue ao destinatário", event.getDescription());
        assertNull(event.getDetails());
        assertEquals("Extremoz / RN", event.getLocale());
        calendar.set(2020, 11, 10, 15, 37, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), event.getTrackedAt());
      } catch (IOException e) {
        fail(e.getMessage());
      }

      try {
        TrackObject trackObject = Rastreio.trackSync("LB929795602SE");

        assertNotNull(trackObject);
        assertEquals("LB929795602SE", trackObject.getCode());
        assertEquals("LB", trackObject.getServiceType().getInitials());
        assertEquals("LOGÍSTICA REVERSA SIMULTÂNEA SEDEX",
            trackObject.getServiceType().getDescription());
        assertTrue(trackObject.isValid());
        assertTrue(trackObject.isDelivered());
        assertEquals(Error.NO_ERROR, trackObject.getError());
        calendar.set(2021, 0, 19, 9, 58, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), trackObject.getPostedAt());
        calendar.set(2021, 0, 27, 13, 55, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), trackObject.getUpdatedAt());
        assertNotNull(trackObject.getEvents());
        assertEquals(7, trackObject.getEvents().size());
        // First event
        TrackObject.Event event = trackObject.getEvents().get(0);
        assertNotNull(event);
        assertEquals("Objeto recebido pelos Correios do Brasil", event.getDescription());
        assertNull(event.getDetails());
        assertEquals("CURITIBA / PR", event.getLocale());
        calendar.set(2021, 0, 19, 9, 58, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), event.getTrackedAt());
        // Last event
        event = trackObject.getEvents().get(6);
        assertNotNull(event);
        assertEquals("Objeto entregue ao destinatário",
            event.getDescription());
        assertNull(event.getDetails());
        assertEquals("Extremoz / RN", event.getLocale());
        calendar.set(2021, 0, 27, 13, 55, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), event.getTrackedAt());
      } catch (IOException e) {
        fail(e.getMessage());
      }

      try {
        TrackObject trackObject = Rastreio.trackSync("OL221353180BR");

        assertNotNull(trackObject);
        assertEquals("OL221353180BR", trackObject.getCode());
        assertEquals(TrackObjectServiceType.UNKNOWN, trackObject.getServiceType());
        assertFalse(trackObject.isValid());
        assertEquals(Error.OBJECT_NOT_FOUND, trackObject.getError());
      } catch (IOException e) {
        fail(e.getMessage());
      }
    }
  }

  @Test
  public void testSetImplementation() {
    try {
      Rastreio.setImplementation(null);

      fail("Should have thrown NullPointerException");
    } catch (NullPointerException e) {
      assertTrue(true);
    } catch (Exception e) {
      fail(e.getMessage());
    }

    try {
      Rastreio.setImplementation(new EnhancedImplementation());
    } catch (Exception e) {
      fail(e.getMessage());
    }

    try {
      Rastreio.setImplementation(new DefaultImplementation());
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }
}
