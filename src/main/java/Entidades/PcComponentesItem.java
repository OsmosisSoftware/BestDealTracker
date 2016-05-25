package Entidades;

public class PcComponentesItem extends Item {

    private String pcComponentesItemId;

    public PcComponentesItem() {
        super();
        this.pcComponentesItemId = "";
    }

    public PcComponentesItem(
            final long id,
            final double precio,
            final String nombre,
            final String link,
            final String pcComponentesItemId
    ) {
        super(id, precio, nombre, link);
        this.setPcComponentesItemId(pcComponentesItemId);
    }

    public void setPcComponentesItemId(String pcComponentesItemId) {
        if (pcComponentesItemId.equals("") ){throw new IllegalArgumentException("El PcComponentesID esta vacio");}
        this.pcComponentesItemId = pcComponentesItemId;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj)
                && obj.getClass() == this.getClass()
                && ((PcComponentesItem) obj).link.equals(this.link)
                && ((PcComponentesItem) obj).precio == (this.precio)
                && ((PcComponentesItem) obj).nombre.equals(this.nombre)
                && ((PcComponentesItem) obj).pcComponentesItemId.equals(this.pcComponentesItemId);

    }

    public String getPcComponentesItemId() {
        return pcComponentesItemId;
    }
}
