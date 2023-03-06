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
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
 * @author Faisal Rahman
 */
public class ManagementController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public PreparedStatement preparedStatement;
     connectivity.ConnectionClass c= new connectivity.ConnectionClass();
     Connection connection=c.getConnection();
      
    @FXML
     public TableView tablem;
         
         public TableColumn pptid;
         public TableColumn pptname;
         public TableColumn pptc;
         public TableColumn ppts;
         public TableColumn pptprice;
         public TableColumn pptsold;
    public Label name;
    public Label sex;
    public Label age;
    public Label address;
    public Label designation;
    //public Label dspecialization;
    public Label error;
    public Label ptage;
    public Label ptsex;
    public Label ptd;
    public Label drugs;
    
    public Label perror;
    public Label prerror;
    
    //public Label error;
    
    public TextField pid;
    public TextField quantity;
    public TextField mpid;
    public TextField mpname;
    public TextField mpsex;
    public TextField mpage;
    public TextField mpad;
    public TextField mpdate;
    public TextField mpdis;
    
    public TextField mprid;
    public TextField mprname;
    public TextField mprcat;
    public TextField mprstock;
    public TextField mprprice;
    public TextField mprsold;
    
    
    
    public ResultSet rs;
    public ResultSet rs1;

    //public int x;
   // public int y;

    
    String se;
     public void mval(String text) throws SQLException
        {
            se=text;
            System.out.println(se);
            String name1=null;
            //String id1=null;
            String sex1=null; 
            String age1=null;
            String address1=null;
            String designation1=null;
            //String specialization1=null;
            Statement st = connection.createStatement();

            String query  = "select* from management WHERE officer_id = '"+se+"'";
            rs = st.executeQuery(query);


                while(rs.next()){


                     name1 = rs.getString("name");
                     System.out.println(name1);
                     sex1 = rs.getString("sex");
                     age1 = rs.getString("age");
                     address1 = rs.getString("address");
                     designation1 = rs.getString("designation");
                     //specialization1 = rs.getString("specialization");
                    




                }

          name.setText(name1);
          
          sex.setText(sex1);
          age.setText(age1);
          address.setText(address1);
          designation.setText(designation1);
         // dspecialization.setText(specialization1);

        }
    
    
    public void mdrug()
         {
              
          //System.out.println(se);

            //TableColumn doctor_id = new TableColumn("doctor_id");
            //TableColumn patient_id = new TableColumn("patient_id");
            //TableColumn product_id = new TableColumn("product_id");
            //table.getColumns().addAll(doctor_id,patient_id,product_id);
            final ObservableList<productm> data3;
            Statement st = null;
            try {
                st = connection.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(PatientController.class.getName()).log(Level.SEVERE, null, ex);
            }
             data3 = FXCollections.observableArrayList();
            String query  = "SELECT * FROM products";
            //String query  = "select* from treatment where patient_id ='101'";
            //System.out.println(se);
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
                String f;
                

            try {

                while(rs.next()){
                     a=rs.getString("product_id"); 
                               //System.out.println(a);

                     b=rs.getString("name");
                               //System.out.println(b);

                     c=rs.getString("category");
                     d=rs.getString("stock");
                     e=rs.getString("price");
                     f=rs.getString("sold");
                   data3.add(new productm(a,b,c,d,e,f));

                  pptid.setCellValueFactory(new PropertyValueFactory<productm,String>("pptid"));
                  pptname.setCellValueFactory(new PropertyValueFactory<productm,String>("pptname"));
                  pptc.setCellValueFactory(new PropertyValueFactory<productm,String>("pptc"));
                  ppts.setCellValueFactory(new PropertyValueFactory<productm,String>("ppts"));
                  pptprice.setCellValueFactory(new PropertyValueFactory<productm,String>("pptprice"));
                  pptsold.setCellValueFactory(new PropertyValueFactory<productm,String>("pptsold"));
                }   

                tablem.setItems(data3);    


            } 
            catch (SQLException ex) {
                Logger.getLogger(PatientController.class.getName()).log(Level.SEVERE, null, ex);
            }

         }
    
    public void quantityadd(ActionEvent event) throws SQLException{
         error.setText("");
         Statement st = connection.createStatement();
            int count = 0;
            //String x ="";
            String x = pid.getText();
            int stock=0;
            int f=0;
            
            System.out.println(x);
            String query2  = "select* from products where product_id = '"+pid.getText()+"'";
            rs = st.executeQuery(query2);
                while(rs.next())
                {
                    count++;
                }
                
                if(x.isEmpty()||quantity.getText().isEmpty())
                {
                    error.setText("Empty field");
               
                }
                else{
                    
                     if(count>=1)
                {
                    String query4  = "select* from products where product_id='"+pid.getText()+"'";
            rs1 = st.executeQuery(query4);

                int update=  Integer.parseInt(quantity.getText());
                while(rs1.next()){
                    stock = rs1.getInt("stock");
                    
                }
                f=stock+update;   
                String query3  = "UPDATE products SET stock = '"+f+"' WHERE product_id ='"+pid.getText()+"'";
                st.executeUpdate(query3); 
                 error.setText("Added Successfully");
                mdrug();
                }
                
                else{
                    
                    error.setText("This product is not in the list");
                }
                }
    }
    
    public void logout(ActionEvent event) throws Exception {


          
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("homepage.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    app_stage.hide();
                    app_stage.setScene(home_page_scene);
                    app_stage.show(); 
              


        }
    
    public void addpatient (ActionEvent event) throws Exception {
         perror.setText("");
        Statement st = connection.createStatement();     
        if(mpid.getText().isEmpty()||mpname.getText().isEmpty()||mpsex.getText().isEmpty()||mpage.getText().isEmpty()||mpad.getText().isEmpty()||mpdate.getText().isEmpty()||mpdis.getText().isEmpty())
        {
            perror.setText("Insert all fields properly");
        }
        else
        {
            
            try
            {
            String query1  = "INSERT INTO patient  (patient_id, name, sex,age,address,ad_date,disease) VALUES ('"+mpid.getText()+"','"+mpname.getText()+"','"+ mpsex.getText()+"','"+mpage.getText()+"','"+ mpad.getText()+"','"+ mpdate.getText()+"','"+ mpdis.getText()+"')";
            st.executeUpdate(query1);
            perror.setText("Added successfully");
            }
            catch (Exception e)
            {
            prerror.setText("Enter accordin to requirements");
            }
        }

    }
        public void addrug (ActionEvent event) throws Exception {
        prerror.setText("");
        Statement st = connection.createStatement();     
        if(mprid.getText().isEmpty()||mprname.getText().isEmpty()||mprcat.getText().isEmpty()||mprstock.getText().isEmpty()||mprprice.getText().isEmpty()||mprsold.getText().isEmpty())
        {
            prerror.setText("Insert all fields properly");
        }
        else
        {
            
            try
            {
            String query3  = "INSERT INTO products (product_id, name, category,stock,price,sold) VALUES ('"+mprid.getText()+"','"+mprname.getText()+"','"+ mprcat.getText()+"','"+mprstock.getText()+"','"+ mprprice.getText()+"','"+ mprsold.getText()+"')";
            st.executeUpdate(query3);
            prerror.setText("Added successfully");
            }
            catch (Exception e)
            {
            prerror.setText("Enter accordin to requirements");
            }
        }

        }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }    
    
}
