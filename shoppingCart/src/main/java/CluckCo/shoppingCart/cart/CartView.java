/**
 * Date: 08/11/2023
 * References from the cart.fxml to set up Cart View scene from the Cart Button of the Front Page.
 * @author David Regio
 * @version 1.0 
*/

package CluckCo.shoppingCart.cart;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class CartView {

    private Parent view;
    
    /**
     * Creates Parent class called root that uses a URL path to call cart.fxml
     * @throws IOException Gives an exception if path to cart.fxml fails.
     */
    public CartView() throws IOException{
        URL uiFile = new File("/Users/regio/tutorials/shoppingCart/src/main/java/CluckCo/shoppingCart/cart/cart.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(uiFile);
        this.view = root;
    }

    /**
     * Retrieves an instance of the Cart View with order items
     * @return this.view Instance of an object under Cart View is given
     */
    public Parent getView(){
        return this.view;
    }
}
