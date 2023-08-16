/**
 * Date: 08/11/2023
 * Implements Cart features to manage products in payment process.
 * @author David Regio
 * @version 1.0 
*/

package CluckCo.shoppingCart.cart;

import CluckCo.shoppingCart.home.Product;

public class CartEntry{
    private Product product;
    private int quantity;

    /**
     * Constructor for CartEntry method
     * @param product
     * @param quantity
     */
    public CartEntry(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Returns product variable of type Product
     * @return
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Returns quantity variable of type int
     * @return
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * Creates object of quantity with an incremented count
     */
    public void increaseQuantity(){
        this.quantity++;
    }

    /**
     * Creates object of quantity with a decremented count of greater than 0
     */
    public void decreaseQuantity(){
        if(this.quantity > 0){
            this.quantity--;
        }
    }
}
