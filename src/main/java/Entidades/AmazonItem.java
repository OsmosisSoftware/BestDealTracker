package Entidades;


public class AmazonItem extends Item {
    private String amazonItemId;
    public AmazonItem() {
        super();
        this.amazonItemId = "";
    }

    public AmazonItem(
            final long id,
            final double precio,
            final String nombre,
            final String link,
            final String amazonItemId
    ) {
        super(id, precio, nombre, link);
        this.setAmazonItemId(amazonItemId);
    }

    public void setAmazonItemId(String amazonItemId) {
        this.amazonItemId = amazonItemId;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass()) return false;

        return ((AmazonItem) obj).id == this.id
                && ((AmazonItem) obj).nombre.equals(this.nombre)
                && ((AmazonItem) obj).amazonItemId.equals(this.amazonItemId)
                && ((AmazonItem) obj).precio == this.precio
                && ((AmazonItem) obj).link.equals(this.link);
    }
}
