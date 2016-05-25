package Scrap;

import Entidades.PcComponentesItem;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class PcComponentesScraperTest {

    @Test
    public void isValidUrlTest(){
        final String validUrl = "http://www.pccomponentes.com/wd_my_cloud_ex2_ultra_nas.html";

        assertTrue(PcComponentesScraper.isValidUrl(validUrl));
    }

    @Test(expected = IllegalArgumentException.class)
    public void isValidUrlTestThrowsIllegalArgumentExceptionTest(){
        final String invalidUrl = "https://www.amazon.es/Wenger-Carbon-GA-7357-02F00-Mochila-port%C3%A1til/dp/B001LA57ZQ/ref=pd_sim_147_5?ie=UTF8&dpID=51EHcM5gNEL&dpSrc=sims&preST=_AC_UL160_SR123%2C160_&refRID=KC38RGFYDPF48THBW6YF";

        assertTrue(PcComponentesScraper.isValidUrl(invalidUrl));
    }


    @Test
    public void getPcComponentesIdTest() {
        final String validUrl = "http://www.pccomponentes.com/wd_my_cloud_ex2_ultra_nas.html";
        final String expectedId = "100191";
        final String resultId = PcComponentesScraper.getPcComponentesId(validUrl);

        assertEquals(expectedId, resultId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getPcComponentsIdAndThrowsIllegalArgumentExceptionTest () {
        final String invalidUrl = "https://www.amazon.es/Wenger-Carbon-GA-7357-02F00-Mochila-port%C3%A1til/dp/B001LA57ZQ/ref=pd_sim_147_5?ie=UTF8&dpID=51EHcM5gNEL&dpSrc=sims&preST=_AC_UL160_SR123%2C160_&refRID=KC38RGFYDPF48THBW6YF";
        final String expectedId = "100191";
        final String resultId = PcComponentesScraper.getPcComponentesId(invalidUrl);

        assertEquals(expectedId, resultId);
    }

    @Test
    @Ignore("El precio va a cambiar")
    public void createPcComponentesItemTest() {
        PcComponentesItem result = PcComponentesScraper.createPcComponenetesItem("100191");
        PcComponentesItem expected = new PcComponentesItem(
                0,
                159,
                "WD My Cloud EX2 Ultra NAS - Disco/Carcasa NAS Opiniones WD My Cloud EX2 Ultra NAS",
                "https://www.pccomponentes.com/100191.html",
                "100191"
        );

        assertEquals(expected, result);
    }


}