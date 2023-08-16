/**
 * Date: 08/08/2023
 * Main display for the 'Home View' of the cart. 
 * This class includes placement of all products by row/column as well as the buttons "Add to Cart" "$ PRICE"
 * @author David Regio
 * @version 1.0 
*/

//import javafx.geometry.Insets;

package CluckCo.shoppingCart.home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import CluckCo.shoppingCart.cart.ShoppingCart;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class HomeController {
    
    @FXML
    /*
    * Allows for products to be evenly distributed across the order page in the cart.
     */
    private GridPane productGridPane;

    @FXML
    public void initialize() throws FileNotFoundException{
        productGridPane.getChildren().clear();

        /**
         * All 4 products are placed in a designated position in the cart view page.
        */ 
        VBox productView1 = productView(Product.APPLE);
        productGridPane.add(productView1, 0, 0);

        VBox productView2 = productView(Product.MILK);
        productGridPane.add(productView2, 1, 0);

        VBox productView3 = productView(Product.JUICE);
        productGridPane.add(productView3, 2, 0);

        VBox productView4 = productView(Product.LETTUCE);
        productGridPane.add(productView4, 3, 0);
    }

    /**
     * Creates grid and borders for the general layout of products
    */
    private VBox productView(Product product) throws FileNotFoundException{
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);

        /** 
         * References product images (type jpg) through its folder path
         */
        FileInputStream input = new FileInputStream(
            "Users/regio/tutorials/shoppingCart/src/main/java/CluckCo/shoppingCart"
            + product.getImageFile());

        
            Image image = new Image(input);
            ImageView  imageView = new ImageView(image);
            imageView.setFitWidth(100);
            imageView.setFitHeight(100);
            
            /**
             * Implements price and name of product
             */
            Label productName = new Label(product.name());
            Label price = new Label(product.getPrice() + " $");

            /** 
             * Input button labeled "Add to Cart" that carries an ActionEvent
             */
            Button addButton = new Button("Add to Cart");

            /**
             * Takes User's data such as quantity, price, and info of chosen products
             */
            addButton.setUserData(product.name());
            addButton.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent actionEvent){
                    /**
                     * add product to shopping cart
                     */
                    Node sourceComponent = (Node)actionEvent.getSource();
                    String productName = (String)sourceComponent.getUserData();
                    ShoppingCart shoppingCart = ShoppingCart.getInstance();
                    shoppingCart.addProduct(productName);
                }
            });

            layout.getChildren().addAll(imageView, productName, price, addButton);

            return layout;
    }

    
}
