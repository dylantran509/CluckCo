import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {
    
    //ImageView is a Node used for painting images loaded with Images

    @FXML

    ImageView myImageView;
    Button myButton;

    Image Cluck_and_Co= new Image(getClass().getResourceAsStream("Cluck_and_Co.png"));
    
    public void displayImage() {
        myImageView.setImage(Cluck_and_Co);
    }
}
