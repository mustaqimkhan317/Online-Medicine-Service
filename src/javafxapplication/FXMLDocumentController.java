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
    import java.io.IOException;
    import java.net.URL;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;

    import java.util.ResourceBundle;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.fxml.Initializable;
    import javafx.scene.Node;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.control.Label;
    import javafx.scene.control.PasswordField;
    import javafx.scene.control.TextField;
    import javafx.stage.Stage;

    
    public class FXMLDocumentController implements Initializable {


        public PreparedStatement preparedStatement;
        ConnectionClass c= new ConnectionClass();
        Connection connection=c.getConnection();

        @FXML
        public Label textLabel;
        public PasswordField pb;
        public TextField textField;
        public ResultSet rs;
        public int x;
        public int y;



        @FXML

        public synchronized void handleButtonAction(ActionEvent event) throws IOException, SQLException  {


        if(textField.getText().isEmpty()||pb.getText().isEmpty())
        {
          textLabel.setText("Empty field");
        }
        else
        {
           x= Integer.parseInt(textField.getText());
           y= Integer.parseInt(pb.getText());
            if(x>99&&x<200)
         {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("patient.fxml"));
            Parent home_page_parent = (Parent) loader.load();
            PatientController patient=loader.getController();

            patient.pval(textField.getText());
            patient.treatment();
            patient.history();
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


            if (checker())
                {
                    app_stage.hide();
                    app_stage.setScene(home_page_scene);
                    app_stage.show();
                    textLabel.setText("Successful");
                }
                else
                {
                   textLabel.setText("Sorry! Invalid Credentials! "); 
                }
        }
         if(x>299&&x<400)
         {
            System.out.println("You clicked me!");
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Manag.fxml"));
            Parent home_page_parent = (Parent) loader.load();
            ManagementController manager=loader.getController();
              manager.mval(textField.getText());
              manager.mdrug();
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


            if (checker())
                {
                    app_stage.hide();
                    app_stage.setScene(home_page_scene);
                    app_stage.show(); 
                    textLabel.setText("Successful");
                }
                else
                {
                   textLabel.setText("Sorry, invalid credentials"); 
                }
        }
         if(x>199&&x<300)
         {
            System.out.println("You clicked me!");
            FXMLLoader loader=new FXMLLoader(getClass().getResource("doctor.fxml"));
            Parent home_page_parent = (Parent) loader.load();
            DoctorController doctor=loader.getController();
              doctor.dval(textField.getText());
              doctor.drug();
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


            if (checker())
                {
                    app_stage.hide();
                    app_stage.setScene(home_page_scene);
                    app_stage.show();  
                    textLabel.setText("Successful");
                }
                else
                {
                   textLabel.setText("Sorry, invalid credentials!"); 
                }

        }
        }
        }

        public void handleButtonAction2(ActionEvent event) throws Exception {

            System.out.println("You clicked me!");
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("homepage.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               if (checker())
                {
                    app_stage.hide();
                    app_stage.setScene(home_page_scene);
                    app_stage.show();  
                }
                else
                {
                    textField.clear();
                    pb.clear();
                   textLabel.setText("Sorry, invalid credentials"); 
                }
        }

           private boolean checker() throws SQLException
           {
          boolean state = false;
          int count=0;
                try
                {
             Statement st = connection.createStatement();
            String query  = "select*from accounts where id='"+textField.getText()+"'and password='"+pb.getText()+"'";
            rs = st.executeQuery(query);


                while(rs.next()){
                  count++;
                }
                }
                catch (Exception e)
                {
                 textLabel.setText("ENTER BOTH CREDENTIALS CORRECTLY"); 
                }
                if(count==1)
                {
                textLabel.setText("Login Successful");
                state = true;
                }
                if(count<1)
                {
                textLabel.setText("Wrong Username/Password");
                }
                if(count>1)
                {
                textLabel.setText("There are duplicate entries");
                }
             return state;
           }



        @Override
        public void initialize(URL url, ResourceBundle rb) {
           
        }    

        private int ParseInt(String text) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
