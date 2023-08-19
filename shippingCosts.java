/**
 * User chooses between standard or expedited shipping
 * Payment information is needed to put in by the user on
 * what card should be used.
 * @author S. Chang
 * @version 1.0
 */


import java.io.IOException;
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
    public void displayShippingAddress(String userFirstName, String userLastName, String userAddress, String userEmailAddress) {
        userFullShipping.setText(userFirstName + " " + userLastName + "\n" + userAddress);
    }
    /**
     * User gets to decide between what type of shipping
     */
    @FXML
    private ChoiceBox<String> shippingPrices;
    private String[] shippingOptions = 
    {"Standard:  4-7 Business Days                 $4.99", "Expedited: 1-3 Business Days                 $9.99"};


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
    int cardNumber;
       
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

    /**
     * typeOfCard gets all the items in the array list for
     * shippingPrices gets all the items in the array list for shippingOptions
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources){
        typeOfCard.getItems().addAll(Card);
        shippingPrices.getItems().addAll(shippingOptions);
    }



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
            cardNumber = Integer.parseInt(userCardNumber.getText());
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
        cardNumberError.setText("Enter 16 numbers only ");
        cardExpirationError.setText("Enter valid month and year in format of 12 2023");
        CCVError.setText("Enter 3 numbers only ");
    }
    catch (Exception e){
        System.out.println(e);
    }
}
    
    }


