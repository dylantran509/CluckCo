package CluckCo.shoppingCart;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.control.Label;
//import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
//import javafx.stage.StageStyle;

/**
 * JavaFX App
 */

public class App extends Application {

    private static Stage window;

    @Override
    public void start(Stage stage) throws MalformedURLException, IOException{
        

        URL file = 
            new File("/Users/regio/tutorials/shoppingCart/src/main/java/CluckCo/shoppingCart/cart-ui.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(file);

        stage.setTitle("Shopping Cart");
        //stage.initStyle(StageStyle.TRANSPARENT); //Removes window frame
        stage.setScene(new Scene(root, Color.TRANSPARENT));
        stage.show(); //Brings Shopping Cart stage to view

    }
    public static void main(String[] args) { launch(); }
 
    public static Stage getWindow(){
        return window;
    }
}
