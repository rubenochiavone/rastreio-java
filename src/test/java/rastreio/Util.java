package rastreio;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.SocketPolicy;

class Util {
  private Util() {}

  static MockWebServer setupMockWebServer() throws IOException, IllegalAccessException, NoSuchFieldException, SecurityException {
    MockWebServer server = new MockWebServer();
    server.start();

    // Change Magic.URL to use server URL
    HijackMagic.changeUrl(server.url("").toString());

    return server;
  }
  
  static MockWebServer setupMockWebServerWithMockResponseFromFile(String filename) throws IOException, URISyntaxException, IllegalAccessException, NoSuchFieldException, SecurityException {
    MockWebServer server = new MockWebServer();
    server.enqueue(new MockResponse().setBody(
      getResourceFileAsString(filename)));
    server.start();

    // Change Magic.URL to use server URL
    HijackMagic.changeUrl(server.url("").toString());

    return server;
  }

  static void tearDownMockWebServer(MockWebServer server) {
    try {
      if (server != null) {
        server.shutdown();
        server.close();
      }
    } catch (Exception e) {
      // Ignore exception
    }

    // Revert Magic.URL back to original
    try {
      HijackMagic.revertUrl();
    } catch (Exception e) {
      // Ignore exception
    }
  }

  static void enqueueMockResponseFromFile(MockWebServer server, String filename) throws IOException, URISyntaxException {
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
