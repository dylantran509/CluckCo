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
    
    @FXML
	TextField userEmailAddress;

    @FXML
    private ChoiceBox<String> shippingCountry;
    private String[] Countries = 
    {"United States of America"};

    @FXML
    TextField userFirstName;

    @FXML
    TextField userLastName;
    
    @FXML
    TextField userAddress;
    
    @FXML
    TextField userCity; 

    @FXML
    private ComboBox<String> shippingStates;
    private String[] States = 
    {
    "AL", "AK", "AS", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FM", "FL", "GA", "GU", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MH", "MD", "MA", "MI", "MN", 
    "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "MP", "OH", "OK", "OR", "PW", "PA", "PR", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VI", "VA", "WA", 
    "WV", "WI", "WY"
    };

    @FXML
    TextField userZipCode;

    private Stage stage;
    private Scene scene;
    private Parent root;

	
	public void switchShippingCosts(ActionEvent event) throws IOException{
        
        String firstName = userFirstName.getText();
        String lastName = userLastName.getText();
        String address = userAddress.getText();
        String email = userEmailAddress.getText();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("shippingCosts.fxml"));
        root = loader.load();
        shippingCosts userInfo = loader.getController();
        userInfo.displayShippingAddress(firstName, lastName, address);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene  = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private Label shippingLabel;
 



    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
    shippingCountry.getItems().addAll(Countries);
    shippingStates.getItems().addAll(States);

}
   
}

