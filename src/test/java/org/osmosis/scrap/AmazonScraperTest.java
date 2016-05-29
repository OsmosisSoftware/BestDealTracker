package org.osmosis.scrap;

import org.osmosis.entities.AmazonItem;
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
        final String validAmazonURL = "http://www.amazon.com/gp/product/B00I15SB16";
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
    public void testGetDOMByAmazonId() {
        final String validAmazonID = "B001LA57ZQ";
        AmazonScraper as = new AmazonScraper();
        String expected = "https://www.amazon.es/Wenger-Carbon-GA-7357-02F00-Mochila-port%C3%A1til/dp/B001LA57ZQ";
        String result = as.getAmazonDOMByAmazonId(validAmazonID).baseUri();

        assertEquals(expected, result);
    }

    @Test
    @Ignore ("El precio cambia constantemente")
    public void testCreateAmazonItem (){
        AmazonItem expected = new AmazonItem();
        expected.setLink("https://www.amazon.es/Wenger-Carbon-GA-7357-02F00-Mochila-port%C3%A1til/dp/B001LA57ZQ");
        expected.setAmazonItemId("B001LA57ZQ");
        expected.setNombre("Wenger Carbon GA-7357-02F00 - Mochila para portátil de 17\", Negro");
        expected.setPrecio(83.66);

        AmazonScraper as = new AmazonScraper();
        Document doc = as.getAmazonDOMByAmazonId("B001LA57ZQ");
        AmazonItem result = as.createAmazonItem(doc);

        assertEquals(expected, result);
    }
}