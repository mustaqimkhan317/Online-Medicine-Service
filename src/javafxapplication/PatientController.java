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
     * @author Souvik
     */


    public class PatientController implements Initializable  {
        public PreparedStatement preparedStatement;
         ConnectionClass c= new ConnectionClass();
         Connection connection=c.getConnection();

        /**
         * Initializes the controller class.
         */

         public Label name;
         public Label id;
         public Label sex;
         public Label age;
         public Label diseases;
         public Label address;
         public ResultSet rs;
         public ResultSet rs1;
         public ResultSet rs2;
         
         public TableView table;
         public TableView tableh;
         public TableColumn doctor_id;
         public TableColumn doctor_name;
         public TableColumn patient_name;
         public TableColumn product_id;
         public TableColumn product_name;
         public TableColumn dose;
         public TableColumn stock;
         
         public TableColumn hpname;
         public TableColumn hpID;
         public TableColumn hamount;
         public TableColumn hprice;
        
         public TextField purchaseID;
         public TextField productQ;
         public Label showpurchase;
         public Label showbill;






        public String se;
        public void pval(String text) throws SQLException
        {
            se=text;
            String name1=null;
            String id1=null;
            String sex1=null; 
            String age1=null;
            String address1=null;
            String diseases1=null;
            Statement st = connection.createStatement();

            String query  = "select* from patient where patient_id = '"+se+"'";
            rs = st.executeQuery(query);


                while(rs.next()){


                     name1 = rs.getString("name");
                     id1 = rs.getString("patient_id");
                     sex1 = rs.getString("sex");
                     age1 = rs.getString("age");
                     address1 = rs.getString("address");
                     diseases1 = rs.getString("disease");




                }

          name.setText(name1);
          id.setText(id1);
          sex.setText(sex1);
          age.setText(age1);
          address.setText(address1);
          diseases.setText(diseases1);

        }
         public void handleButtonAction1(ActionEvent event) throws Exception {


           System.out.println(se);
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("homepage.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    app_stage.hide();
                    app_stage.setScene(home_page_scene);
                    app_stage.show(); 
        }

          public synchronized void pdetails(ActionEvent event) throws Exception {
            showpurchase.setText("");
            int count = 0;
            int stock=0;
            int sold = 0;
            int update =0;
            int price=0;
            try
            {
            int pid=  Integer.parseInt(purchaseID.getText());
            int quantity=  Integer.parseInt(productQ.getText());
            System.out.println(pid);
            Statement st = connection.createStatement();

            String query1  = "select* from treatment where product_id='"+pid+"' AND patient_id = '"+se+"'";
            rs = st.executeQuery(query1);


                while(rs.next()){
                    count++;
                }
                System.out.println(count);
                String query2  = "select* from products where product_id='"+pid+"'";
                rs1 = st.executeQuery(query2);


                while(rs1.next()){
                    stock = rs1.getInt("stock");
                    sold=rs1.getInt("sold");
                    price=rs1.getInt("price");
                }
                  System.out.println(stock);
                  if(count>=1)
                {
                if(stock>=quantity)
                {
                
                update=stock-quantity;
                sold=sold+quantity;
                int pnew=price*quantity;
                
                String query3  = "UPDATE products SET stock = '"+update+"',sold= '"+sold+"' WHERE product_id ='"+pid+"'";
                st.executeUpdate(query3);
                String query4="INSERT INTO history  (patient_id, product_id, amount, money) VALUES ('"+se+"','"+pid+"','"+quantity+"','"+pnew+"')";
                st.executeUpdate(query4);
                showpurchase.setText("Successful");
                showbill.setText("Your bill is :  "+pnew + " BDT");
                history();
                 
                }
                else
                {
                showpurchase.setText("Out of stock");
                }
                }
                else
                {
                showpurchase.setText("Its not in your list");
                }
            }
            catch (Exception e)
            {
             showpurchase.setText("ENTER All FIELDS CORRECTLY");
            }
        }

          public void treatment()
          {
          System.out.println(se);

            //TableColumn doctor_id = new TableColumn("doctor_id");
            //TableColumn patient_id = new TableColumn("patient_id");
            //TableColumn product_id = new TableColumn("product_id");
            //table.getColumns().addAll(doctor_id,patient_id,product_id);
            final ObservableList<person> data;
            Statement st = null;
            try {
                st = connection.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(PatientController.class.getName()).log(Level.SEVERE, null, ex);
            }
             data = FXCollections.observableArrayList();
            String query  = "SELECT treatment.doctor_id,treatment.product_id,treatment.dose,doctor.name,products.name,products.price FROM treatment INNER JOIN doctor ON doctor.doctor_id = treatment.doctor_id INNER JOIN products ON treatment.product_id = products.product_id WHERE patient_id = '"+se+"'";
            //String query  = "select* from treatment where patient_id ='101'";
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
                String f;


            try {

                while(rs.next()){
                     a=rs.getString("doctor_id");                 
                     b=rs.getString("doctor.name");
                     c=rs.getString("product_id");
                     d=rs.getString("products.name");
                     e=rs.getString("dose");
                     f=rs.getString("price");
                     
                     System.out.println(e);

                    data.add(new person(a,b,c,d,e,f));
                    
                    doctor_id.setCellValueFactory(new PropertyValueFactory<person,String>("doctor_id"));
                    doctor_name.setCellValueFactory(new PropertyValueFactory<person,String>("doctor_name"));
                    product_id.setCellValueFactory(new PropertyValueFactory<person,String>("product_id"));
                    product_name.setCellValueFactory(new PropertyValueFactory<person,String>("product_name"));
                    dose.setCellValueFactory(new PropertyValueFactory<person,String>("dose"));
                    stock.setCellValueFactory(new PropertyValueFactory<person,String>("stock"));
                }   

                table.setItems(data);    


            } 
            catch (SQLException ex) {
                Logger.getLogger(PatientController.class.getName()).log(Level.SEVERE, null, ex);
            }

          }
          
          public void history()
          {
         System.out.println(se);

            final ObservableList<h> data1;
            Statement st = null;
            try {
                st = connection.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(PatientController.class.getName()).log(Level.SEVERE, null, ex);
            }
             data1 = FXCollections.observableArrayList();
            String query  = "SELECT history.patient_id,history.product_id,history.amount,history.money,products.name FROM history INNER JOIN products ON products.product_id = history.product_id WHERE patient_id = '"+se+"'";
            //String query  = "select* from treatment where patient_id ='101'";
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

            try {

                while(rs.next()){
                     a=rs.getString("products.name"); 
                     System.out.println(a);
                     b=rs.getString("product_id");
                     System.out.println(b);
                     c=rs.getString("amount");
                     System.out.println(c);
                     d=rs.getString("money");
                     System.out.println(d);
                     //e=rs.getString("patient_name");

                   data1.add(new h(a,b,c,d));
               



                    hpname.setCellValueFactory(new PropertyValueFactory<h,String>("hpname"));
                    hpID.setCellValueFactory(new PropertyValueFactory<h,String>("hpID"));
                    hamount.setCellValueFactory(new PropertyValueFactory<h,String>("hamount"));
                    hprice.setCellValueFactory(new PropertyValueFactory<h,String>("hprice"));
                }   

                tableh.setItems(data1);    


            } 
            catch (SQLException ex) {
                Logger.getLogger(PatientController.class.getName()).log(Level.SEVERE, null, ex);
            }

          }
          
          
          
        @Override
        public void initialize(URL url, ResourceBundle rb) {

        }    

    }
