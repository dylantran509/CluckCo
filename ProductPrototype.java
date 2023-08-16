// a.) Class name: Product
// b.) 7-27-23
// c.) Dylan Tran
// d.) This class creates products to be displayed on the home page, which is also the product page.
// e.) There are no data structures in this class.
// f.) There are no algorithms in this class.

public enum Product {

    // declared objects for products containing images of the products - a shirt, a hoodie, a hat, and a sticker - along with their prices
    SHIRT("shirt.jpg",25f), STICKER("sticker.jpg",5f), HAT("hat.jpg",20f), HOODIE("hoodie.jpg",50f);

    // variable for image files to be able to reference the actual files saved to device
    private String imageFile;

    // variable for prices to be able to assign numerical prices to the items
    private float price;

    // general object for products; these contain the products' respective image files as well as their prices
    Product(String imageFile,float price){
        this.imageFile = imageFile;
        this.price = price;
    }

    // This method takes the name of an image file saved to a device and returns it to a product object.
    // parameters: N/A
    // return: image file
    public String getImageFile() {
        return imageFile;
    }

    // This method returns a price for a product.
    // parameters: N/A
    // return: price
    public float getPrice() {
        return price;
    }
}
