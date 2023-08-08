package Cart;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, CartEntry> entries;

    public ShoppingCart(){
        this.entries = new HashMap<>();
    }

    public void addProduct(String productName){
        CartEntry productEntry = entries.get(productName.toUpperCase());
        if(productEntry != null){
            productEntry.increaseQuantity();
        } else{
            Product product = Product.valueOf(productName);
            CartEntry entry = new CartEntry(product, 1);
            entries.put(productName.toUpperCase(), entry);
        }
    }

    public void removeProduct(String productName){
        CartEntry productEntry = entries.get(productName.toUpperCase());
        if(productEntry != null){
            productEntry.decreaseQuantity();
        }
    }

    public int getQuantity(String productName){
        CartEntry entry = entries.get(productName.toUpperCase());
        if(entry != null){
            return entry.getQuantity();
        }
        return 0;
    }

    public float calculateTotal(){
        float total = 0;
        for(CartEntry entry:entries.values()){
            float entryCost = entry.getProduct().getPrice() * entry.getQuantity();
            total += entryCost;
        }
        return total;
    }


}
