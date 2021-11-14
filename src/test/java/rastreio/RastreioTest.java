package rastreio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import okhttp3.OkHttpClient;
import org.junit.Before;
import org.junit.Test;

public class RastreioTest {

  private static String urlToken = null;

  private Implementation[] getAllImplementations() {
    @SuppressWarnings("serial")
    List<Implementation> implementations = new ArrayList<Implementation>() {
      public boolean add(Implementation implementation) {
        if (implementation instanceof ImplementationWithUrlToken) {
          ((ImplementationWithUrlToken) implementation).setUrlToken(urlToken);
        }

        return super.add(implementation);
      }
    };

    if (urlToken != null) {
      implementations.add(new LinkETrackImplementation());
    }

    return implementations.toArray(new Implementation[implementations.size()]);
  }

  private void sleepIfNeeded(Implementation implementation) throws InterruptedException {
    if (implementation instanceof LinkETrackImplementation) {
      // LinkETrack blocks multiple requests in little time intervals
      Thread.sleep(1000);
    }
  }

  /**
   * Run before tests execution.
   */
  @Before
  public void init() {
    try {
      urlToken = Util.getResourceFileAsString("url_token.txt");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testTrack() {
    final long syncTimeout = (long) new OkHttpClient().readTimeoutMillis();

    Implementation[] implementations = getAllImplementations();

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
  public void testTrackSync() throws InterruptedException {
    final Calendar calendar = Calendar.getInstance();

    Implementation[] implementations = getAllImplementations();

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

      sleepIfNeeded(implementation);

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

      sleepIfNeeded(implementation);

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

      sleepIfNeeded(implementation);

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

      sleepIfNeeded(implementation);

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

      sleepIfNeeded(implementation);

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

      sleepIfNeeded(implementation);

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

      sleepIfNeeded(implementation);
      
      try {
        TrackObject trackObject = Rastreio.trackSync("QG961780962BR");

        assertNotNull(trackObject);
        assertEquals("QG961780962BR", trackObject.getCode());
        assertEquals("QG", trackObject.getServiceType().getInitials());
        assertEquals("ETIQUETA LÓGICA PAC",
            trackObject.getServiceType().getDescription());
        assertTrue(trackObject.isValid());
        assertTrue(trackObject.isDelivered());
        assertEquals(Error.NO_ERROR, trackObject.getError());
        calendar.set(2021, 8, 16, 19, 49, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), trackObject.getPostedAt());
        calendar.set(2021, 8, 27, 12, 23, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), trackObject.getUpdatedAt());
        assertNotNull(trackObject.getEvents());
        assertEquals(6, trackObject.getEvents().size());
        // First event
        TrackObject.Event event = trackObject.getEvents().get(0);
        assertNotNull(event);
        assertEquals("Objeto postado após o horário limite da unidade", event.getDescription());
        assertNull(event.getDetails());
        assertEquals("Agência dos Correios/SAO PAULO/SP", event.getLocale());
        calendar.set(2021, 8, 16, 19, 49, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), event.getTrackedAt());
        // Last event
        event = trackObject.getEvents().get(5);
        assertNotNull(event);
        assertEquals("Objeto entregue ao destinatário",
            event.getDescription());
        assertNull(event.getDetails());
        assertEquals("Agência dos Correios/Extremoz/RN", event.getLocale());
        calendar.set(2021, 8, 27, 12, 23, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), event.getTrackedAt());
      } catch (IOException e) {
        fail(e.getMessage());
      }

      sleepIfNeeded(implementation);

      try {
        TrackObject trackObject = Rastreio.trackSync("LB918031405SE");

        assertNotNull(trackObject);
        assertEquals("LB918031405SE", trackObject.getCode());
        assertEquals(TrackObjectServiceType.LB, trackObject.getServiceType());
        assertEquals("LB", trackObject.getServiceType().getInitials());
        assertEquals("LOGÍSTICA REVERSA SIMULTÂNEA SEDEX",
            trackObject.getServiceType().getDescription());
        assertFalse(trackObject.isValid());
        assertFalse(trackObject.isDelivered());
        assertEquals(Error.OBJECT_NOT_FOUND, trackObject.getError());
      } catch (IOException e) {
        fail(e.getMessage());
      }

      sleepIfNeeded(implementation);

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

    try {
      Rastreio.setImplementation(new LinkETrackImplementation());
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }
}
