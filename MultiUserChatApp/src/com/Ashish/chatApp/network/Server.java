package com.Ashish.chatApp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.Ashish.chatApp.utils.configReader;

public class Server {
	ServerSocket serversocket;
	ArrayList<ServerWorker> workers = new ArrayList<>();
	
	public Server() throws IOException {
		int port= Integer.parseInt(configReader.getValue("PORT_NO"));
  		 serversocket=new ServerSocket(port);
  		 System.out.println("Server start and waiting for clients to join");
  		 handleClientRequest();
  		 
	}
//	mutliple client handshaking
	 public void handleClientRequest() throws IOException {
		    while(true) {
		    	 Socket clientSocket=serversocket.accept();  // accepts clients request

		  		 // per client per thread
		  		 ServerWorker serverworker = new ServerWorker(clientSocket,this);
		  		 workers.add(serverworker);
		  		
		  		 serverworker.start();
		    }
	 }
	
//	 can handle only one client
    /*   public Server() throws IOException {
    	int port= Integer.parseInt(configReader.getValue("PORT_NO"));
   		 serversocket=new ServerSocket(port);
   		 System.out.println("server waiting for client");
   		 
   		 Socket socket= serversocket.accept();
   		System.out.println("Client joins the server");
   		
   		InputStream in = socket.getInputStream();
   		 byte[] arr= in.readAllBytes();
   		System.out.println("message : "+new String(arr));
   		 socket.close();
       }
       */
       public static void main(String args[]) throws IOException {
     	  Server obj = new Server();
       }
}
