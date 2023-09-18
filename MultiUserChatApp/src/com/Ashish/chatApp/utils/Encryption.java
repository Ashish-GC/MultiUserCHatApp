package com.Ashish.chatApp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Encryption {
     public static String passwordEncrypt(String password) throws NoSuchAlgorithmException{
    	   String generatePassword=null;
    	   
    	   MessageDigest md= MessageDigest.getInstance("MD5");
    	   md.update(password.getBytes());
    	   byte[] encrypt = md.digest();
    	   
    	   StringBuffer sb = new StringBuffer();
    	   for(int i=0;i<encrypt.length;i++) {
    		   sb.append(encrypt[i]);
    	   }
    	    generatePassword=sb.toString();
    	    
    	   return generatePassword;
     }
}
