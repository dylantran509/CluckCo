/**
 * Date: 08/03/2023
 * References from the cart-ui.fxml to set up Front page of Shopping Cart App.
 * @author David Regio
 * @version 1.0 
*/

//import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URL;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.control.Label;
//import javafx.scene.layout.StackPane;
//import javafx.scene.paint.Color;
//import javafx.stage.StageStyle;

package CluckCo.shoppingCart;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */

public class App extends Application {

    //private static Stage window;

    @Override
    /**
     * The start method is called after the system is ready for the application to begin running. 
     * @param primaryStage This object is constructedby the Shopping Cart App
     */
    public void start(Stage primaryStage){
        
    /**
     * Creates Parent class called root that uses Class getResource to call cart-ui.fxml
     */
        try{
            Parent root = FXMLLoader.load(getClass().getResource("cart-ui.fxml"));
            primaryStage.setTitle("Cluck & Co.");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            }  

        // // URL file = 
        // //     new File("/C://Users//regio//tutorials//shoppingCart//src//main//java//CluckCo//shoppingCart//cart-ui.fxml/").toURI().toURL();
        // // Parent root = FXMLLoader.load(file);

        // stage.setTitle("Shopping Cart");
        // //stage.initStyle(StageStyle.TRANSPARENT); //Removes window frame
        // stage.setScene(new Scene(root, Color.TRANSPARENT));
        // stage.show(); //Brings Shopping Cart stage to view

    }
    /**
     * Main method executes Shopping Cart App
     * @param args An array of String arguments passed to the App when it's launched.
     */
    public static void main(String[] args) { launch(); }
    

    // public static Stage getWindow(){
    //     return window;
    // }
}