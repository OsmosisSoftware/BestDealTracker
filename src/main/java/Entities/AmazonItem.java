package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AmazonItem {


    @Id
    @GeneratedValue
    protected long id;

    private boolean isIdSet;
    private double precio;
    private String nombre;
    private String link;
    private String amazonItemId;

    public AmazonItem() {

    }

    public AmazonItem(
            final long id,
            final double precio,
            final String nombre,
            final String link,
            final String amazonItemId
    ) {
        super();
        this.setAmazonItemId(amazonItemId);
    }


    public void setAmazonItemId(String amazonItemId) {
        if (amazonItemId.equals("")) throw new IllegalArgumentException("amazonId vacío");

        this.amazonItemId = amazonItemId;
    }

    @Override
    public String toString() {
        return String.format(
                "Amazonitem {id=: %d, precio: %f, nombre: %s, link: %s, amazonitemid: %s}",
                id,
                precio,
                nombre,
                link,
                amazonItemId
        );
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

        return obj.getClass() == this.getClass()
                && ((AmazonItem) obj).nombre.equals(this.nombre)
                && ((AmazonItem) obj).amazonItemId.equals(this.amazonItemId)
                && ((AmazonItem) obj).precio == this.precio
                && ((AmazonItem) obj).link.equals(this.link);
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
