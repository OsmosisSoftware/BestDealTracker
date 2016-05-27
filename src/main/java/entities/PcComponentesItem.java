package entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;

@Document
public class PcComponentesItem {

    @Id
    @GeneratedValue
    private String id;

    private boolean isIdSet;
    private double precio;
    private String nombre;
    private String link;
    private String pcComponentesItemId;

    public PcComponentesItem() {
    }

    public PcComponentesItem(
            final double precio,
            final String nombre,
            final String link,
            final String pcComponentesItemId
    ) {
        this.setPrecio(precio);
        this.setNombre(nombre);
        this.setLink(link);
        this.setPcComponentesItemId(pcComponentesItemId);
    }

    public void setPcComponentesItemId(String pcComponentesItemId) {
        if (pcComponentesItemId.equals("") ){throw new IllegalArgumentException("El PcComponentesID esta vacio");}
        this.pcComponentesItemId = pcComponentesItemId;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass()
                && ((PcComponentesItem) obj).link.equals(this.link)
                && ((PcComponentesItem) obj).precio == (this.precio)
                && ((PcComponentesItem) obj).nombre.equals(this.nombre)
                && ((PcComponentesItem) obj).pcComponentesItemId.equals(this.pcComponentesItemId);

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

    public void setLink(String link) {
        String urlPattern = "^http(s?)://[a-zA-Z0-9_/\\-\\.]+\\.([A-Za-z/]{2,5})[a-zA-Z0-9_/\\&\\?\\=\\-\\.\\~\\%]*";

        if(!link.matches(urlPattern)) throw new IllegalArgumentException("Eso no es una URL payasín");

        this.link = link;
    }

    public String getUrl(){
        return this.link;
    }

    public String getPcComponentesItemId() {
        return pcComponentesItemId;
    }
}
