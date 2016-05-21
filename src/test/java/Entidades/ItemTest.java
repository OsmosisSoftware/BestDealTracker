package Entidades;

import org.junit.Test;

import static org.junit.Assert.*;


public class ItemTest {

  @Test
  public void testCreateNewItem(){
    final long id = 0;
    final String nombre = "Wenger Carbon GA-7357-02F00 - Mochila para portátil de 17\", Negro";
    final double precio = 78.45;

    Item item = new Item(id, precio, nombre, "http://www.google.com");

    assertNotNull(item);
    assertEquals(id, item.getId());
    assertEquals(precio, item.getPrecio(),  0.001);
    assertEquals(nombre, item.getNombre());
  }

  @Test
  public void testCreateEmptyItem(){
    Item item = new Item();

    assertNotNull(item);
    assertEquals(0, item.getId());
    assertEquals(0.0, item.getPrecio(), 0.001);
    assertEquals("", item.getNombre());
  }

  @Test
  public void testSetIdOnEmptyItem() {
    Item item = new Item();
    final long id = 1987;

    item.setId(id);

    assertEquals(id, item.getId());
  }

  @Test
  public void testSetPrecio() {
    Item item = new Item();
    final double precio = 256.256;

    item.setPrecio(precio);

    assertEquals(precio, item.getPrecio(), 0.001);
  }

  @Test
  public void testSetNombre() {
    Item item = new Item();
    final String nombre = "Un Nombre T0 pollüuUoHh";

    item.setNombre(nombre);

    assertEquals(nombre, item.getNombre());
  }

  @Test
  public void testValidUrl(){
    String urlToGrande = "https://www.amazon.es/Wenger-Carbon-GA-7357-02F00-Mochila-port%C3%A1til/dp/B001LA57ZQ/ref=pd_sim_147_5?ie=UTF8&dpID=51EHcM5gNEL&dpSrc=sims&preST=_AC_UL160_SR123%2C160_&refRID=KC38RGFYDPF48THBW6YF";
    Item item = new Item(0, 0.0, "foo name", urlToGrande);

    assertEquals(urlToGrande, item.getUrl());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetInvalidUrl(){
    String invalidURL = "https://amaz/Wenger-Carbon-GA-7357-02F00-Mochila-port%C3%A1til/dp/B001LA57ZQ/ref=pd_sim_147_5?ie=UTF8&dpID=51EHcM5gNEL&dpSrc=sims&preST=_AC_UL160_SR123%2C160_&refRID=KC38RGFYDPF48THBW6YF";

    Item item = new Item(0, 0.0, "foo name", invalidURL);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCannotSetIdAgain(){
    Item item = new Item(1, 2.2, "name", "www.google.com");
    final long invalidId = 2;

    item.setId(invalidId);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetInvalidPrecio(){
    Item item = new Item();
    final double invalidPrecio = -200.2587;

    item.setPrecio(invalidPrecio);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetInvalidNombre(){
    Item item = new Item();
    final String invalidNombre = "";

    item.setNombre(invalidNombre);
  }

}