package com.Ashish.chatApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.Ashish.chatApp.utils.configReader.getValue;
// used to connect to a database
public interface CommonDAO {
       public static Connection createConnection() throws ClassNotFoundException, SQLException {
    	    // loading a driver
    	   Class.forName(getValue("Driver"));
            
    	   //  making a connection  
    	   final String ConnectionString=getValue("ConnectionUrl");
    	   final String userid=getValue("UserID");
    	   final String password=getValue("Password");
    	   Connection con=DriverManager.getConnection(ConnectionString,userid,password);
    	   if(con!=null) {
    		   System.out.println("Connection created...");
//    		   con.close();
    	   }
    	   return con;
       }
   
}
