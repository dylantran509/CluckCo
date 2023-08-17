/**
 * Shipping information is needed to put in by the user on
 * where the delivery should take place
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
import javafx.stage.Stage;
import javafx.scene.Node;

public class shippingInfo implements Initializable{
    /** 
     * User inputs their Email Address
    */ 
    @FXML
	TextField userEmailAddress;

    /**
     * User selects what Country they are in
     */
    @FXML
    private ChoiceBox<String> shippingCountry;
    private String[] Countries = 
    {"United States of America"};

    /** 
     * User inputs their Name
    */ 
    @FXML
    TextField userFirstName;

    /** 
    * User inputs their Last Name
    */
    @FXML
    TextField userLastName;
    
    /** 
     * User inputs what address they live in
    */
    @FXML
    TextField userAddress;
    
    /**
     * User inputs what city
     */
    @FXML
    TextField userCity; 

    /**
     * User selects what state they are from
     */
    @FXML
    private ComboBox<String> shippingStates;
    private String[] States = 
    {
    "AL", "AK", "AS", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FM", "FL", "GA", "GU", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MH", "MD", "MA", "MI", "MN", 
    "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "MP", "OH", "OK", "OR", "PW", "PA", "PR", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VI", "VA", "WA", 
    "WV", "WI", "WY"
    };

    /**
     * User inputs what zip code they are in
     */
    @FXML
    TextField userZipCode;

    private Stage stage;
    private Scene scene;
    private Parent root;

    /** After user inputs shipping information, user gets to go to the next page to enter payment
     * @param event Something happens when user clicks a button
     */
	
	public void switchShippingCosts(ActionEvent event) throws IOException{
        
        String firstName = userFirstName.getText();
        String lastName = userLastName.getText();
        String address = userAddress.getText();
        String email = userEmailAddress.getText();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("shippingCosts.fxml"));
        root = loader.load();
        shippingCosts userInfo = loader.getController();
        userInfo.displayShippingAddress(firstName, lastName, address, email);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene  = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    

    /**
     * shippingCountry gets all the items in the array list for Countries
     * shippingStates gets all the items in the array list for States
     * @param location
     * @param resources
     */

    @Override
    public void initialize(URL location, ResourceBundle resources){
    shippingCountry.getItems().addAll(Countries);
    shippingStates.getItems().addAll(States);

}
   
}

