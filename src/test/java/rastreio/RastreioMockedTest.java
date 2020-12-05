package rastreio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Calendar;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Rastreio test using mock infrastructure.
 */
public class RastreioMockedTest {
  MockWebServer mMockWebServer = null;

  /**
   * Configures mocked web server to run.
   */
  @Before
  public void setupServer() {
    assertNull(mMockWebServer);
    try {
      mMockWebServer = Util.setupMockWebServer();
    } catch (Exception e) {
      fail(e.getMessage());
    }
    assertNotNull(mMockWebServer);
  }

  /**
   * Shuts down mocked web server.
   */
  @After
  public void tearDownServer() {
    assertNotNull(mMockWebServer);
    Util.tearDownMockWebServer(mMockWebServer);
    mMockWebServer = null;
    assertNull(mMockWebServer);
  }

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
      Rastreio.track("invalid", dummyListener);

      fail("Should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    } catch (Exception e) {
      fail(e.getMessage());
    }

    final long syncTimeout = 2000L;

    try {
      final Object syncObject = new Object();

      Util.enqueueMockResponseFromFile(mMockWebServer, "JT124720455BR.html");

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

    // Kill mocked server to simulate server down
    try {
      Util.tearDownMockWebServer(mMockWebServer, true);
      mMockWebServer = null;

      final Object syncObject = new Object();

      Rastreio.track("JT124720455BR", new Rastreio.Listener() {
      
        @Override
        public void onSuccess(TrackObject trackObject) {
          synchronized (syncObject) {
            syncObject.notify();
          }

          fail("Tracking object without server configured should NOT succeed");
        }
      
        @Override
        public void onFailure(Exception e) {
          synchronized (syncObject) {
            syncObject.notify();
          }

          assertNotNull(e);
          assertNotNull(e.getMessage());
        }
      });

      synchronized (syncObject) {
        syncObject.wait(syncTimeout);
      }

      // Restart mocked server
      mMockWebServer = Util.setupMockWebServer();
    } catch (Exception e) {
      fail(e.getMessage());
    }

    // Mock response to cover edge cases
    try {
      final Object syncObject = new Object();

      Util.enqueueMockResponseFromFile(mMockWebServer, "mocked.html");

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
          assertNull(trackObject.getEvents());
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

    // Force unexpected response
    try {
      final Object syncObject = new Object();

      Util.enqueueMockResponseFromFile(mMockWebServer, "invalid.txt");

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

    // Force server response with 500 status code
    try {
      final Object syncObject = new Object();

      Util.enqueueMockResponseFromStatusCode(mMockWebServer, 500);

      Rastreio.track("JT124720455BR", new Rastreio.Listener() {
      
        @Override
        public void onSuccess(TrackObject trackObject) {
          synchronized (syncObject) {
            syncObject.notify();
          }

          fail("Tracking object with 5xx status code should NOT succeed");
        }
      
        @Override
        public void onFailure(Exception e) {
          synchronized (syncObject) {
            syncObject.notify();
          }

          assertNotNull(e);
          assertNotNull(e.getMessage());
        }
      });

      synchronized (syncObject) {
        syncObject.wait(syncTimeout);
      }
    } catch (Exception e) {
      fail(e.getMessage());
    }

    // Force server response timeout
    try {
      final Object syncObject = new Object();

      Util.enqueueMockResponseWithNoResponse(mMockWebServer);

      Rastreio.track("JT124720455BR", new Rastreio.Listener() {
      
        @Override
        public void onSuccess(TrackObject trackObject) {
          synchronized (syncObject) {
            syncObject.notify();
          }

          fail("Tracking object with no response should NOT succeed");
        }
      
        @Override
        public void onFailure(Exception e) {
          synchronized (syncObject) {
            syncObject.notify();
          }

          assertNotNull(e);
          assertNotNull(e.getMessage());
        }
      });

      synchronized (syncObject) {
        syncObject.wait(syncTimeout);
      }
    } catch (Exception e) {
      fail(e.getMessage());
    }

    // Force no body at server response
    try {
      final Object syncObject = new Object();

      Util.enqueueMockResponseWithNoResponseBody(mMockWebServer);

      Rastreio.track("JT124720455BR", new Rastreio.Listener() {
      
        @Override
        public void onSuccess(TrackObject trackObject) {
          synchronized (syncObject) {
            syncObject.notify();
          }

          fail("Tracking object with no response body should NOT succeed");
        }
      
        @Override
        public void onFailure(Exception e) {
          synchronized (syncObject) {
            syncObject.notify();
          }

          assertNotNull(e);
          assertNotNull(e.getMessage());
        }
      });

      synchronized (syncObject) {
        syncObject.wait(syncTimeout);
      }
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testTrackSync() {
    final Calendar calendar = Calendar.getInstance();

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
      Util.enqueueMockResponseFromFile(mMockWebServer, "JT124720455BR.html");
    } catch (Exception e) {
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
      Util.enqueueMockResponseFromFile(mMockWebServer, "LO637869431CN.html");
    } catch (Exception e) {
      fail(e.getMessage());
    }

    try {
      TrackObject trackObject = Rastreio.trackSync("LO637869431CN");

      assertNotNull(trackObject);
      assertEquals("LO637869431CN", trackObject.getCode());
      assertEquals(TrackObjectServiceType.UNKNOWN, trackObject.getServiceType());
      assertEquals("", trackObject.getServiceType().getInitials());
      assertEquals("", trackObject.getServiceType().getDescription());
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
      assertEquals(
          "de Unidade de Distribuição em CURITIBA / PR para Unidade de Tratamento em CAJAMAR / SP",
          event.getDetails());
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
      Util.enqueueMockResponseFromFile(mMockWebServer, "LO637869431CN_not_found.html");
    } catch (Exception e) {
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
      Util.enqueueMockResponseFromFile(mMockWebServer, "LB107580877SG.html");
    } catch (Exception e) {
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
      assertEquals("de País em CINGAPURA / para País em Unidade de Tratamento Internacional / BR",
          event.getDetails());
      assertEquals("CINGAPURA /", event.getLocale());
      calendar.set(2020, 0, 16, 21, 2, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // Event with details
      event = trackObject.getEvents().get(5);
      assertNotNull(event);
      assertEquals("Objeto encaminhado", event.getDescription());
      assertEquals(
          "de Unidade de Tratamento em RECIFE / PE para Unidade de Distribuição em NATAL / RN",
          event.getDetails());
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

    try {
      Util.enqueueMockResponseFromFile(mMockWebServer, "LB107580877SG_not_found.html");
    } catch (Exception e) {
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
      Util.enqueueMockResponseFromFile(mMockWebServer, "RH117939038TR.html");
    } catch (Exception e) {
      fail(e.getMessage());
    }

    try {
      TrackObject trackObject = Rastreio.trackSync("RH117939038TR");

      assertNotNull(trackObject);
      assertEquals("RH117939038TR", trackObject.getCode());
      assertEquals(TrackObjectServiceType.RH, trackObject.getServiceType());
      assertEquals("RH", trackObject.getServiceType().getInitials());
      assertEquals("REGISTRADO COM AR DIGITAL", trackObject.getServiceType().getDescription());
      assertTrue(trackObject.isValid());
      assertTrue(!trackObject.isDelivered());
      assertEquals(Error.NO_ERROR, trackObject.getError());
      calendar.set(2019, 10, 27, 10, 27, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), trackObject.getPostedAt());
      calendar.set(2020, 2, 3, 16, 16, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), trackObject.getUpdatedAt());
      assertNotNull(trackObject.getEvents());
      assertEquals(11, trackObject.getEvents().size());
      // First event
      TrackObject.Event event = trackObject.getEvents().get(0);
      assertNotNull(event);
      assertEquals("Objeto postado", event.getDescription());
      assertNull(event.getDetails());
      assertEquals("TURQUIA /", event.getLocale());
      calendar.set(2019, 10, 27, 10, 27, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // Event with details
      event = trackObject.getEvents().get(4);
      assertNotNull(event);
      assertEquals("Não foi autorizada a entrada do objeto no país pelos órgãos fiscalizadores",
          event.getDescription());
      assertEquals(
          "Objeto em análise de destinação - poderá ser devolvido ao remetente, encaminhado para "
          + "refugo ou apreendido",
          event.getDetails());
      assertEquals("CURITIBA / PR", event.getLocale());
      calendar.set(2020, 0, 13, 11, 37, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // 9th event
      event = trackObject.getEvents().get(8);
      assertNotNull(event);
      assertEquals("Não foi autorizada a entrada do objeto no país pelos órgãos fiscalizadores",
          event.getDescription());
      assertEquals(
          "Objeto em análise de destinação - poderá ser devolvido ao remetente, encaminhado para "
          + "refugo ou apreendido",
          event.getDetails());
      assertEquals("CURITIBA / PR", event.getLocale());
      calendar.set(2020, 0, 30, 7, 41, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // Last event
      event = trackObject.getEvents().get(10);
      assertNotNull(event);
      assertEquals("Encaminhado para fiscalização aduaneira", event.getDescription());
      assertNull(event.getDetails());
      assertEquals("Unidade de Tratamento Internacional / BR", event.getLocale());
      calendar.set(2020, 2, 3, 16, 16, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
    } catch (IOException e) {
      fail(e.getMessage());
    }

    try {
      Util.enqueueMockResponseFromFile(mMockWebServer, "RH117939038TR_new.html");
    } catch (Exception e) {
      fail(e.getMessage());
    }

    try {
      TrackObject trackObject = Rastreio.trackSync("RH117939038TR");

      assertNotNull(trackObject);
      assertEquals("RH117939038TR", trackObject.getCode());
      assertEquals(TrackObjectServiceType.RH, trackObject.getServiceType());
      assertEquals("RH", trackObject.getServiceType().getInitials());
      assertEquals("REGISTRADO COM AR DIGITAL", trackObject.getServiceType().getDescription());
      assertTrue(trackObject.isValid());
      assertTrue(!trackObject.isDelivered());
      assertEquals(Error.NO_ERROR, trackObject.getError());
      calendar.set(2020, 1, 28, 16, 33, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), trackObject.getPostedAt());
      calendar.set(2020, 2, 30, 13, 50, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), trackObject.getUpdatedAt());
      assertNotNull(trackObject.getEvents());
      assertEquals(5, trackObject.getEvents().size());
      // First event
      TrackObject.Event event = trackObject.getEvents().get(0);
      assertNotNull(event);
      assertEquals("Devolução autorizada pela Receita Federal", event.getDescription());
      assertNull(event.getDetails());
      assertEquals("CURITIBA / PR", event.getLocale());
      calendar.set(2020, 1, 28, 16, 33, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // Last event
      event = trackObject.getEvents().get(4);
      assertNotNull(event);
      assertEquals("Objeto recebido em", event.getDescription());
      assertNull(event.getDetails());
      assertEquals("TURQUIA /", event.getLocale());
      calendar.set(2020, 2, 30, 13, 50, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
    } catch (IOException e) {
      fail(e.getMessage());
    }
  
    try {
      Util.enqueueMockResponseFromFile(mMockWebServer, "LB679011587SE.html");
    } catch (Exception e) {
      fail(e.getMessage());
    }

    try {
      TrackObject trackObject = Rastreio.trackSync("LB679011587SE");

      assertNotNull(trackObject);
      assertEquals("LB679011587SE", trackObject.getCode());
      assertEquals(TrackObjectServiceType.LB, trackObject.getServiceType());
      assertEquals("LB", trackObject.getServiceType().getInitials());
      assertEquals("LOGÍSTICA REVERSA SIMULTÂNEA SEDEX",
          trackObject.getServiceType().getDescription());
      assertTrue(trackObject.isValid());
      assertTrue(trackObject.isDelivered());
      assertEquals(Error.NO_ERROR, trackObject.getError());
      calendar.set(2020, 1, 12, 13, 48, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), trackObject.getPostedAt());
      calendar.set(2020, 2, 2, 16, 42, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), trackObject.getUpdatedAt());
      assertNotNull(trackObject.getEvents());
      assertEquals(10, trackObject.getEvents().size());
      // First event
      TrackObject.Event event = trackObject.getEvents().get(0);
      assertNotNull(event);
      assertEquals("Objeto postado", event.getDescription());
      assertNull(event.getDetails());
      assertEquals("SUECIA /", event.getLocale());
      calendar.set(2020, 1, 12, 13, 48, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // Event with details
      event = trackObject.getEvents().get(5);
      assertNotNull(event);
      assertEquals("Objeto encaminhado", event.getDescription());
      assertEquals(
          "de Unidade de Distribuição em CURITIBA / PR para Unidade de Tratamento em CAJAMAR / SP",
          event.getDetails());
      assertEquals("CURITIBA / PR", event.getLocale());
      calendar.set(2020, 1, 26, 15, 55, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // Last event
      event = trackObject.getEvents().get(9);
      assertNotNull(event);
      assertEquals("Objeto entregue ao destinatário", event.getDescription());
      assertNull(event.getDetails());
      assertEquals("BELO HORIZONTE / MG", event.getLocale());
      calendar.set(2020, 2, 2, 16, 42, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
    } catch (IOException e) {
      fail(e.getMessage());
    }

    try {
      Util.enqueueMockResponseFromFile(mMockWebServer, "LO823618663CN.html");
    } catch (Exception e) {
      fail(e.getMessage());
    }

    try {
      TrackObject trackObject = Rastreio.trackSync("LO823618663CN");

      assertNotNull(trackObject);
      assertEquals("LO823618663CN", trackObject.getCode());
      assertEquals(TrackObjectServiceType.UNKNOWN, trackObject.getServiceType());
      assertTrue(trackObject.isValid());
      assertFalse(trackObject.isDelivered());
      assertEquals(Error.NO_ERROR, trackObject.getError());
      calendar.set(2020, 1, 24, 19, 59, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), trackObject.getPostedAt());
      calendar.set(2020, 2, 23, 22, 40, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), trackObject.getUpdatedAt());
      assertNotNull(trackObject.getEvents());
      assertEquals(8, trackObject.getEvents().size());
      // First event
      TrackObject.Event event = trackObject.getEvents().get(0);
      assertNotNull(event);
      assertEquals("Objeto postado", event.getDescription());
      assertNull(event.getDetails());
      assertEquals("CHINA /", event.getLocale());
      calendar.set(2020, 1, 24, 19, 59, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // Event with details
      event = trackObject.getEvents().get(5);
      assertNotNull(event);
      assertEquals("Objeto encaminhado", event.getDescription());
      assertEquals(
          "de Unidade de Distribuição em CURITIBA / PR para Unidade de Tratamento em CAJAMAR / SP",
          event.getDetails());
      assertEquals("CURITIBA / PR", event.getLocale());
      calendar.set(2020, 2, 17, 14, 59, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // Last event
      event = trackObject.getEvents().get(7);
      assertNotNull(event);
      assertEquals("Objeto encaminhado", event.getDescription());
      assertEquals(
          "de Unidade de Tratamento em RECIFE / PE para Agência dos Correios em Extremoz / RN",
          event.getDetails());
      assertEquals("RECIFE / PE", event.getLocale());
      calendar.set(2020, 2, 23, 22, 40, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
    } catch (IOException e) {
      fail(e.getMessage());
    }

    try {
      Util.enqueueMockResponseFromFile(mMockWebServer, "LX639826650CN.html");
    } catch (Exception e) {
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
      assertTrue(trackObject.isValid());
      assertTrue(trackObject.isDelivered());
      assertEquals(Error.NO_ERROR, trackObject.getError());
      calendar.set(2020, 1, 27, 16, 56, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), trackObject.getPostedAt());
      calendar.set(2020, 3, 8, 11, 32, 0);
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
      calendar.set(2020, 1, 27, 16, 56, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // Event with details
      event = trackObject.getEvents().get(7);
      assertNotNull(event);
      assertEquals("Objeto encaminhado", event.getDescription());
      assertEquals(
          "de Unidade de Tratamento em RECIFE / PE para Agência dos Correios em Extremoz / RN",
          event.getDetails());
      assertEquals("RECIFE / PE", event.getLocale());
      calendar.set(2020, 3, 1, 21, 17, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // Last event
      event = trackObject.getEvents().get(9);
      assertNotNull(event);
      assertEquals("Objeto entregue ao destinatário", event.getDescription());
      assertNull(event.getDetails());
      assertEquals("Extremoz / RN", event.getLocale());
      calendar.set(2020, 3, 8, 11, 32, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
    } catch (IOException e) {
      fail(e.getMessage());
    }

    try {
      Util.enqueueMockResponseFromFile(mMockWebServer, "LB941561336SE.html");
    } catch (Exception e) {
      fail(e.getMessage());
    }

    try {
      TrackObject trackObject = Rastreio.trackSync("LB941561336SE");

      assertNotNull(trackObject);
      assertEquals("LB941561336SE", trackObject.getCode());
      assertEquals(TrackObjectServiceType.LB, trackObject.getServiceType());
      assertEquals("LB", trackObject.getServiceType().getInitials());
      assertEquals("LOGÍSTICA REVERSA SIMULTÂNEA SEDEX",
          trackObject.getServiceType().getDescription());
      assertTrue(trackObject.isValid());
      assertTrue(!trackObject.isDelivered());
      assertEquals(Error.NO_ERROR, trackObject.getError());
      calendar.set(2020, 10, 27, 15, 2, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), trackObject.getPostedAt());
      calendar.set(2020, 10, 27, 15, 22, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), trackObject.getUpdatedAt());
      assertNotNull(trackObject.getEvents());
      assertEquals(2, trackObject.getEvents().size());
      // First event
      TrackObject.Event event = trackObject.getEvents().get(0);
      assertNotNull(event);
      assertEquals("Objeto postado", event.getDescription());
      assertNull(event.getDetails());
      assertEquals("SUECIA /", event.getLocale());
      calendar.set(2020, 10, 27, 15, 2, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // Last event
      event = trackObject.getEvents().get(1);
      assertNotNull(event);
      assertEquals("Objeto recebido na unidade de exportação no país de origem",
          event.getDescription());
      assertNull(event.getDetails());
      assertEquals("SUECIA /", event.getLocale());
      calendar.set(2020, 10, 27, 15, 22, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
    } catch (IOException e) {
      fail(e.getMessage());
    }

    try {
      Util.enqueueMockResponseFromFile(mMockWebServer, "LB918031405SE.html");
    } catch (Exception e) {
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
      assertFalse(trackObject.isDelivered());
      assertEquals(Error.NO_ERROR, trackObject.getError());
      calendar.set(2020, 10, 16, 11, 56, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), trackObject.getPostedAt());
      calendar.set(2020, 11, 1, 14, 59, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), trackObject.getUpdatedAt());
      assertNotNull(trackObject.getEvents());
      assertEquals(6, trackObject.getEvents().size());
      // First event
      TrackObject.Event event = trackObject.getEvents().get(0);
      assertNotNull(event);
      assertEquals("Objeto postado", event.getDescription());
      assertNull(event.getDetails());
      assertEquals("SUECIA /", event.getLocale());
      calendar.set(2020, 10, 16, 11, 56, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // Event with details
      event = trackObject.getEvents().get(4);
      assertNotNull(event);
      assertEquals("Objeto em trânsito - por favor aguarde", event.getDescription());
      assertEquals(
          "de Unidade de Distribuição em CURITIBA / PR para Unidade de Tratamento em CAJAMAR / SP",
          event.getDetails());
      assertEquals("CURITIBA / PR", event.getLocale());
      calendar.set(2020, 10, 30, 9, 55, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // Last event
      event = trackObject.getEvents().get(5);
      assertNotNull(event);
      assertEquals("Objeto em trânsito - por favor aguarde", event.getDescription());
      assertEquals(
          "de Unidade de Tratamento em CAJAMAR / SP para Unidade de Tratamento em JABOATAO DOS "
          + "GUARARAPES / PE",
          event.getDetails());
      assertEquals("CAJAMAR / SP", event.getLocale());
      calendar.set(2020, 11, 1, 14, 59, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
    } catch (IOException e) {
      fail(e.getMessage());
    }

    try {
      Util.enqueueMockResponseFromFile(mMockWebServer, "LB929795602SE.html");
    } catch (Exception e) {
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
      assertFalse(trackObject.isDelivered());
      assertEquals(Error.NO_ERROR, trackObject.getError());
      calendar.set(2020, 10, 15, 13, 26, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), trackObject.getPostedAt());
      calendar.set(2020, 10, 15, 13, 49, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), trackObject.getUpdatedAt());
      assertNotNull(trackObject.getEvents());
      assertEquals(2, trackObject.getEvents().size());
      // First event
      TrackObject.Event event = trackObject.getEvents().get(0);
      assertNotNull(event);
      assertEquals("Objeto postado", event.getDescription());
      assertNull(event.getDetails());
      assertEquals("SUECIA /", event.getLocale());
      calendar.set(2020, 10, 15, 13, 26, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // Last event
      event = trackObject.getEvents().get(1);
      assertNotNull(event);
      assertEquals("Objeto recebido na unidade de exportação no país de origem",
          event.getDescription());
      assertNull(event.getDetails());
      assertEquals("SUECIA /", event.getLocale());
      calendar.set(2020, 10, 15, 13, 49, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
    } catch (IOException e) {
      fail(e.getMessage());
    }

    // Kill mocked server to simulate server down
    try {
      Util.tearDownMockWebServer(mMockWebServer, true);
      mMockWebServer = null;
    } catch (Exception e) {
      fail(e.getMessage());
    }

    try {
      Rastreio.trackSync("LB679011587SE");
      fail("Tracking object without server configured should NOT succeed");
    } catch (IOException e) {
      assertNotNull(e);
      assertNotNull(e.getMessage());
    }

    // Restart mocked server
    try {
      mMockWebServer = Util.setupMockWebServer();
    } catch (Exception e) {
      fail(e.getMessage());
    }
    

    // Mock response to cover edge cases
    try {
      Util.enqueueMockResponseFromFile(mMockWebServer, "mocked.html");
    } catch (Exception e) {
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
      assertNull(trackObject.getEvents());
    } catch (IOException e) {
      fail(e.getMessage());
    }

    // Force unexpected response
    try {
      Util.enqueueMockResponseFromFile(mMockWebServer, "invalid.txt");
    } catch (Exception e) {
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

    // Force server response with 500 status code
    try {
      Util.enqueueMockResponseFromStatusCode(mMockWebServer, 500);
    } catch (Exception e) {
      fail(e.getMessage());
    }

    try {
      Rastreio.trackSync("LB679011587SE");
      fail("Tracking object with 5xx status code should NOT succeed");
    } catch (IOException e) {
      assertNotNull(e);
      assertNotNull(e.getMessage());
    }

    // Force server response timeout
    try {
      Util.enqueueMockResponseWithNoResponse(mMockWebServer);
    } catch (Exception e) {
      fail(e.getMessage());
    }

    try {
      Rastreio.trackSync("LB679011587SE");
      fail("Tracking object with no response should NOT succeed");
    } catch (IOException e) {
      assertNotNull(e);
      assertNotNull(e.getMessage());
    }

    // Force no body at server response
    try {
      Util.enqueueMockResponseWithNoResponseBody(mMockWebServer);
    } catch (Exception e) {
      fail(e.getMessage());
    }

    try {
      Rastreio.trackSync("LB679011587SE");
      fail("Tracking object with no response body should NOT succeed");
    } catch (IOException e) {
      assertNotNull(e);
      assertNotNull(e.getMessage());
    }
  }
}
