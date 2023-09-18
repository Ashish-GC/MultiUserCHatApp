package com.Ashish.chatApp.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Ashish.chatApp.dto.UserDTO;
import com.Ashish.chatApp.utils.Encryption;

public class UserDAO {
//  function to perform read in database using prepared statement class
	public boolean isLogin(UserDTO userdto) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String SQL ="select userid from users where userid=? and password=?";
		try {
			con=CommonDAO.createConnection();
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1,userdto.getUserid());
			String encrypt=Encryption.passwordEncrypt(new String(userdto.getPassword()));
			pstmt.setString(2,encrypt);
			
//			query execute
			rs=pstmt.executeQuery();
			return rs.next();
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
	}
	
// function to perform write in database  using Statement class
        public int add(UserDTO userdto) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
//        	 System.out.println(userdto.getPassword()+" "+userdto.getUserid());
        	 
        	   Connection connection=null; // creating a connection to database
        	   Statement stmt=null; //query
        	  try { 
        	  connection= CommonDAO.createConnection();
        	   stmt= connection.createStatement();
        	     // to perform crud operation in sql we use execute Update
        		int records=stmt.executeUpdate("insert into users (userid, password) values('"+userdto.getUserid()+"','"+Encryption.passwordEncrypt(new String(userdto.getPassword()))+"')");
        		return records;
        	  }
        	  finally {
        		  if(stmt!=null) {
        			  stmt.close();
        		  }
        		  if(connection!=null) {
        			  connection.close();
        		  }
        	  }
        		
        }
        

        
}
