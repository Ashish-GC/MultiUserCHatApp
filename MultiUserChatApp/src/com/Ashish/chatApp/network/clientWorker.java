package com.Ashish.chatApp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JTextArea;

public class clientWorker extends Thread{
	private InputStream in;
	private JTextArea textArea;
	clientWorker(InputStream in , JTextArea textArea){
		 this.in=in;
		 this.textArea=textArea;
	}
	
	@Override
	public void run() {
//		to read client data
		
			BufferedReader br = new BufferedReader(new InputStreamReader (in));
			    String line;
			    try {
			    while(true) {
			    	line=br.readLine();
			    	 System.out.println("line Read :"+ line);
			    	textArea.setText(textArea.getText()+line+"\n");
		                  }
			    }
			    catch(Exception e) {
			      e.printStackTrace();
			    }
			    finally {
			    	if(in!=null) {
			    		try {
							in.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
			    	}
			    }
	}
       
}