package org.osmosis.entities;

import org.junit.Test;

import static org.junit.Assert.*;


public class AmazonItemTest {

  @Test
  public void testCreateNewAmazonItem(){
    final long id = 0;
    final String nombre =  "Wenger Carbon GA-7357-02F00 - Mochila para portátil de 17\", Negro";
    final double precio = 78.45;

    AmazonItem amazonItem = new AmazonItem(precio, nombre, "http://www.google.com", "BbB8756ABC");

    assertNotNull(amazonItem);
    assertEquals(precio, amazonItem.getPrecio(),  0.001);
    assertEquals(nombre, amazonItem.getNombre());
  }


  @Test
  public void testSetPrecio() {
    AmazonItem amazonItem = new AmazonItem();
    final double precio = 256.256;

    amazonItem.setPrecio(precio);

    assertEquals(precio, amazonItem.getPrecio(), 0.001);
  }

  @Test
  public void testSetNombre() {
    AmazonItem amazonItem = new AmazonItem();
    final String nombre = "Un Nombre T0 pollüuUoHh";

    amazonItem.setNombre(nombre);

    assertEquals(nombre, amazonItem.getNombre());
  }

  @Test
  public void testValidUrl(){
    String urlToGrande = "https://www.amazon.es/Wenger-Carbon-GA-7357-02F00-Mochila-port%C3%A1til/dp/B001LA57ZQ/ref=pd_sim_147_5?ie=UTF8&dpID=51EHcM5gNEL&dpSrc=sims&preST=_AC_UL160_SR123%2C160_&refRID=KC38RGFYDPF48THBW6YF";
    AmazonItem amazonItem = new AmazonItem(0.0, "foo name", urlToGrande, "BbB8756ABC");

    assertEquals(urlToGrande, amazonItem.getUrl());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetInvalidUrl(){
    String invalidURL = "https://amaz/Wenger-Carbon-GA-7357-02F00-Mochila-port%C3%A1til/dp/B001LA57ZQ/ref=pd_sim_147_5?ie=UTF8&dpID=51EHcM5gNEL&dpSrc=sims&preST=_AC_UL160_SR123%2C160_&refRID=KC38RGFYDPF48THBW6YF";

    AmazonItem amazonItem = new AmazonItem(0.0, "foo name", invalidURL, "BbB8756ABC");
  }


  @Test(expected = IllegalArgumentException.class)
  public void testSetInvalidPrecio(){
    AmazonItem amazonItem = new AmazonItem();
    final double invalidPrecio = -200.2587;

    amazonItem.setPrecio(invalidPrecio);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetInvalidNombre(){
    AmazonItem amazonItem = new AmazonItem();
    final String invalidNombre = "";

    amazonItem.setNombre(invalidNombre);
  }

}