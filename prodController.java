import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;



public class prodController {


    //Do I need another prodbox for all the labels?

    //for Card
    //In video VBox is labeled Box for the card itself (the pane)
    //not even created on the video.... for second part
    @FXML
    private VBox prodCard;
    
    //Add to cart from card
    @FXML
    private Button addToCart;

    @FXML 
    private VBox prodBox;
    
    @FXML
    private ImageView img;

    @FXML
    private Label prodName;

    @FXML
    private Label prodPrice;

    private String[] colors = {"#fff"};




    public void setData(product prod){
        Image image = new Image(getClass().getResourceAsStream(prod.getProdImg()));
        img.setImage(image);
        
        prodName.setText(prod.getProdName());
        prodPrice.setText(prod.getProdPrice());

        //This part was not included for the botttom scroll thing
        prodCard.setStyle("-fx-background-color: #" + colors[(int)(Math.random()*colors.length)] + ";" +
        " -fx-background-radius: 15; " + 
        " -fx-effect: dropShadow(three-pass-box, rgba(0,0,0,0.1),10,0,0,10);");
        //30:13
    }
}
