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
        if (amazonItemId.equals("")) throw new IllegalArgumentException("amazonId vacío");

        this.amazonItemId = amazonItemId;
  }

  @Override
  public boolean equals(Object obj) {

  return super.equals(obj)
        && ((AmazonItem) obj).nombre.equals(this.nombre)
        && ((AmazonItem) obj).amazonItemId.equals(this.amazonItemId)
        && ((AmazonItem) obj).precio == this.precio
        && ((AmazonItem) obj).link.equals(this.link);
  }

}
