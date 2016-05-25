package Entidades;


public abstract class Item {

  protected long id;

  private boolean isIdSet;
  protected double precio;
  protected String nombre;
  protected String link;

  public Item(){
    this.id = 0;
    this.nombre = "";
    this.precio = 0.0;
    this.link = "";
  }

  public Item(
    final long id,
    final double precio,
    final String nombre,
    final String link
  ) {
    this.setId(id);
    this.setPrecio(precio);
    this.setNombre(nombre);
    this.setLink(link);
  }

  public void setId(long id) {
    if(isIdSet) throw new IllegalArgumentException("Este item ya tiene id");

    isIdSet = true;
    this.id = id;
  }
  public long getId(){
    return id;
  }

  public void setPrecio(double precio) {
    if(precio < 0 ) throw new IllegalArgumentException("Precio negativo");

    this.precio = precio;
  }

  public void setNombre(String nombre) {
    if(nombre.equals("")) throw new IllegalArgumentException("Nombre invalido");

    this.nombre = nombre;
  }

  public String getNombre() {
    return this.nombre;
  }

  public double getPrecio() {
    return this.precio;
  }

  @Override
  public boolean equals(Object obj) {
    return obj.getClass() == getClass() && ((Item)obj).id == this.id;
  }

  public void setLink(String link) {
    String urlPattern = "^http(s?)://[a-zA-Z0-9_/\\-\\.]+\\.([A-Za-z/]{2,5})[a-zA-Z0-9_/\\&\\?\\=\\-\\.\\~\\%]*";

    if(!link.matches(urlPattern)) throw new IllegalArgumentException("Eso no es una URL payasín");

    this.link = link;
  }

  public String getUrl(){
    return this.link;
  }
}
