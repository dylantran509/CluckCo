/**
 * Date: 08/09/2023
 * Implements .jpg files from 'resources' folder.
 * @author David Regio
 * @version 1.0 
*/
package CluckCo.shoppingCart.home;

public enum Product {
    
    /**
     * Specify Product image file and place price.
     */
    APPLE("Apple.jpg", 0.55f), MILK("Milk.jpg", 0.78f), 
    JUICE("Juice.jpg", 0.56f), LETTUCE("Lettuce.jpg", 0.56f);

    /**
     * Create variable for price and image name *EDIT LATER FOR CLUCK&CO products*
     */
    private String imageFile;
    private float price;

    /**
     * Constructor for Product's imageFile variable and price
     * @param imageFile Assigns an object to variable imageFile
     * @param price Assigns an object to variable price
     */
    private Product(String imageFile, float price){
        this.imageFile = imageFile;
        this.price = price;   
    }

    /**
     * Grabs Product Image
     * @return imageFile
     */
    public String getImageFile(){
        return imageFile;
    }

    /**
     * Grabs Product price
     * @return this.price
     */
    public float getPrice(){
        return this.price;
    }
}
