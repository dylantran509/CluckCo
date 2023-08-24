/**
 * Maintains Shopping Cart's condition and Customer order by working between the Home Page and Shipping Information
 * @author David Regio
 * @version 1.3
 * Date:            7/28/2023
 * Last Updated:    8/20/2023
 * Data Structure:  None
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class cart implements Initializable{

   
    /**
     * Create variables to establish contents of Shopping Cart
     */
    private Stage stage;
    private Scene scene;
    private Parent root;

    public List<product> cart = new ArrayList<>();

    @FXML
    private VBox prdBox;

    @FXML
    private GridPane cartContainer;
    

    @Override
    public void initialize(URL location, ResourceBundle resources){

        int column = 0;
        int row = 1; 

        /**
         * Reads cart.txt file that holds product information
         */
        readfile();
        try {

            for(product prod : cart){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("cartProduct.fxml")); 
                System.out.println(prod.getProdName());      

                /**
                 * Loads the vertical box that holds a label and the girdPane
                 */ 
                VBox prdBox = fxmlLoader.load();
                cartProductControl prodCntrl = fxmlLoader.getController();
                prodCntrl.setDataCart(prod);

                if(column ==6){
                    column =0;
                    ++row;
                }
                
                cartContainer.add(prdBox, column++, row);              
                GridPane.setMargin(prdBox, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
     
    }

    /**
     * Sets up contents for the Home Page using the homePage.fxml file
     * @param event Used to generate some action of type ActionEvent
     * @throws IOException Handles any exceptions caused by loading the Home Page
     */
    public void toHomePage(ActionEvent event)throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    /**
     * Sets up contents for th Shipping Info Request Page using the shippingInfo.fxml file
     * @param event Used to generate some action of type ActionEvent
     * @throws IOException Handles any exceptions caused by loading the Shipping Info Request Page
     */
    public void toShippingInfo(ActionEvent event)throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("shippingInfo.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }


    String filePath = "/Users/germanwong/Desktop/CluckCoFXProject/CluckCoFX/src/cart.txt";

    /**
     * Reads input "product.txt" file
     */
    void readfile(){
        
        File file = new File(filePath);

        try {                                                         
            FileReader fileReader = new FileReader(file);                  
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            while (line != null) {
                
                //Sets data for card using the information from the text file
                addToCart(line);
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Sets the name of product, image, and price for the product card
     * @param line line of information extracted from the text file. 
     */
    public void addToCart(String line){
        String[] prod = line.split("_");
        double price = Double.parseDouble(prod[2]);

        product temp = new product(prod[0],"/img/"+prod[1],prod[2],price);
        cart.add(temp);

        System.out.println(temp.getProdName());

    }
    
}
