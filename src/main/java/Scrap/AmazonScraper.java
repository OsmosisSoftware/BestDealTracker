package Scrap;


import Entidades.AmazonItem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class AmazonScraper {

    private final String amazonUrl = "https://www.amazon.es/";

    public boolean isValidUrl(String validAmazonURL) {
        String isAmazonURL = "^http(s)?://(www\\.)?amazon\\.(com|es)/.+$";
        if(!validAmazonURL.matches(isAmazonURL)) throw new IllegalArgumentException("Eso no es una URL payasín");

        return true;
    }

    public String getAmazonId(String validAmazonURL) {
        String dp = "/dp/";
        String gp = "/gp/product/";

        if(!isValidUrl(validAmazonURL)) throw new IllegalArgumentException("Eso no es una URL payasín");

        int index = validAmazonURL.lastIndexOf(dp);
        if(index > 0) return validAmazonURL.substring(index+dp.length(), index+10+dp.length());

        index = validAmazonURL.lastIndexOf(gp);
        if(index < 0) throw new IllegalArgumentException("Esto no es un enlace de un producto");

        return validAmazonURL.substring(index+gp.length(), index+10+gp.length());
    }

    public Document getAmazonDOMByAmazonId(String validAmazonId) {
        Document doc = new Document("Basura");

        try {
            doc = Jsoup.connect(amazonUrl+"s/field-keywords=" + validAmazonId)
              .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
              .get();
            doc = Jsoup.connect(doc.select("#result_0 a[class=a-link-normal a-text-normal]").first().attr("href"))
              //.userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
              .get();
        } catch (IOException e) {
            System.err.println("Error en getAmazonDOMByAmazonId" + validAmazonId);
            e.printStackTrace();
        }

        return doc;
    }


    public AmazonItem createAmazonItem(Document doc) {
        AmazonItem ret = new AmazonItem();

        String nombre = doc.select("#title").text();

        String strPrecio = doc.select("#priceblock_ourprice").text();
        strPrecio = strPrecio.replaceAll("EUR", "");
        strPrecio = strPrecio.replaceAll(",", ".");
        strPrecio = strPrecio.trim();
        double precio = Double.parseDouble(strPrecio);

        String link = doc.baseUri();

        String amazonId = this.getAmazonId(link);

        ret.setPrecio(precio);
        ret.setAmazonItemId(amazonId);
        ret.setLink(link);
        ret.setNombre(nombre);
        ret.setId(0);

        return ret;
    }
}
