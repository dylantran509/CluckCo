/**
 * Product control is a control class that will set 
 * information of the product such as name, image, price.
 * constructs the product card. 
 * @author German Wong
 * @version 1.3
 * Date:            7/28/2023
 * Last Updated:    8/21/2015
 * Data Structure:  None
 */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;


/**
 * 
 */
public class prodControl {



    @FXML
    /**
     * Place holder for information in prodcut card
     */
    private VBox prodCard;
    
    @FXML
    /**
     * Button that will take the user the shopping cart page
     */
    private Button addToCart;

    @FXML 
    /**
     * place holder for prodcut 
     */
    private VBox prodBox;
    
    @FXML
    /**
     * image file to be used
     */
    private ImageView img;

    @FXML
    /**
     * Name of product
     */
    private Label prodName;

    @FXML
    /**
     * Product price
     */
    private Label prodPrice;

    //private String[] colors = {"#fff"};




    
    /** 
     * Sets the date to the product. 
     * Sets immage 
     * @param prod passes product information and sets the
     *  data and image for the product
     */
    public void setData(product prod){
        Image image = new Image(getClass().getResourceAsStream(prod.getProdImg()));
        img.setImage(image);
        
        prodName.setText(prod.getProdName());
        prodPrice.setText("$"+prod.getProdPrice());
        
    }

    /**
     * Button that adds the item to cart 
     * @param event by clicking on "Add to Cart" the program will add all 
     * product information into the cart.txt file.
     * @throws IOException
     */
    public void addToCart(ActionEvent event)throws IOException{
        product prod = search(prodName.getText());
        addToCartFile(prod);

    }

    /**
     * Searches a for an item by it's product name
     * @param prodName
     * @return
     */
    public product search(String prodName){

        //compare the string to items in an array 

        //Need to relook at constructor
        product prod = new product(prodName, prodName, prodName, 0);
        homeControl hmControl = new homeControl();
        hmControl.readfile();

        for(int i = 0; i< hmControl.prodList.size(); i++){
            if(hmControl.prodList.get(i).getProdName().equals(prodName)){
                prod = hmControl.prodList.get(i);
            }
        }
        return prod;
    }

    /**
    * Searches for a specific file's pathway. 
    * @return returns the file path in a string
    */
    public String getUserFilePath(){
        Path path = Paths.get("cart.txt");
        return path.toAbsolutePath().toString();
       
    }
 
    /**
     * Adds the item the customer selected to the cart.txt. file 
     * @param prod takes in a product and the product information.
     * @throws IOException
     */
    public void addToCartFile(product prod) throws IOException{
        try(FileWriter orderWriter = new FileWriter(getUserFilePath(), true); 
            BufferedWriter itemInfo = new BufferedWriter(orderWriter);
            PrintWriter out = new PrintWriter(itemInfo))
            {
            out.println(prod.getProdName()+ "_" + prod.getProdImg() + "_" + prod.getProdPrice() + "_" + prod.getProdDPrice());
        } 
        catch (IOException e) {
            System.out.println("function no work");
        }
    }


} 
