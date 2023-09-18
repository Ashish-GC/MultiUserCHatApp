package com.Ashish.chatApp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerWorker extends Thread{
	Socket clientSocket;
	InputStream in;
	OutputStream out;
    Server server;
       public ServerWorker(Socket clientSocket,Server server) throws IOException {
    	   this.clientSocket=clientSocket;
    	   in=clientSocket.getInputStream();
    	   out=clientSocket.getOutputStream();
    	   this.server=server;
    	   System.out.println("new client comes");
	}

	@Override
       public void run() {
//    	   read data from client and broad cast the data to all
//		  it reads the data line by line
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line;
		
		try {
		while(true) {
		     
				line=br.readLine();
				if(line.equalsIgnoreCase("quit")) {
					break;
				}
//				out.write(line.getBytes());
//				broadcast to all clients
				for(ServerWorker serverworker : server.workers ) {
					 line=line+"\n";
					serverworker.out.write(line.getBytes());
				}  
			  
		   }
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	     finally {
	    	 
	    		 try {
	    			 if(br!=null) {
					br.close();}
	    			 
	    			 if(in!=null) {
	    				 in.close();
	    			 }
	    			 if(out!=null) {
	    				 out.close();
	    			 }
	    			 if(clientSocket!=null) {
	    				 clientSocket.close();
	    			 }
	    			 
				} catch (IOException e) {
					e.printStackTrace();
				}
	    	 
	          }
       }
}
