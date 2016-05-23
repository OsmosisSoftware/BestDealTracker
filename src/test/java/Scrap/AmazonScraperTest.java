package Scrap;

import Entidades.AmazonItem;
import org.jsoup.nodes.Document;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class AmazonScraperTest {

    @Test
    public void testIsValidAmazonUrl(){
        final String validAmazonURL = "https://www.amazon.es/Wenger-Carbon-GA-7357-02F00-Mochila-port%C3%A1til/dp/B001LA57ZQ/ref=pd_sim_147_5?ie=UTF8&dpID=51EHcM5gNEL&dpSrc=sims&preST=_AC_UL160_SR123%2C160_&refRID=KC38RGFYDPF48THBW6YF";
        AmazonScraper as = new AmazonScraper();

        assertTrue(as.isValidUrl(validAmazonURL));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotValidAmazonUrl() {
        final String invalidAmazonUrl = "https://www.google.es/Wenger-Carbon-GA-7357-02F00-Mochila-port%C3%A1til/dp/B001LA57ZQ/ref=pd_sim_147_5?ie=UTF8&dpID=51EHcM5gNEL&dpSrc=sims&preST=_AC_UL160_SR123%2C160_&refRID=KC38RGFYDPF48THBW6YF";
        AmazonScraper as = new AmazonScraper();

        assertFalse(as.isValidUrl(invalidAmazonUrl));
    }

    @Test
    public void testGetDPAmazonId() {
        final String validAmazonURL = "https://www.amazon.es/Wenger-Carbon-GA-7357-02F00-Mochila-port%C3%A1til/dp/B001LA57ZQ/ref=pd_sim_147_5?ie=UTF8&dpID=51EHcM5gNEL&dpSrc=sims&preST=_AC_UL160_SR123%2C160_&refRID=KC38RGFYDPF48THBW6YF";
        final String validAmazonID = "B001LA57ZQ";
        AmazonScraper as = new AmazonScraper();

        final String compareId = as.getAmazonId(validAmazonURL);
        assertEquals(validAmazonID, compareId);
    }

    @Test
    public void testGetGPAmazonId() {
        final String validAmazonURL = "http://www.amazon.com/gp/product/B00I15SB16/ref=s9_acss_bw_cg_odsbnc_1a1?pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-2&pf_rd_r=14Q281S149KPYPSP32J8&pf_rd_t=101&pf_rd_p=7526d413-a8f2-4d30-a218-03113e9802f6&pf_rd_i=6669702011";
        final String validAmazonID = "B00I15SB16";
        AmazonScraper as = new AmazonScraper();

        final String compareId = as.getAmazonId(validAmazonURL);
        assertEquals(validAmazonID, compareId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDPAmazonIdAndException() {
        final String validAmazonURL = "https://www.amazon.es/";
        AmazonScraper as = new AmazonScraper();

        as.getAmazonId(validAmazonURL);
    }

    @Test
    @Ignore
    public void testGetDOMByAmazonId() {
        final String validAmazonID = "B001LA57ZQ";
        AmazonScraper as = new AmazonScraper();
        String expected = "https://www.amazon.es/Wenger-Carbon-GA-7357-02F00-Mochila-port%C3%A1til/dp/B001LA57ZQ/ref=sr_1_1/276-1897590-8198301?ie=UTF8&qid=1464038605&sr=8-1&keywords=B001LA57ZQ";
        String result = as.getAmazonDOMByAmazonId(validAmazonID).baseUri();

        assertEquals(expected, result);
    }

    @Test
    @Ignore
    public void testCreateAmazonItem (){
        AmazonItem expected = new AmazonItem();
        expected.setId(0);
        expected.setLink("https://www.amazon.es/Wenger-Carbon-GA-7357-02F00-Mochila-port%C3%A1til/dp/B001LA57ZQ");
        expected.setAmazonItemId("B001LA57ZQ");
        expected.setNombre("Wenger Carbon GA-7357-02F00 - Mochila para portátil de 17\", Negro");
        expected.setPrecio(84.66);

        AmazonScraper as = new AmazonScraper();
        Document doc = as.getAmazonDOMByAmazonId("B001LA57ZQ");
        AmazonItem result = as.createAmazonItem(doc);

        assertEquals(expected, result);

    }
}