/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diapershopms;

import com.sun.javaws.Main;
import java.awt.Checkbox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author muhammadammar
 */
public class FXMLDocumentController implements Initializable {
  @FXML
    private TableView<InventoryItem> inventoryTable;

    @FXML
    private TableColumn<InventoryItem, String> inventoryID;

    @FXML
    private TableColumn<InventoryItem, String> inventoryName;

    @FXML
    private TableColumn<InventoryItem, String> inventoryDescription;

    @FXML
    private TableColumn<InventoryItem, String> inventoryQty;

    @FXML
    private TableColumn<InventoryItem, String> inventoryPurchasingPrice;

    @FXML
    private TableColumn<InventoryItem, String> inventoryRetailPrice;

    @FXML
    private TableColumn<InventoryItem, String> inventoryDate;

    @FXML
    private TableColumn<InventoryItem, String> inventoryOutletId;
  @FXML
    private TableColumn<InventoryItem, CheckBox> selectCheckBox;
    
     @FXML
    private Button addInventory;

    @FXML
    private Button updateInventory;

    @FXML
    private Button deleteInventory;

    @FXML
    private Button reloadInvenotry;

    @FXML
    private Button orderNow;
    
    public  void inventoryAttachColumn(){
            inventoryID.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().id.toString()));
            inventoryName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().name));
                inventoryDescription.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().description));
            inventoryQty.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().qty.toString()));
            inventoryPurchasingPrice.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().purchasing_price.toString()));
            inventoryRetailPrice.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().retail_price.toString()));
            inventoryDate.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().date));
            inventoryOutletId.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().outlet_id.toString()));
        selectCheckBox.setCellFactory(column -> new CheckBoxTableCell());
  selectCheckBox.setCellValueFactory(new PropertyValueFactory<>("checked"));

//        selectCheckBox.setCellFactory(new Callback<TableColumn<InventoryItem, Boolean>,
//            TableCell<InventoryItem, Boolean>>() {
//
//            public TableCell<InventoryItem, Boolean> call(TableColumn<InventoryItem, Boolean> p) {
//                return new CheckBoxTableCell<InventoryItem, Boolean>();
//            }
//        });
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
            
  System.out.println("get All");
try{
  ObservableList<InventoryItem> oblist = InventoryItem.getAll();
           for(int i = 0; i<oblist.size();i++)
           {  Checkbox ch = new Checkbox(""+i);
           }
           inventoryAttachColumn();
            inventoryTable.setItems(oblist);
            
         addInventory.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent event) {
        try {
           System.out.println("Add inventory");
          Parent root = FXMLLoader.load(getClass().getResource("InventoryForm.fxml"));
    
            Stage stage = new Stage();
            stage.setTitle("Add inventory");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
});
         updateInventory.setOnAction((ActionEvent event) -> {
            try {
           System.out.println("update inventory");
AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("InventoryForm.fxml"));          
              
                Stage stage = new Stage();
                stage.setTitle("Update inventory");
                stage.setScene(new Scene(root, 450, 450));
                stage.show();
                // Hide this current window (if this is what you want)
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
            catch (IOException e) {
                e.printStackTrace();
            }  });
        
       reloadInvenotry.setOnAction(e -> {
         System.out.println("reload");
        InventoryItem.getAll();
           inventoryAttachColumn();
           inventoryTable.setItems(oblist);
       });



    }  catch (Exception e) {
           System.err.println(e.getMessage());
        }
  
       orderNow.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent event) {
        try {
           System.out.println("Order Page");
          Parent root = FXMLLoader.load(getClass().getResource("OrderForm.fxml"));
    
            Stage stage = new Stage();
            stage.setTitle("Order Now");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
});
 
}
         
   }
