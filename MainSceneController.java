import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class MainSceneController implements Initializable{

    @FXML
    private Label shippingLabel;

    @FXML
    private ChoiceBox<String> shippingCountry;
    private String[] Countries = 
    {"United States of America"};

    @FXML
    private ChoiceBox<String> shippingState;
    
    private String[] States = 
    {
    "AL", "AK", "AS", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FM", "FL", "GA", "GU", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MH", "MD", "MA", "MI", "MN", 
    "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "MP", "OH", "OK", "OR", "PW", "PA", "PR", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VI", "VA", "WA", 
    "WV", "WI", "WY"
    };
     
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
    shippingCountry.getItems().addAll(Countries);
    shippingState.getItems().addAll(States);

    
    // shippingCountry.setOnAction(this::getCountry);
}
    // public void getCountry (ActionEvent event){
        // String myCountry = shippingCountry.getValue();
    //     shippingLabel.setText(myCountry);

    // }
}
