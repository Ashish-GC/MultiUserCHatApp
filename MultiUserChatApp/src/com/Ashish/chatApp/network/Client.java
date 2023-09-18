package com.Ashish.chatApp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JTextArea;

import com.Ashish.chatApp.utils.configReader;


public class Client {
	Socket socket;
	clientWorker worker;
	InputStream in;
	OutputStream out;
	JTextArea textArea;
	public Client(JTextArea textArea) throws IOException {
		int port= Integer.parseInt(configReader.getValue("PORT_NO"));
	     socket = new Socket(configReader.getValue("IP"),port);  //  network ka ip address
           in=socket.getInputStream();
           out=socket.getOutputStream();
           this.textArea=textArea;
	        readMessage();
	     //	     System.out.println("Client comes");
//	      Scanner sc= new Scanner(System.in);
//	      System.out.println("Enter the message");
//	      String message=sc.nextLine();
//	      
//	       send the byte message to Network
//	      OutputStream out = socket.getOutputStream();
//	       out.write(message.getBytes());
//	       out.close();
//	       sc.close();
//	     socket.close();
	 }
	 public void  sendMessage(String message) throws IOException {
		 message=message+"\n";
		 out.write(message.getBytes());
	 }
	public void  readMessage() {
		worker = new clientWorker(in, textArea);
		 worker.start();
	}
//      public static void main(String args[]) throws IOException {
//    	  Client obj = new Client();
//      }
}
