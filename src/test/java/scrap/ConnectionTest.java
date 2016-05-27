package scrap;

import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;


public class ConnectionTest {
  private final String goodLink = "https://jsoup.org/";

  @Test
  public void testConnection() {
    try {
      final Connection conn = new Connection(goodLink);
      Document document = conn.getDocument();

      assertEquals(document, conn.getDocument());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Test
  public void testGetDocument(){
    try {
      final Connection conn = new Connection(goodLink);

      assertNotNull(conn.getDocument());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConnectionIOException() throws IOException {
    final String invalidLink = "esto no es una url";
    Connection connection = new Connection(invalidLink);
  }

  @Test(expected = NullPointerException.class)
  public void testGetDocumentNullPointerException() {
    final Connection connection = new Connection();

    connection.getDocument();
  }

}