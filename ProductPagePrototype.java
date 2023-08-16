import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/*
 * Class name: ProductPagePrototype
 * Date of code: 7-25-23
 * Dylan Tran
 * This class is a prototype for the product page, which is the main page. While this class is not used in our final product page's backend component, it was
 * used for testing at the beginning stages of our project, before we had mapped out the design of our e-commerce store. It displays the product page, which is
 * meant to display all of the product names along with the images and prices of the products. It is linked to the Product Page fxml file and it shows the name
 * of the store.
 * There are no data structures in this class.
 * There are no algorithms in this class.
 */

public class ProductPagePrototype extends Application
{
    // variable for determining the position of the store window on the horizontal axis
    private double xPosition = 0;

    // variable for determining the position of the store window on the vertical axis
    private double yPosition = 0;

    // variable for the whole window which the store's interface is encapsulated in
    private static Stage window;

   /**
     * This method sets up the store by connecting it to the scene built in Scene Builder and displaying the name of the store. It puts the scene within a stage
     * that is taken as a parameter, makes the window visible with a transparent stage, and allows the window to be moved around.
     * @param stage the stage upon which the interface is displayed
     */

    @Override
    public void start(Stage stage) throws IOException
    {
        URL path = new File("<REPLACE WITH PATH>/Product Page.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(path);
        stage.setTitle("Cluck & Co.");
        stage.setScene(new Scene(root, Color.TRANSPARENT));
        stage.initStyle(StageStyle.TRANSPARENT);
        makeDraggable(root);
        stage.show();
        window = stage;
    }

    /**
     * This is the main method, which runs the store so that the window actually gets displayed.
     * @param String[] args String class with Java command line arguments for running main method
     */

    public static void main(String[] args)
    {
        launch();
    }

    /**
     * This method returns a window as the stage upon which the elements of the store interface can be displayed.
     * @return window display window for product page interface
     */

    public static Stage getWindow()
    {
        return window;
    }

    /**
     * This method allows the store window to be dragged around the screen by detecting its horizontal and vertical positions in accordance with movement
     * from the mouse.
     * @param root root node for detection of window movement
     */

    private void makeDraggable(Parent root)
    {
        root.setOnMousePressed( e -> {
            xPosition = e.getSceneX();
            yPosition = e.getSceneY();
        });
        root.setOnMouseDragged( e -> {
            window.setX(e.getScreenX() - xPosition);
            window.setY(e.getScreenY() - yPosition);
        });
    }
}