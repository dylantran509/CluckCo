/**
 * User should get a confirmation page to their email 
 * with what they had ordered
 * In Progress
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


public class confirmationPage implements Initializable{

   

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Label confirmationLabel;

    public void displayConfirmationReceipt(String userFirstName, String userLastName, String userEmailAddress) {
        confirmationLabel.setText("Hello your order was received and an email was sent to your email address! \n Thank you for shopping with us! ");
    }



    
    /** 
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources){

    }
    
}