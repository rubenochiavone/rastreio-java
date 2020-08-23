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

  @Test
  public void testTrackSync() {
    final Calendar calendar = Calendar.getInstance();

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
      TrackObject trackObject = Rastreio.trackSync("LO823618663CN");

      assertNotNull(trackObject);
      assertEquals("LO823618663CN", trackObject.getCode());
      assertEquals(TrackObjectServiceType.UNKNOWN, trackObject.getServiceType());
      assertTrue(trackObject.isValid());
      assertTrue(trackObject.isDelivered());
      assertEquals(Error.NO_ERROR, trackObject.getError());
      calendar.set(2020, 1, 24, 19, 59, 0);
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
      // 8th event
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
  }
}
