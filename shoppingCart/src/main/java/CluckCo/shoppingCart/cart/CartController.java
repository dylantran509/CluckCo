/**
 * Date: 08/11/2023
 * Displays working buttons and ActionEvents 
 * to manage products in between Home View and Cart View
 * @author David Regio
 * @version 1.0 
*/

package CluckCo.shoppingCart.cart;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CartController {
    /**
     * Creates vertical columns for Cart View
     */
    @FXML
    private VBox cartPane;

    /**
     * Creates variable for the Total Price of order of type Label
     */
    private Label totalPriceLabel;

    /**  
     * This method initializes a shopping cart as an instance of a List data structure with no entries. In the shopping cart, there are labels
     * for added items if any items are to be added from the product page; otherwise, the cart is labeled as empty. If the shopping cart has items in it,
     * the information about the items, including their names, prices, and images. This method additionally separates the displays of the products in the cart.
     */
    @FXML
    public void initialize() throws FileNotFoundException{
    
        List<CartEntry> entries = ShoppingCart.getInstance().getEntries();
        cartPane.getChildren().clear();

        if(entries.isEmpty()){
            Label emptyLabel = new Label("Empty Cart");
            cartPane.getChildren().add(emptyLabel);
        }else{
            Label shoppingCartTitle = new Label("Shopping Cart");
            cartPane.getChildren().add(shoppingCartTitle);

            for(CartEntry cartEntry:entries){
                HBox productView = cartEntryView(cartEntry);
                cartPane.getChildren().add(productView);
            }

            Separator separator = new Separator();
            separator.setOrientation(Orientation.HORIZONTAL);
            cartPane.getChildren().add(separator);

            HBox totalView = totalView(ShoppingCart.getInstance().calculateTotal());
            cartPane.getChildren().add(totalView);
        }
    }

    /**
     * This method displays a calculated total of the prices of all items that have been added to the cart. 
     * The method determines the way that the total is
     * displayed on the interface in terms of its position and appearance.
     * @param totalPrice Takes the total order price as type float
     * @return layout Gives final display of price
     */
    private HBox totalView(float totalPrice){
        HBox layout = new HBox();
        layout.setAlignment(Pos.CENTER);

        Label totalLabel = new Label("Total: ");;
        totalLabel.setStyle("-fx-font-size:15pt:");

        this.totalPriceLabel = new Label(String.valueOf(totalPrice));

        layout.getChildren().addAll(totalLabel, this.totalPriceLabel);
        return layout;
    }

    /**
     * This method displays buttons for each product in the cart and also adjusts the total price of the items. The buttons are there to add to or subtract
     * from the quantity of each item in the cart. The buttons are positioned accordingly to the displays of the items in the cart so that they are positioned
     * in a consistent manner. Along with these buttons - one for adding and one for subtracting - is a display of the product's image, name, and price.
     * @param cartEntry Takes variable of type 'CartEntry', created from CartEntry.java
     * @return layout Outputs the display of a single product, with its buttons, in Cart View
     * @throws FileNotFoundException Signals that an attempt to open the file denoted by a resources has failed.
     */
    private HBox cartEntryView(CartEntry cartEntry) throws FileNotFoundException{
        HBox layout = new HBox();
        layout.setAlignment(Pos.CENTER_LEFT);

        FileInputStream input = new FileInputStream(
            "/Users/regio/dev/sample/src/main/resources/" + cartEntry.getProduct().getImageFile());
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);

        Label productName = new Label(cartEntry.getProduct().name());
        productName.setPrefWidth(100);
        productName.setStyle("-fx-font-size:15pt; -fx-padding:5px");

        Label quantity = new Label(String.valueOf(cartEntry.getQuantity()));
        quantity.setStyle("-fx-padding:5px");

        Button plusButton = new Button("+");
        plusButton.setStyle("-fx-padding:5px");
        plusButton.setUserData(cartEntry.getProduct().name());
        plusButton.setOnAction(e -> {
            String name = (String) ((Node) e.getSource()).getUserData();
            ShoppingCart.getInstance().addProduct(name);
            quantity.setText(String.valueOf(ShoppingCart.getInstance().getQuantity(name)));
            this.totalPriceLabel.setText(String.valueOf(ShoppingCart.getInstance().calculateTotal()));
        });

        Button minusButton = new Button("-");
        minusButton.setStyle("-fx-padding:5px");

        Label price = new Label(String.valueOf("$ " + cartEntry.getProduct().getPrice()));
        price.setStyle("-fx-padding:5px");

        layout.getChildren().addAll(imageView, productName, plusButton, quantity, minusButton, price);

        return layout;
    }
}
