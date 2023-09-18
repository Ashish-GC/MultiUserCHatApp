package com.Ashish.chatApp.network;

//once job is created via runnable , write the job logic inside the run function
public class examplethread implements Runnable{
	@Override
	public void run() {  // logic of job to be performed
		for(int i=0;i<10;i++) {
  		  System.out.println("worker "+i+" "+Thread.currentThread());
  	  }
	 }
     public static void main(String args[]) { // main thread
    	 examplethread  job= new examplethread ();
//    	  assign the job to a thread
    	  Thread worker = new Thread(job,"worker1");
    	  worker.start(); // internally it calls run
    	  
    	  for(int i=0;i<10;i++) {
    		  System.out.println("main "+i+" "+Thread.currentThread());
    	  }
     } 
}

// another method to build thread =>   // used when it is not extends any other class
// class sw extends Thread{
//	 @Override
//	 public void run() {}
//	  public static void main(String args[]) { 
//		  sw worker= new sw();
//		  worker.start();
//	  }
// }