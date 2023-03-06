    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package connectivity;

    /**
     *
     * @author Souvik
     */
    import java.sql.Connection;
    import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnectionClass  {
    
    public Connection connection;
    public  Connection getConnection(){


        String dbName="treatment";
        String userName="root";
        String password="";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,userName,password);


        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;
    }

    

    
}