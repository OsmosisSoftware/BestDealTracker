package Scrap;

import Entities.PcComponentesItem;
import org.jsoup.*;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class PcComponentesScraper {

    private static final String PcComponentesURL = "https://www.pccomponentes.com/";

    public static boolean isValidUrl(String validPcComponentesURL) {
        String isPcComponentesURL = "^http(s)?://(www\\.)?pccomponentes\\.(com)/.+$";
        if(!validPcComponentesURL.matches(isPcComponentesURL)) throw new IllegalArgumentException("Eso no es una URL payasín");

        return true;
    }

    public static String getPcComponentesId(String validPcComponentesURL) {
        if (!isValidUrl(validPcComponentesURL)) throw new IllegalArgumentException("No es una Url de PcComponentes");
        String pcComponetesID = "Basura";

        try {
            Document doc = Jsoup.connect(validPcComponentesURL)
                    .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
                    .get();

            pcComponetesID = doc.select("#id_articulo").attr("data-id");
        } catch (IOException e) {
            System.err.println("Error en getAmazonDOMByAmazonId, URL: " + validPcComponentesURL);
            e.printStackTrace();
        }

        return pcComponetesID;
    }

    public static PcComponentesItem createPcComponenetesItem(String pcComponentesItemId) {
        PcComponentesItem ret = new PcComponentesItem();

        try {
            Document doc = Jsoup.connect(PcComponentesURL + pcComponentesItemId + ".html")
                    .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
                    .get();

            String strPrecio = doc.select("#cuadroPrecio").text();
            final int index = strPrecio.indexOf("€");
            strPrecio = strPrecio.substring(0,index);

            final double precio = Double.parseDouble(strPrecio);

            final String nombre = doc.select("div>h1").text().replaceAll(":", "");

            final String link = doc.baseUri();

            ret.setId(0);
            ret.setNombre(nombre);
            ret.setPrecio(precio);
            ret.setLink(link);
            ret.setPcComponentesItemId(pcComponentesItemId);

        } catch (IOException e) {
            System.err.println("Error en createPcComponenetesItem, ID: " + pcComponentesItemId);
            e.printStackTrace();
        }

        return ret;
    }

}
