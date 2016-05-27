package scrap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.Connection.Response;

import java.io.IOException;

class Connection {

  private Document document;

  Connection() {

  }

  Connection(String link) throws IOException{
    Response response = Jsoup
      .connect(link)
      .ignoreContentType(true)
      .header("Accept-Encoding", "gzip, deflate")
      .userAgent(
        "Mozilla/5.0 (Windows NT 6.3; rv:36.0) Gecko/20100101 Firefox/36.0"
      )
      .maxBodySize(0).timeout(600000).execute();

      document = response.parse();
  }


  Document getDocument(){
    if(document != null) return this.document;
    throw new NullPointerException();
  }

}
