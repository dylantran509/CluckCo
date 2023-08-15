package CluckCo.shoppingCart.home;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class HomeView {

    private Parent view;

    public HomeView() throws IOException{
        URL url = new File("/Users/regio/tutorials/shoppingCart/src/main/java/CluckCo/shoppingCart/home/home.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);

        this.view = root;
    }

    public Parent getView(){
        return view;
    }
}
