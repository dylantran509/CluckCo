/**
 * Date: 08/11/2023
 * Includes algorithms to manage product quantity and price.
 * Includes implementations ArrayList, HashMap, List, and Map
 * @author David Regio
 * @version 1.0 
*/

package CluckCo.shoppingCart.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CluckCo.shoppingCart.home.Product;

public class ShoppingCart {
    private Map<String, CartEntry> entries;
    
    private static ShoppingCart INSTANCE;

    public static ShoppingCart getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ShoppingCart();
        }
        return INSTANCE;
    }
    public ShoppingCart(){
        this.entries = new HashMap<>();
    }

    /**
     * Increases the quantity of products by one as desired by customer
    */
    public void addProduct(String productName){
        CartEntry productEntry = entries.get(productName.toUpperCase());
        if(productEntry!= null){
            productEntry.increaseQuantity();
        }else{
            Product product = Product.valueOf(productName);
            CartEntry entry = new CartEntry(product, 1);
            entries.put(productName.toUpperCase(), entry);
        }
    }

    /**
     * Removes the quantity of products by one as desired by customer
     * Unable to have negative quantity of products
    */
    public void removeProduct(String productName){
        CartEntry productEntry = entries.get(productName.toUpperCase());
        if(productEntry != null){
            productEntry.decreaseQuantity();
        }    
    }

    /**
     * Obtains final count of each product in Cart View
    */
    public int getQuantity(String productName){
        CartEntry entry = entries.get(productName.toUpperCase());
        if(entry!= null){
            return entry.getQuantity();
        }
        return 0;
    }

    /**
     * Adds up total pricing of all products dependant on individual product price and its count
     * @return
     */
    public float calculateTotal(){
        float total = 0;
        for(CartEntry entry:entries.values()){
            float entryCost = entry.getProduct().getPrice()*entry.getQuantity();
            total += entryCost;
        }
        return total;
    }

    /**
     * Returns a List of each Customer order within respective cart
     */
    public List<CartEntry> getEntries(){
        return new ArrayList<>(entries.values());
    }


}
