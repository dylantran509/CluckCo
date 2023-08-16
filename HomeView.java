/**
 * Date: 08/08/2023
 * References from the home.fxml to set up Home View scene from the Home Button.
 * @author David Regio
 * @version 1.0 
*/

package CluckCo.shoppingCart.home;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class HomeView {

    private Parent view;

    /**
     * Creates Parent class called root that uses a URL path to call home.fxml
     */
    public HomeView() throws IOException{
        URL url = new File("/Users/regio/tutorials/shoppingCart/src/main/java/CluckCo/shoppingCart/home/home.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);

        this.view = root;
    }

    public Parent getView(){
        return view;
    }
}
