
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class shippingInfo implements Initializable{
    private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchShippingCosts(ActionEvent event) throws IOException, java.lang.reflect.InvocationTargetException {
        try{Parent tableViewParent = FXMLLoader(getClass().getResource("shippingCosts.fxml"));	
		Scene tableViewScene = new Scene(tableViewParent);	
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    } catch	(java.lang.reflect.InvocationTargetException itex) { System.out.println(("invocation target exception occurred")); 
    itex.getCause(); } 
    }

// scene = new Scene(root);
		// stage.setScene(scene);
		// stage.show();
//         public Stage stage;
//         public Scene scene;
//         public Parent root;
//     public void switchShippingCosts(ActionEvent event) throws IOException {
//         Parent root = FXMLLoader.load(getClass().getResource("shippingCosts.fxml"));
//         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//         scene = new Scene(root);
//         stage.setScene(scene);
//         stage.show();
//         }
    
//      public void switchShippingInfo(ActionEvent event) throws IOException {
//         Parent root = FXMLLoader.load(getClass().getResource("shippingInfo.fxml"));
//         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//         scene = new Scene(root);
//         stage.setScene(scene);
//         stage.show();
//         }
    

    private Parent FXMLLoader(URL resource) {
        return null;
    }

    @FXML
    private Label shippingLabel;

    @FXML
    private ChoiceBox<String> shippingCountry;
    private String[] Countries = 
    {"United States of America"};

    @FXML
    private ComboBox<String> shippingStates;
    
    private String[] States = 
    {
    "AL", "AK", "AS", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FM", "FL", "GA", "GU", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MH", "MD", "MA", "MI", "MN", 
    "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "MP", "OH", "OK", "OR", "PW", "PA", "PR", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VI", "VA", "WA", 
    "WV", "WI", "WY"
    };

    @FXML
	TextField emailAddress;
	
	
 
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
    shippingCountry.getItems().addAll(Countries);
    shippingStates.getItems().addAll(States);

    
    // shippingCountry.setOnAction(this::getCountry);
}
    // public void getCountry (ActionEvent event){
        // String myCountry = shippingCountry.getValue();
    //     shippingLabel.setText(myCountry);

    // }
}

