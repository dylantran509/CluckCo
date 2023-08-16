/**
 * Home page for Cluck & Co. E-Commerce site. Site will display items
 * being sold in our site. It includes functions like search, add to
 * cart, and view cart. 
 * @author German Wong
 * @version 1.0
 * Date:            7/24/2023
 * Last Updated:    8/15/2015
 * Data Structure:  ArrayList
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.Node;

/**
 *  homeControl class holds methods of the home page. It reads files
 */
public class homeControl implements Initializable {

    @FXML
    /**
     * holds a lable for browser and the GridPane
     */
    private VBox prodBox;

    @FXML
    /**
     * Grid that diplays product cards
     */
    private GridPane prodContainer;

    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Array that holds the product information
     */
    private List<product> prodList = new ArrayList();
    
    
    /**
     * Initializes the GridPane, reads a file and builds sets data to cards. 
     * It also displays them in the GridPane
     * @param location descritipon of location
     * @param resource description of resource 
     */
    @Override
    public void initialize(URL location, ResourceBundle resources){

        int column = 0;
        int row = 1; 

        //Reads product.txt file that holds product information
        readfile();
        try {

            //Loop to display each product into the GridPane
            for(product prod : prodList){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("product.fxml"));

                //Loads the vertical box that holds a label and the girdPane
                VBox prodBox = fxmlLoader.load();
                prodControl prodCntrl = fxmlLoader.getController();
                prodCntrl.setData(prod);

                if(column ==6){
                    column =0;
                    ++row;
                }

                //Adds product card to gridPane
                prodContainer.add(prodBox, column++, row);
                GridPane.setMargin(prodBox, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }


    String filePath = "/Users/germanwong/Desktop/Comp380/380Project/src/product.txt";

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
                setData(line);
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
    void setData(String line){
        String[] prod = line.split("_");
        double price = Double.parseDouble(prod[2]);

        product temp = new product(prod[0],"/img/"+prod[1],prod[2],price);
        prodList.add(temp);
    }

    /**
     * Switches scene from homepage to the cart page where it holds items
     * the user has added to the cart. 
     * @param event is the click of the shopping cart button
     */
    public void toCart(ActionEvent event) throws IOException{
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
        root = fxmlLoader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene  = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toSearchWindow(ActionEvent event) throws IOException{
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SearchWindow.fxml"));
        root = fxmlLoader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene  = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
 

}


