package CluckCo.shoppingCart;

import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;

import CluckCo.shoppingCart.cart.CartView;
import CluckCo.shoppingCart.home.HomeView;

//import javax.swing.Action;

//import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class AppController /*implements Initializable*/{
    
    @FXML
    BorderPane contentPane;

        public void closeApp(){
            App.getWindow().close();
        }

        public void showHomeView() throws IOException{
            contentPane.setCenter(new HomeView().getView());
        }

        public void showCartView() throws IOException{
            contentPane.setCenter(new CartView().getView());
        }
}
