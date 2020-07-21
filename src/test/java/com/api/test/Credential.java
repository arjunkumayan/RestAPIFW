package com.api.test;

public class Credential {
	// POJO- Plain old java object
	
	String username;
	String password;
	
	public Credential(String username,String password)
	{
		 	this.username=username;
		 	this.password=password;
		
	}
	//getter and setter

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
