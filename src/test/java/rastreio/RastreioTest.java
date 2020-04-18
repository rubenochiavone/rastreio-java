package rastreio;

import java.io.IOException;
import java.util.Calendar;

import okhttp3.OkHttpClient;

import org.junit.Test;

import static org.junit.Assert.*;

public class RastreioTest {
  @Test
  public void testTrack() {
    final long syncTimeout = (long) new OkHttpClient().readTimeoutMillis();

    try {
      final Object syncObject = new Object();

      Rastreio.track("JT124720455BR", new Rastreio.Listener() {
      
        @Override
        public void onSuccess(TrackObject trackObject) {
          synchronized(syncObject) {
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
          synchronized(syncObject) {
            syncObject.notify();
          }

          fail(e.getMessage());
        }
      });

      synchronized(syncObject) {
        syncObject.wait(syncTimeout);
      }
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testTrackSync() {
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

      Calendar calendar = Calendar.getInstance();

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
      assertEquals(TrackObjectServiceType.LB, trackObject.getServiceType());
      assertEquals("LB", trackObject.getServiceType().getInitials());
      assertEquals("LOGÍSTICA REVERSA SIMULTÂNEA SEDEX", trackObject.getServiceType().getDescription());
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

    try {
      TrackObject trackObject = Rastreio.trackSync("RH117939038TR");

      Calendar calendar = Calendar.getInstance();

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
      calendar.set(2020, 2, 30, 13, 50, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), trackObject.getUpdatedAt());
      assertNotNull(trackObject.getEvents());
      assertEquals(14, trackObject.getEvents().size());
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
      assertEquals("Não foi autorizada a entrada do objeto no país pelos órgãos fiscalizadores", event.getDescription());
      assertEquals("Objeto em análise de destinação - poderá ser devolvido ao remetente, encaminhado para refugo ou apreendido", event.getDetails());
      assertEquals("CURITIBA / PR", event.getLocale());
      calendar.set(2020, 0, 13, 11, 37, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // 9th event
      event = trackObject.getEvents().get(8);
      assertNotNull(event);
      assertEquals("Não foi autorizada a entrada do objeto no país pelos órgãos fiscalizadores", event.getDescription());
      assertEquals("Objeto em análise de destinação - poderá ser devolvido ao remetente, encaminhado para refugo ou apreendido", event.getDetails());
      assertEquals("CURITIBA / PR", event.getLocale());
      calendar.set(2020, 0, 30, 7, 41, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // 11th event
      event = trackObject.getEvents().get(10);
      assertNotNull(event);
      assertEquals("Encaminhado para fiscalização aduaneira", event.getDescription());
      assertNull(event.getDetails());
      assertEquals("Unidade de Tratamento Internacional / BR", event.getLocale());
      calendar.set(2020, 2, 3, 16, 16, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // 13th event
      event = trackObject.getEvents().get(12);
      assertNotNull(event);
      assertEquals("Objeto devolvido ao país de origem", event.getDescription());
      assertNull(event.getDetails());
      assertEquals("CURITIBA / PR", event.getLocale());
      calendar.set(2020, 2, 10, 14, 35, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // Last event
      event = trackObject.getEvents().get(13);
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

      Calendar calendar = Calendar.getInstance();

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
      assertEquals("de Unidade de Distribuição em CURITIBA / PR para Unidade de Tratamento em CAJAMAR / SP", event.getDetails());
      assertEquals("CURITIBA / PR", event.getLocale());
      calendar.set(2020, 2, 17, 14, 59, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      assertEquals(calendar.getTime(), event.getTrackedAt());
      // 8th event
      event = trackObject.getEvents().get(7);
      assertNotNull(event);
      assertEquals("Objeto encaminhado", event.getDescription());
      assertEquals("de Unidade de Tratamento em RECIFE / PE para Agência dos Correios em Extremoz / RN", event.getDetails());
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

      Calendar calendar = Calendar.getInstance();

      assertNotNull(trackObject);
      assertEquals("LX639826650CN", trackObject.getCode());
      assertEquals(TrackObjectServiceType.LX, trackObject.getServiceType());
      assertEquals("LX", trackObject.getServiceType().getInitials());
      assertEquals("OBJETO INTERNACIONAL PACKET ECONOMIC", trackObject.getServiceType().getDescription());
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
      assertEquals("de Unidade de Tratamento em RECIFE / PE para Agência dos Correios em Extremoz / RN", event.getDetails());
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
