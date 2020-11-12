 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diapershopms;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author muhammadammar
 */
public class OrderFormController implements Initializable {

   @FXML
    private Button checkout;

    @FXML
    private TextField customerName;

    @FXML
    private TextField orderedItem;

    @FXML
    private TextField orderedQty;

    @FXML
    private TextField orderTotal;

    @FXML
    private TextField orderDate;

    @FXML
    private TextField outletId;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
//    orderedItem.setText((itemToAdd.name).toString);
//    outletId.setText((itemToAdd.outlet_id).toString);

    }    
    
}
