package rastreio;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.inject.Inject;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.SocketPolicy;
import org.mockito.Mockito;

class Util {
  public static final String URL = "https://www2.correios.com.br/sistemas/rastreamento/resultado_semcontent.cfm";
  public static final String URL2 = "https://www2.correios.com.br/sistemas/rastreamento/resultado.cfm";

  @Inject
  private Magic mMagic;
  
  public Util() {}

  MockWebServer setupMockWebServer() throws IOException, IllegalAccessException,
      NoSuchFieldException, SecurityException {
    MockWebServer server = new MockWebServer();
    server.start();

    // Change Magic.URL to use server URL
    Mockito.when(mMagic.getUrl()).thenReturn(server.url("").toString());
    Mockito.when(mMagic.getUrl2()).thenReturn(server.url("").toString());

    return server;
  }
  
  MockWebServer setupMockWebServerWithMockResponseFromFile(String filename) throws
      IOException, URISyntaxException, IllegalAccessException, NoSuchFieldException,
      SecurityException {
    MockWebServer server = new MockWebServer();
    server.enqueue(new MockResponse().setBody(
        getResourceFileAsString(filename)));
    server.start();

    // Change Magic.URL to use server URL
    Mockito.when(mMagic.getUrl()).thenReturn(server.url("").toString());
    Mockito.when(mMagic.getUrl2()).thenReturn(server.url("").toString());

    return server;
  }

  void tearDownMockWebServer(MockWebServer server) {
    try {
      if (server != null) {
        server.shutdown();
        server.close();
      }
    } catch (Exception e) {
      // Ignore exception
    }
  }

  static void enqueueMockResponseFromFile(MockWebServer server, String filename) throws
      IOException, URISyntaxException {
    server.enqueue(new MockResponse()
        .setBody(getResourceFileAsString(filename)));
  }

  static void enqueueMockResponseFromStatusCode(MockWebServer server, int status) {
    server.enqueue(new MockResponse().setStatus(String.valueOf(status))
        .setBody(String.valueOf(status)));
  }

  static void enqueueMockResponseWithNoResponse(MockWebServer server) {
    server.enqueue(new MockResponse().setSocketPolicy(SocketPolicy.NO_RESPONSE));
  }

  static void enqueueMockResponseWithNoResponseBody(MockWebServer server) {
    server.enqueue(new MockResponse().setSocketPolicy(SocketPolicy.STALL_SOCKET_AT_START));
  }

  static String getResourceFileAsString(String filename) throws IOException, URISyntaxException {
    return new String(Files.readAllBytes(
        Paths.get(ClassLoader.getSystemClassLoader().getResource(filename).toURI())),
        StandardCharsets.ISO_8859_1
    );
  }
}
