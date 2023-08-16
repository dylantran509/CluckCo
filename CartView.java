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
     */
    public CartView() throws IOException{
        URL uiFile = new File("/Users/regio/tutorials/shoppingCart/src/main/java/CluckCo/shoppingCart/cart/cart.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(uiFile);
        this.view = root;
    }

    public Parent getView(){
        return this.view;
    }
}
