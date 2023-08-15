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

    @FXML
    Label userFullShipping;
    public void displayShippingAddress(String userFirstName, String userLastName, String userAddress) {
        userFullShipping.setText(userFirstName + " " + userLastName + "  " + userAddress);
    }


    // " "hi" userFirstName + userLastName + "your receipt was sent to" + userEmailAddress "
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ComboBox<String> typeOfCard;
    private String[] Card =
    {
        "Credit Card", "Debit Card", "Master Card"
    };


    @Override
    public void initialize(URL location, ResourceBundle resources){
        typeOfCard.getItems().addAll(Card);
    }





    public void switchShippingInfo(ActionEvent event)throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("shippingInfo.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }
    public void switchConfirmationPage(ActionEvent event)throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("confirmationPage.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();



}
    
    }


