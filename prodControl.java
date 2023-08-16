/**
 * Product control is a control class that will set 
 * information of the product such as name, image, price.
 * constructs the product card. 
 * @author German Wong
 * @version 1.0
 * Date:            7/28/2023
 * Last Updated:    8/15/2015
 * Data Structure:  None
 */


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
}