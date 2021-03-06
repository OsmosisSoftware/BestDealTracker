package org.osmosis.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Document
public class AmazonItem {

    @Id
    @GeneratedValue
    private String id;

    @DBRef
    private List<User> myUsers;

    private boolean isIdSet;
    private double precio;
    private String nombre;
    private String link;
    private String amazonItemId;

    public AmazonItem() {

    }

    public AmazonItem(
            final double precio,
            final String nombre,
            final String link,
            final String amazonItemId
    ) {
        this.setPrecio(precio);
        this.setNombre(nombre);
        this.setLink(link);
        this.setAmazonItemId(amazonItemId);
    }

    public AmazonItem(
            final double precio,
            final String nombre,
            final String link,
            final String amazonItemId,
            final List<User> users
    ) {
        this.setPrecio(precio);
        this.setNombre(nombre);
        this.setLink(link);
        this.setAmazonItemId(amazonItemId);
        this.setUsers(users);
    }

    public void setAmazonItemId(String amazonItemId) {
        if (amazonItemId.equals("")) throw new IllegalArgumentException("amazonId vacío");

        this.amazonItemId = amazonItemId;
    }

    @Override
    public String toString() {
        return String.format(
                "Amazonitem {id=: %s, precio: %f, nombre: %s, link: %s, amazonitemid: %s}",
                id,
                precio,
                nombre,
                link,
                amazonItemId
        );
    }

    public void setId(String id) {
        if(isIdSet) throw new IllegalArgumentException("Este item ya tiene id");

        isIdSet = true;
        this.id = id;
    }

    public String getId(){
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

    public String getAmazonItemId () {
        return  this.amazonItemId;
    }

    public void setUsers(List<User> users) {
        if(users == null || users.isEmpty()) throw new IllegalArgumentException("Lista de usuarios vacía");

        this.myUsers = users;
    }
}
