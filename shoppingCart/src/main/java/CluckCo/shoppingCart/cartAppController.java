/**
 * Date: 08/03/2023
 * Main display for the Front Page view of the Shopping Cart App 
 * This class includes access to Home View and Cart View using buttons on left side of the app.
 * @author David Regio
 * @version 1.0 
*/

package CluckCo.shoppingCart;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.event.ActionEvent;

import CluckCo.shoppingCart.cart.CartView;
import CluckCo.shoppingCart.home.cartHomeView;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;


public class cartAppController /*implements Initializable*/{

    @FXML 
    /**
     * Lays out children in top, left, right, bottom, and center positions.
     */
    BorderPane contentPane;

    //@Override
    //public void initialize(URL location, ResourceBundle resources){
        //try{

                public void closeApp(){
                    shoppingCartApp.getWindow().close();
                }


                /**
                 * Method creates separate page as platform for Home View, meant to show display of products
                 * @throws IOException Signals that an I/O exception of some sort has occurred.
                 */
                public void showHomeView() throws IOException{
                    contentPane.setCenter(new cartHomeView().getView());
                }

                /**
                 * Method creates separate page as platform for Cart View, meant to show display of User's order.
                 * @throws IOException Signals that an I/O exception of some sort has occurred.
                 */
                public void showCartView() throws IOException{
                    contentPane.setCenter(new CartView().getView());
                }
       // } catch (IOException e){
        //    e.printStackTrace();
        }

//}
