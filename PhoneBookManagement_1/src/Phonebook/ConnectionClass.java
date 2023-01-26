
package Phonebook;
import java.awt.*;
import java.sql.*;
public class ConnectionClass {
    Connection con;
    Statement stm;
    ConnectionClass()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///mysql","root","root");
            stm = con.createStatement();
                    
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void main(String ar[])
    {
        new ConnectionClass();
    }
}
