package rastreio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

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

  @Test
  public void testChangeUrl2() {
    try {
      assertEquals("https://www2.correios.com.br/sistemas/rastreamento/resultado.cfm", Magic.URL2);

      HijackMagic.changeUrl2("newUrl");
      assertEquals("newUrl", Magic.URL2);

      HijackMagic.revertUrl2();
      assertEquals("https://www2.correios.com.br/sistemas/rastreamento/resultado.cfm", Magic.URL2);
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testRevertUrl2() {
    try {
      assertEquals("https://www2.correios.com.br/sistemas/rastreamento/resultado.cfm", Magic.URL2);

      HijackMagic.revertUrl2();
      assertEquals("https://www2.correios.com.br/sistemas/rastreamento/resultado.cfm", Magic.URL2);
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }
}
