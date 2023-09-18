package com.Ashish.chatApp.views;


import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.Ashish.chatApp.dao.UserDAO;
import com.Ashish.chatApp.dto.UserDTO;
import com.Ashish.chatApp.utils.UserInfo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class UserScreen extends JFrame {
	private JTextField useridtxt;
	private JPasswordField passwordField;
	UserDAO userdao = new UserDAO();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					UserScreen window = new UserScreen();				
	}
	
//	login
	public void doLogin() {
		String userid= useridtxt.getText();
    	char[] password=passwordField.getPassword();
    	
    	  
          UserDTO userdto = new UserDTO(userid,password);
          try {
        	  String message="";
			if(userdao.isLogin(userdto)) {
				message="Welcome"+ userid;
				UserInfo.UserName=userid;
				JOptionPane.showMessageDialog(this, message);
				setVisible(false);
				dispose();
				
				DashBoard dash = new DashBoard();
				dash.setVisible(true);
				dash.setTitle(message);
			}
			else {
				message="Wrong Userid or Password";
				JOptionPane.showMessageDialog(this, message);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
 // register
     public void register() {
    	String userid= useridtxt.getText();
    	char[] password=passwordField.getPassword();
       
         UserDTO userdto = new UserDTO(userid,password);
         try{
        	 int records=userdao.add(userdto);
        	 if(records>0) {
        		 JOptionPane.showMessageDialog(this,"Record Added");
        	 }
        	 else {
        		 JOptionPane.showMessageDialog(this,"Record Not Added");
        		 
        	 }
         }
         catch(ClassNotFoundException| SQLException e) {
        	 System.out.println("DB Issue....");
        	 e.printStackTrace();
         }
         catch(Exception e) {
        	 System.out.println("Unknown Exception....");
        	 e.printStackTrace();
         }
         
     }
	
	public UserScreen() {
		setTitle("Login");
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(283, 61, 88, 43);
		getContentPane().add(lblNewLabel);
		
		useridtxt = new JTextField();
		useridtxt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		useridtxt.setBounds(259, 155, 259, 31);
		getContentPane().add(useridtxt);
		useridtxt.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		passwordField.setBounds(259, 217, 259, 31);
		getContentPane().add(passwordField);
			
		JLabel useridlbl1 = new JLabel("Userid");
		useridlbl1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		useridlbl1.setBounds(132, 155, 80, 31);
		getContentPane().add(useridlbl1);
		
		JLabel Pwdlbl = new JLabel("Password");
		Pwdlbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Pwdlbl.setBounds(132, 217, 88, 31);
		getContentPane().add(Pwdlbl);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		loginbtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		loginbtn.setBounds(197, 309, 107, 43);
		getContentPane().add(loginbtn);
		
		JButton Registerbtn = new JButton("Register");
		Registerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				      register();
			}
		});
		Registerbtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Registerbtn.setBounds(371, 309, 120, 43);
		getContentPane().add(Registerbtn);
		
	
		setSize( 666, 464);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}
