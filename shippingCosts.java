/**
 * User chooses between standard or expedited shipping
 * Payment information is needed to put in by the user on
 * what card should be used.
 * @author S. Chang
 * @version 1.0
 */


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;


import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;


public class shippingCosts implements Initializable{

    
    /**
     * Shows information on user shipping information 
     */
    
    @FXML
    Label userFullShipping;

    /**
     * Displays the shipping information typed from the shippingInfo java page
     * @param userFirstName User first name
     * @param userLastName User last name
     * @param userAddress User address
     */
    public void displayShippingAddress(String userFirstName, String userLastName, String userAddress, String userEmailAddress, String city, String zipcode) {
        userFullShipping.setText(userFirstName + " " + userLastName + "\n" + userAddress + " " + city + ", " + zipcode);
    }
    /**
     * User gets to decide between what type of shipping
     */
    @FXML
    private ChoiceBox<String> shippingPrices;
    private String[] shippingOptions = 
    {"Standard:  4-7 Business Days                 $4.99"};{}
    // if (shippingPrices == "Standard:  4-7 Business Days                 $4.99"){
    //     double shipping = 4.99;
    // } else if (shippingPrices == "Expedited: 1-3 Business Days                 $9.99"){
    //     double shipping = 9.99;
    // } else 
    //     shipping = 0.00;
    
    
    

    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * User gets to choose between type of Card
     */
    @FXML
    private ComboBox<String> typeOfCard;
    private String[] Card =
    {
        "Credit Card", "Debit Card", "Master Card"
    };

    @FXML
    TextField userCardNumber;
    @FXML
    private Label cardNumberError;
    long cardNumber;
       
    @FXML
    TextField userCardExpiration;
    @FXML
    private Label cardExpirationError;
    int cardExpiration;

    @FXML
    TextField userCardCCV;
    @FXML
    private Label CCVError;
    int CCV;
    @FXML
    private Label userSubTotal;
    double subTotal = 0.00;
    
    @FXML
    private Label userShipping;
    double Shipping = 4.99;
    @FXML
    private Label userTotal;
    double total = subTotal + Shipping + 0.00;

    

    /**
     * typeOfCard gets all the items in the array list for
     * shippingPrices gets all the items in the array list for shippingOptions
     * @param location
     * @param resources
     */
    



    /**
     * After user inputs shipping information, user gets to go to the previous page to re-enter shipping info
     * @param event Something happens when user clicks a button
     */

    public void switchShippingInfo(ActionEvent event)throws IOException{

        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("shippingInfo.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    
    
    }
    /** 
     * After user inputs shipping information, user gets to go to the confirmation page after payment
     * @param event Something happens when user clicks a button
     */
    public void switchConfirmationPage(ActionEvent event)throws IOException{
        try{
            cardNumber = Long.parseLong(userCardNumber.getText());
            cardExpiration = Integer.parseInt(userCardExpiration.getText());
            CCV = Integer.parseInt(userCardCCV.getText());


        FXMLLoader loader = new FXMLLoader(getClass().getResource("confirmationPage.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
        
        catch (NumberFormatException e){   
        cardNumberError.setText("Card Number: Enter 16 numbers only ");
        cardExpirationError.setText("Expiration Date: Invalid Format ");
        CCVError.setText("CCV: Enter 3 numbers found on the back of your card ");
        }
        catch (Exception e){
        System.out.println(e);
    }
}
    @Override
    public void initialize(URL location, ResourceBundle resources){
        typeOfCard.getItems().addAll(Card);
        shippingPrices.getItems().addAll(shippingOptions);
        
        shippingPrices.setOnAction(this::getShippingCost);
        
        double shipping = 0.00;
        String temp = userShipping.getText();

        Shipping = Shipping(temp);

        String filePath = "/Users/germanwong/Desktop/CluckCoFXProject/CluckCoFX/src/cart.txt";
        double subtotal = 0;


        System.out.println("b4 try catch Shipping : " + Shipping + " " + shipping);


    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] elements = line.split("_"); 
            
            if (elements.length >= 3) {
                String thirdElement = elements[2];
            
                try {
                    double value = Double.parseDouble(thirdElement);
                    subtotal += value;
                } catch (NumberFormatException e) {
                    // Handle if the third element is not a valid number
                }
            }
            subTotal = subtotal;
        }
        } catch (IOException e) {
            e.printStackTrace();
     }
        System.out.println("Shipping : " + Shipping + " " + shipping);
        double Total= subTotal + shipping;
        userSubTotal.setText("" + String.format("%.2f",subTotal));
        userShipping.setText("" + String.format("%.2f",Shipping));
        userTotal.setText("" + String.format("%.2f",Total +4.99));
        
     
        
    }

    public void getShippingCost(ActionEvent event) {
        String shpCost = shippingPrices.getValue();
        if(shpCost.equals("Standard:  4-7 Business Days                 $4.99")){
            shpCost = "4.99";
            Shipping = 4.99;
           
        }
        else if(shpCost.equals("Expedited: 1-3 Business Days                 $9.99")){
            shpCost = "9.99";
            Shipping = 9.99;
        }
        userShipping.setText(shpCost);

    }

    public double Shipping(String temp){
        double shipping = 0;
        if(temp.equals("4.99")){
            shipping = 4.99;
            Shipping = shipping;

        }
        else if(temp.equals("9.99")){
            shipping = 9.99;
            Shipping = shipping;
        }
        return shipping;
    }
}
