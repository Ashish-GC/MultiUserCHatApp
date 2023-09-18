package com.Ashish.chatApp.utils;

import java.util.ResourceBundle;

public class configReader {
          private static ResourceBundle rb = ResourceBundle.getBundle("config");
          public static String getValue(String Key) {
        	  return rb.getString(Key);
          }
          
}
