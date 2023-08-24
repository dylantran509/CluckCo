/**
 * Product class uses getters and setter methods to set infromation
 * for each instance/object created of the class
 * @author David Regio
 * @version 1.3
 * Date:            7/28/2023
 * Last Updated:    8/20/2023
 * Data Structure:  None
 */

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/** 
  * Product class sets information for each object created
  */
public class cartProductControl {

    private String prodName;
    private String prodImg;
    private String prodPrice;
    private double prodDPrice;

    @FXML
    private ImageView img;

    @FXML
    private Label prdName;

    @FXML
    private Label prdPrice;

/**
 * Constructor for product that takes four parameters
 * @param prodName This is the name of product
 * @param prodImg Name of image file
 * @param prodPrice Product price for text label
 * @param prodDPrice Product price for double numeric value
 */
    cartProductControl(String prodName, String prodImg, String prodPrice, double prodDPrice){
        this.prodName = prodName;
        this.prodImg = prodImg;
        this.prodPrice = prodPrice;
        this.prodDPrice = prodDPrice;
    }

    cartProductControl(String prodName, double prodDPrice){
        this.prodName = prodName;
        this.prodDPrice = prodDPrice;
    }

    /**
     * Gets the product name
     * @return returns product name
     */
    public String getProdName(){
        return prodName;
    }
    
    
    /** 
     * Sets the product name from parameter
     * @param prodName string that is used for the product name
     */
    public void setProdName(String prodName){
        this.prodName = prodName;
    }

    /**
     * Gets product image file name
     * @return returns the name of the product image file
     */
    public  String getProdImg(){
        return prodImg;
    }

    /**
     * Sets the path for the product image 
     * @param image sets the image file name in prodImg
     */
    public void setProdImg(String image){
        prodImg = image;
    }

    /**
     * Gets product price in string 
     * @returns returns the price of the product 
     */
    public String getProdPrice(){
        return prodPrice;
    }

    /**
     * Sets a string version of the prodcut price
     * @param price the value of the prodcut 
     */
    public void setProdPrice(String price){
        prodPrice = price;
    }

    /**
     * Sets a double version of the product price 
     * @param price
     */
    public void setProdDPrice(double price){
        prodDPrice = price;
    }


    /**
     * Gets the price of the product in a double 
     * @return prodDPrice as a double
     */
    public double getProdDPrice(){
        return prodDPrice;
    }

    /**
     * Loads up contents of individual product items into the Shopping Cart, including their image, name, and price
     * @param prod Each product is held within a value, prod, of type Product
     */
    public void setDataCart(product prod){
        Image image = new Image(getClass().getResourceAsStream(prod.getProdImg()));
        img.setImage(image);
        
        prdName.setText(prod.getProdName());
        prdPrice.setText("$"+prod.getProdPrice());
        
    }
}