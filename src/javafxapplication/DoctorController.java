/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import connectivity.ConnectionClass;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * 
 */
public class DoctorController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     public PreparedStatement preparedStatement;
     ConnectionClass c= new ConnectionClass();
     Connection connection=c.getConnection();
      
    @FXML
    public TableView table1;
         
    public TableColumn pptid;
    public TableColumn pptname;
    public TableColumn pptc;
    public TableColumn ppts;
    public TableColumn pptprice;
    public Label dname;
    public Label dsex;
    public Label dage;
    public Label daddress;
    public Label ddegree;
    public Label dspecialization;
    public Label ptname;
    public Label ptage;
    public Label ptsex;
    public Label ptd;
    public Label drugs;
    public Label error;
    
    public TextField ptid;
    public TextField dose;
    public TextField ptproduct;
    public ResultSet rs;
    public int x;
    public int y;

    
    String se;
     public void dval(String text) throws SQLException
        {
            se=text;
            System.out.println(se);
            String name1=null;
            String sex1=null; 
            String age1=null;
            String address1=null;
            String degree1=null;
            String specialization1=null;
            Statement st = connection.createStatement();

            String query  = "select* from doctor WHERE doctor_id = '"+se+"'";
            rs = st.executeQuery(query);


                while(rs.next()){
                    
                     name1 = rs.getString("name");
                     System.out.println(name1);
                     sex1 = rs.getString("sex");
                     age1 = rs.getString("age");
                     address1 = rs.getString("address");
                     degree1 = rs.getString("degree");
                     specialization1 = rs.getString("specialization");
                }

          dname.setText(name1);
          
          dsex.setText(sex1);
          dage.setText(age1);
          daddress.setText(address1);
          ddegree.setText(degree1);
          dspecialization.setText(specialization1);

        }
    
     
     
         public void ptdtls(ActionEvent event) throws Exception {
        
            
            String name1=null;
            String id1=null;
            String sex1=null; 
            String age1=null;
            String address1=null;
            String diseases1=null;
            Statement st = connection.createStatement();

            String query  = "select* from patient where patient_id = '"+ptid.getText()+"'";
            rs = st.executeQuery(query);


                while(rs.next()){


                     name1 = rs.getString("name");
                     sex1 = rs.getString("sex");
                     age1 = rs.getString("age");
                     diseases1 = rs.getString("disease");




                }

          ptname.setText(" Name : "+name1);
          
          ptsex.setText("SEX : "+sex1);
          ptage.setText("AGE : "+age1);
         
          ptd.setText("Diseases : "+diseases1);
          mhistory();

        }
     
         public void mhistory() throws SQLException
         {
         String name = "";
         Statement st = connection.createStatement();

            String query1  ="SELECT products.name FROM treatment INNER JOIN products ON treatment.product_id = products.product_id WHERE patient_id = '"+ptid.getText()+"'";
            rs = st.executeQuery(query1);
             while(rs.next()){
                 
                 String name1 = rs.getString("products.name");
                 System.out.println(name1);
                 name=name+" , "+name1;
                }
             drugs.setText("Prescribed drugs : "+ name);
            
         }
         
         public synchronized void addrugs()  
         {
          
          if(ptid.getText().isEmpty()||ptproduct.getText().isEmpty()||dose.getText().isEmpty())
          {
              error.setText("Empty fields");
          }
          else
          {
               try
            {
          Statement st = connection.createStatement();   
          String query2="INSERT INTO treatment  (doctor_id, patient_id, product_id, dose) VALUES ('"+se+"','"+ptid.getText()+"','"+ ptproduct.getText()+"','"+dose.getText()+"')";
           
            st.executeUpdate(query2);
                error.setText("ADDED");
            }
            catch(Exception e)
            {
             error.setText("INVALID VALUE");
            }
          } 
         
         
         
         }
         
         public synchronized void drug()
         {
              
          System.out.println(se);

            final ObservableList<product> data3;
            Statement st = null;
            try {
                st = connection.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(PatientController.class.getName()).log(Level.SEVERE, null, ex);
            }
            data3 = FXCollections.observableArrayList();
            String query  = "SELECT * FROM products";
            System.out.println(se);
            try {
                rs = st.executeQuery(query);
            } catch (SQLException ex) {
                Logger.getLogger(PatientController.class.getName()).log(Level.SEVERE, null, ex);
            }

                String a; 
                String b;
                String c;
                String d;
                String e;
                

            try {

                while(rs.next()){
                     a=rs.getString("product_id"); 
                               System.out.println(a);

                     b=rs.getString("name");
                               System.out.println(b);

                     c=rs.getString("category");
                     d=rs.getString("stock");
                     e=rs.getString("price");
                  
                   data3.add(new product(a,b,c,d,e));

                  pptid.setCellValueFactory(new PropertyValueFactory<product,String>("pptid"));
                  pptname.setCellValueFactory(new PropertyValueFactory<product,String>("pptname"));
                  pptc.setCellValueFactory(new PropertyValueFactory<product,String>("pptc"));
                  ppts.setCellValueFactory(new PropertyValueFactory<product,String>("ppts"));
                  pptprice.setCellValueFactory(new PropertyValueFactory<product,String>("pptprice"));
                }   

                table1.setItems(data3);    


            } 
            catch (SQLException ex) {
                Logger.getLogger(PatientController.class.getName()).log(Level.SEVERE, null, ex);
            }

         }
         public void handleButtonAction1(ActionEvent event) throws Exception {


          
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("homepage.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    app_stage.hide();
                    app_stage.setScene(home_page_scene);
                    app_stage.show(); 
              


        }
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
