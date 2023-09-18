package com.Ashish.chatApp.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Ashish.chatApp.network.Client;
import com.Ashish.chatApp.utils.UserInfo;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class clientChatScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
    private JTextArea textArea ;
    private Client client ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					try {
						clientChatScreen frame = new clientChatScreen();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
		
	}
	
	private void sendIt() {
		String message = textField.getText();
		try {
			client.sendMessage(UserInfo.UserName+"-"+message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public clientChatScreen() throws IOException {
		textArea = new JTextArea();
		client= new Client(textArea);
		setTitle("Chat");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 790, 340);
		contentPane.add(scrollPane);
		
		
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setBounds(21, 23, 764, 293);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(22, 380, 602, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton sendit = new JButton("Send Message");
		sendit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendIt();
			}
		});
		
		sendit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sendit.setBounds(655, 380, 145, 39);
		contentPane.add(sendit);
		
		setVisible(true);
	}
}
