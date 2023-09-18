package com.Ashish.chatApp.dto;

// holds information to pass as an object to dao to perform crud on the data
public class UserDTO {
	private String userid;
	private char[] password;
     public UserDTO(String userid,char[] password){
    	  this.userid=userid;
    	  this.password=password;
      }
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
}
