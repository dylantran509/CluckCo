/**
 * Home page for Cluck & Co. E-Commerce site. Site will display items
 * being sold in our site. It includes functions like search, add to
 * cart, and view cart. 
 * @author German Wong, Dylan Tran, David Regio, Simon Chang
 * @version 1.0
 * Date:            7/20/2023
 * Last Updated:    8/15/2015
 * Data Structure:  ArrayList
 */



import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        try{
            Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));

            primaryStage.setTitle("Cluck & Co.");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            }  
    }


    public static String getUserFilePath(String filePath){
        Path path = Paths.get(filePath);
        return path.toAbsolutePath().toString();
    }

    public static void main(String[] args)throws IOException {
        launch(args);
        
        File cart = new File(getUserFilePath("cart.txt")); 
        cart.delete();
        cart.createNewFile();
    }
}
