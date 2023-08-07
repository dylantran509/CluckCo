public enum Product {
    SHIRT1("shirt1.jpg",25f), SHIRT2("shirt2.jpg",20f), HAT("hat.jpg",20f), HOODIE("hoodie.jpg",50f)

    private String imageFile;
    private float price;

    Product(String imageFile,float price){
        this.imageFile = imageFile;
        this.price = price;
    }

    public String getImageFile() {
        return imageFile;
    }

    public float getPrice() {
        return price;
    }
}
