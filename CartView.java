package CluckCo.shoppingCart.cart;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class CartView {

    private Parent view;
    
    public CartView() throws IOException{
        URL uiFile = new File("/Users/regio/tutorials/shoppingCart/src/main/java/CluckCo/shoppingCart/cart/cart.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(uiFile);
        this.view = root;
    }

    public Parent getView(){
        return this.view;
    }
}
