/**
 * Product class uses getters and setter methods to set infromation
 * for each instance/object created of the class
 * @author German Wong
 * @version 1.0
 * Date:            7/28/2023
 * Last Updated:    8/15/2015
 * Data Structure:  None
 */




 /** 
  * Product class sets information for each object created
  */
public class product {

    private String prodName;
    private String prodImg;
    private String prodPrice;
    private double prodDPrice;

/**
 * Constructor for product that takes four parameters
 * @param prodName name of product
 * @param prodImg name of image file
 * @param prodPrice product price for text label
 * @param prodDPrice product price for double numeric value
 */
    product(String prodName, String prodImg, String prodPrice, double prodDPrice){
        this.prodName = prodName;
        this.prodImg = prodImg;
        this.prodPrice = prodPrice;
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
}

