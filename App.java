
//From Video
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


//Extras
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class App extends Application {

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Cluck&Co.fxml"));
        primaryStage.setTitle("Cluck & Co.");
        primaryStage.setScene(new Scene(root, 1315, 890));
        primaryStage.show();
    }


    //Ignore: 
    /* 
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World' ");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Cluck & Co.");
        primaryStage.setScene(scene);
        primaryStage.show();
*/
    

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
