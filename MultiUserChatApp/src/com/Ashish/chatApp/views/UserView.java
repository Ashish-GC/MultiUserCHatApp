package com.Ashish.chatApp.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserView extends JFrame {
	int counter=0;
	 public UserView() {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setSize(500,500);//width,height
		 setResizable(false);
		 setTitle("Login");
		 setLocationRelativeTo(null); //center 
//		 setLocation(x,y);
		 
		 JLabel label = new JLabel("Login");
	     label.setFont(new Font("Arial",Font.BOLD,30));
		 
	     Container container = this.getContentPane();
	     container.setLayout(null);
	     label.setBounds(100,50,100,100);
	     
	     JButton button = new JButton("click");
	     button.addActionListener(new ActionListener() {
	    	
			@Override
			public void actionPerformed(ActionEvent e) {
				counter++;
				label.setText("count"+counter);
				
			}
	     } );
	     
	     button.setBounds(100,250,100, 50);
	     container.add(button);
	     container.add(label);
		 
		 setVisible(true);
	 }
    public static void main(String args[]) {
    	UserView obj = new UserView();
    }
}
