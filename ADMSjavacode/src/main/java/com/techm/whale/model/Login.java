package com.techm.whale.model;



/* 
 * The Login class is POJO class used to create the getter and setter methods for fields 
 * username and password. 
 * 
 * */
public class Login {
	
	/*  The username variable to store username*/
	String username;
	
	/* the password variable to store password*/
	String password;
	
	
	/*Getter method for username*/
	public String getUsername() {
		return username;
	}
	
	/*Setter method for username*/
	public void setUsername(String username) {
		this.username = username;
	}
	
	/*Getter method for password*/
	public String getPassword() {
		return password;
	}
	
	
	/*Setter method for password*/
	public void setPassword(String password) {
		this.password = password;
	}
}
