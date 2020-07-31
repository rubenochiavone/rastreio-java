package rastreio;

import org.junit.Test;

import static org.junit.Assert.*;

public class HijackMagicTest {
  @Test
  public void testChangeUrl() {
    try {
      assertEquals("https://www2.correios.com.br/sistemas/rastreamento/resultado_semcontent.cfm", Magic.URL);

      HijackMagic.changeUrl("newUrl");
      assertEquals("newUrl", Magic.URL);

      HijackMagic.revertUrl();
      assertEquals("https://www2.correios.com.br/sistemas/rastreamento/resultado_semcontent.cfm", Magic.URL);
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testRevertUrl() {
    try {
      assertEquals("https://www2.correios.com.br/sistemas/rastreamento/resultado_semcontent.cfm", Magic.URL);

      HijackMagic.revertUrl();
      assertEquals("https://www2.correios.com.br/sistemas/rastreamento/resultado_semcontent.cfm", Magic.URL);
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }
}