import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.scene.Node;

/**
 * a.) Class name: SearchController
 * b.) Date of code: 8-11-23
 * c.) Dylan Tran
 * d.) This class is the controller for the search feature, which opens up a pop-up window on the home page. As a user types in a key word and clicks the "search" button,
 * the list view from the interface displays the appropriate matching terms that are provided in the array list below.
 * e.) There is an ArrayList used to hold all the product names with their prices; these are the searchable items. Additionally, a List is used to hold any words that
 * match with searched key words.
 * f.) The algorithm used here was chosen because it was the most efficient for traversing and returning values from an array list for a search function.
 * This algorithm is found within the List method, which displays an appropriate list of products that have names which match search terms.
 */

public class SearchController implements Initializable
{

    private Stage stage;
    private Scene scene;
    private Parent root;

    // ArrayList contains names of items along with their prices to be displayed accordingly with entered search term or terms
    ArrayList<String> products = new ArrayList<>(
        Arrays.asList(
            "Black Hoodie          $50.00",
                 "Black Hat             $20.00", 
                 "Black Shirt           $25.00", 
                 "Sticker                $5.00",
                 "White Hoodie          $60.00",
                 "White Shirt           $30.00")
    );

    // text field for the interface - a search bar for users to type key words into
    @FXML
    private TextField searchBar;

    // list view of all product names along with their prices that correspond with any entered search terms
    @FXML
    private ListView<String> listView;

    /**
     * This method detects when the user presses the search button to trigger the search function; it clears the beginning display of all products and takes in
     * whichever term or terms that the user has entered.
     * @param event detection of click on search button to trigger a search
     */

    @FXML
    void search(ActionEvent event)
    {
        listView.getItems().clear();
        listView.getItems().addAll(searchList(searchBar.getText(), products));
    }

    /**
     * This method detects when the user presses the home button to return to the product page.
     * @param event detection of click on home button to return to home page
     */

    @FXML
    public void home(ActionEvent event) throws IOException{
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("homePage.fxml"));
        root = fxmlLoader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene  = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method initializes the list of product names and prices to be displayed.
     * @param url resource for words to be taken into list
     * @param resourceBundle resources for list tool to generate list
     */

    /**
     * This method initializes the list of product names and prices to be displayed.
     * @param url resource for words to be taken into list
     * @param resourceBundle resources for list tool to generate list
     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        listView.getItems().addAll(products);
    }

    /**
     * This method executes the search feature by finding any matching product names or prices with searched key words in order to display the appropriate products.
     * @param searchWords words entered in search bar
     * @param stringList list of all String values in search
     * @ return searchProducts array of products that match searched terms
     */

    private List<String> searchList(String searchWords, List<String> stringList)
    {
        List<String> searchProducts = Arrays.asList(searchWords.trim().split(" "));

        return stringList.stream().filter(input -> {
            return searchProducts.stream().allMatch(word ->
                    input.toLowerCase().contains(word.toLowerCase()));
        }).collect(Collectors.toList());
    }
}