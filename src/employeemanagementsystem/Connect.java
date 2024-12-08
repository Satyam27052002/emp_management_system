package employeemanagementsystem;

import java.sql.*;
import com.mysql.cj.jdbc.Driver;


public class Connect 
{
    Connection con;
    Statement st;
    public Connect()
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
            st=con.createStatement();
        }
        catch(SQLException|ClassNotFoundException se)
        {
            se.printStackTrace();
        }
    }
}
