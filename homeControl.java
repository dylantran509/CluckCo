//German Wong
//Updated 8/12/2023


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.Node;


public class homeControl implements Initializable {



    @FXML
    private VBox prodBox;

    @FXML
    private GridPane prodContainer;
    private List<product> productList;

    private Stage stage;
    private Scene scene;
    private Parent root;

    
    @Override
    public void initialize(URL location, ResourceBundle resources){
        productList = new ArrayList<>(productList());
        int column = 0;
        int row = 1; 

        try {
            for(product prod : productList){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("product.fxml"));

                VBox prodBox = fxmlLoader.load();
                prodControl prodCntrl = fxmlLoader.getController();
                prodCntrl.setData(prod);

                if(column ==6){
                    column =0;
                    ++row;
                }

                prodContainer.add(prodBox, column++, row);
                GridPane.setMargin(prodBox, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void toCart(ActionEvent event) throws IOException{
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
        root = fxmlLoader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene  = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //PRODUCT LIST
    private List<product> productList(){
        List<product> ls = new ArrayList<>();
        
        //Black Hoodie
        product prod = new product();
        prod.setProdName("Black Hoodie");
        prod.setProdImg("/img/blackHoodie.png");
        prod.setProdPrice("$50.00");
        prod.setProdDPrice(50.00);
        ls.add(prod);
        
        //Black Shirt
        prod = new product();
        prod.setProdName("Black Shirt");
        prod.setProdImg("/img/blackShirt.png");
        prod.setProdPrice("$25.00");
        prod.setProdDPrice(25.00);
        ls.add(prod);

        //Black Hat
        prod = new product();
        prod.setProdName("Black Hat");
        prod.setProdImg("/img/hat.png");
        prod.setProdPrice("$20.00");
        prod.setProdDPrice(20.00);
        ls.add(prod);

        //Cluck & Co. Sticker
        prod = new product();
        prod.setProdName("Cluck & Co. Sticker");
        prod.setProdImg("/img/logo.png");
        prod.setProdPrice("$5.00");
        prod.setProdDPrice(5.00);
        ls.add(prod);

        return ls;
    }

}



