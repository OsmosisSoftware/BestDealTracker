package entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class PcComponentesItemTest {

    @Test
    public void testCreateNewAmazonItem(){
        final String nombre =  "Wenger Carbon GA-7357-02F00 - Mochila para portátil de 17\", Negro";
        final double precio = 78.45;

        PcComponentesItem pcComponentesItem = new PcComponentesItem(precio, nombre, "http://www.google.com", "BbB8756ABC");

        assertNotNull(pcComponentesItem);
        assertEquals(precio, pcComponentesItem.getPrecio(),  0.001);
        assertEquals(nombre, pcComponentesItem.getNombre());
    }

    @Test
    public void testCreateEmptyPcComponentesItem(){
        PcComponentesItem pcComponentesItem = new PcComponentesItem();

        assertNotNull(pcComponentesItem);
        assertEquals(0.0, pcComponentesItem.getPrecio(), 0.001);
        assertEquals("", pcComponentesItem.getNombre());
    }


    @Test
    public void testSetPrecio() {
        PcComponentesItem pcComponentesItem = new PcComponentesItem();
        final double precio = 256.256;

        pcComponentesItem.setPrecio(precio);

        assertEquals(precio, pcComponentesItem.getPrecio(), 0.001);
    }

    @Test
    public void testSetNombre() {
        PcComponentesItem pcComponentesItem =  new PcComponentesItem();
        final String nombre = "Un Nombre T0 pollüuUoHh";

        pcComponentesItem.setNombre(nombre);

        assertEquals(nombre, pcComponentesItem.getNombre());
    }

    @Test
    public void testValidUrl(){
        String urlToGrande = "https://www.amazon.es/Wenger-Carbon-GA-7357-02F00-Mochila-port%C3%A1til/dp/B001LA57ZQ/ref=pd_sim_147_5?ie=UTF8&dpID=51EHcM5gNEL&dpSrc=sims&preST=_AC_UL160_SR123%2C160_&refRID=KC38RGFYDPF48THBW6YF";
        PcComponentesItem amazonItem = new PcComponentesItem(0.0, "foo name", urlToGrande, "BbB8756ABC");

        assertEquals(urlToGrande, amazonItem.getUrl());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidUrl(){
        String invalidURL = "https://amaz/Wenger-Carbon-GA-7357-02F00-Mochila-port%C3%A1til/dp/B001LA57ZQ/ref=pd_sim_147_5?ie=UTF8&dpID=51EHcM5gNEL&dpSrc=sims&preST=_AC_UL160_SR123%2C160_&refRID=KC38RGFYDPF48THBW6YF";

        new PcComponentesItem(0.0, "foo name", invalidURL, "BbB8756ABC");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidPrecio(){
        PcComponentesItem pcComponentesItem = new PcComponentesItem();
        final double invalidPrecio = -200.2587;

        pcComponentesItem.setPrecio(invalidPrecio);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidNombre(){
        PcComponentesItem pcComponentesItem = new PcComponentesItem();
        final String invalidNombre = "";

        pcComponentesItem.setNombre(invalidNombre);
    }

}