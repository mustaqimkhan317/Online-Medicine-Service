/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Souvik
 */
public class JavaFXApplication extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        
        FXMLDocumentController obj= new FXMLDocumentController();
        thread t1=new thread(obj);
        t1.start();
        
        PatientController obj1= new PatientController();
        thread2 t2=new thread2(obj1);
        t2.start();
        
        DoctorController obj2= new DoctorController();
        thread3 t3=new thread3(obj2);
        t3.start();
        launch(args);
        
        
    }
    
}
