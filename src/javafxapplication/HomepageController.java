/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomepageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    public void handleButtonAction(ActionEvent event) throws Exception {


           
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    app_stage.hide();
                    app_stage.setScene(home_page_scene);
                    app_stage.show(); 
                //    System.out.println(h);


        }
    
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
