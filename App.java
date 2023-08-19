
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class App extends Application {
     @Override
    public void start(Stage stage) {
    try {
        Parent root = FXMLLoader.load(getClass().getResource("shippingInfo.fxml"));
        Scene scene = new Scene (root);
        stage.setTitle("Cluck and Co.");
        stage.setScene(scene);
        stage.show();
}   catch (IOException e) {
            }
        }
 
 public static void main(String[] args) {
        launch(args);
    }
}
