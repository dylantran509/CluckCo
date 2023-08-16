/*
 * a.) Class name: ProductPrototype
 * b.) 7-27-23
 * c.) Dylan Tran
 * d.) This class creates products to be displayed on the home page, which is also the product page.
 * e.) There are no data structures in this class.
 * f.) There are no algorithms in this class.
 */

public enum ProductPrototype
{
    // declared objects for products containing images of the products - a shirt, a hoodie, a hat, and a sticker - along with their prices
    SHIRT("shirt.jpg", 25f),
    STICKER("sticker.jpg", 5f),
    HAT("hat.jpg", 20f),
    HOODIE("hoodie.jpg", 50f);

    // variable for image files to be able to reference the actual files saved to device
    private String image;

    // variable for prices to be able to assign numerical prices to the items
    private float price;

    // general object for products; these contain the products' respective image files as well as their prices
    ProductPrototype(String image,float price)
    {
        this.image = image;
        this.price = price;
    }

    /**
     * This method takes the name of an image file saved to a device and returns it to a product object.
     * @return image image of product
     */
    
    public String getImageFile()
    {
        return image;
    }

    /**
     * This method returns a price for a product.
     * @return price product price
     */
    
    public float getPrice()
    {
        return price;
    }
}
