package CluckCo.shoppingCart.home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import CluckCo.shoppingCart.cart.ShoppingCart;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
//import javafx.geometry.Insets;
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
    private GridPane productGridPane;

    @FXML
    public void initialize() throws FileNotFoundException{
        productGridPane.getChildren().clear();

        VBox productView1 = productView(Product.APPLE);
        productGridPane.add(productView1, 0, 0);

        VBox productView2 = productView(Product.MILK);
        productGridPane.add(productView2, 1, 0);

        VBox productView3 = productView(Product.JUICE);
        productGridPane.add(productView3, 2, 0);

        VBox productView4 = productView(Product.LETTUCE);
        productGridPane.add(productView4, 3, 0);
    }

    private VBox productView(Product product) throws FileNotFoundException{
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);

        FileInputStream input = new FileInputStream(
            "Users/regio/tutorials/shoppingCart/src/main/java/CluckCo/shoppingCart"
            + product.getImageFile()); //Change later. Add a Resources folder with jpg images of the groceries.

            Image image = new Image(input);
            ImageView  imageView = new ImageView(image);
            imageView.setFitWidth(100);
            imageView.setFitHeight(100);
            
            Label productName = new Label(product.name());
            Label price = new Label(product.getPrice() + " $");

            Button addButton = new Button("Add to Cart");

            addButton.setUserData(product.name());
            addButton.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent actionEvent){
                    //add product to shopping cart
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
