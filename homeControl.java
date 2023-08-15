//German Wong
//Updated 8/14/2023
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

    private List<product> prodList = new ArrayList();
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources){

        int column = 0;
        int row = 1; 
        
        readfile();
        
        try {
            for(product prod : prodList){
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
    
    //filePath TO BE CHANGED DEPENDING ON USER PATH
    String filePath = "/Users/germanwong/Desktop/Comp380/380Project/src/product.txt";

    void readfile(){
        File file = new File(filePath);


        try {                                                              
            FileReader fileReader = new FileReader(file);                 
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            while (line != null) {
                //System.out.println(line);
                setData(line);
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    void setData(String line){
        String[] prod = line.split("_");
        double price = Double.parseDouble(prod[2]);

        product temp = new product(prod[0],"/img/"+prod[1],prod[2],price);
        prodList.add(temp);
    }


    public void toCart(ActionEvent event) throws IOException{
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
        root = fxmlLoader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene  = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
