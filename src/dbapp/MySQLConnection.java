package dbapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;


// Notice, do not import com.mysql.jdbc.*
// or you will have problems!

public class MySQLConnection {
	Connection conn = null;
	
    public Connection getConnection()
    {
    	Connection conn=null;
        try 
        {
        	
        	String url = "jdbc:mysql://localhost:3306/";
  		  	String dbName = "mydb";
  		  	String userName = "root"; 
  		  	String password = "Adarsh_1234";
  		  	Class.forName("com.mysql.jdbc.Driver").newInstance();
  		  	conn = DriverManager.getConnection(url+dbName,userName,password);
        	
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
		return conn;
    }
    
    
    
    public static void main(String[] args)
    {
    	MySQLConnection con1=new MySQLConnection();
    	con1.getConnection();
    }
    
    
}