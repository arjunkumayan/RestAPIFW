package com.api.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTCallWithoutBDD {
	
	@Test
	public void createNewUserAPI()
	{
		
		RestAssured.baseURI="https://gorest.co.in/public-api";
		
		RequestSpecification request=RestAssured.given().log().all();
		
		request.header("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		
		String payload=" {\r\n" + 
				"            \"first_name\": \"pta\",\r\n" + 
				"            \"last_name\": \"wwwtw\",\r\n" + 
				"            \"gender\": \"male\",\r\n" + 
				"            \"dob\": \"1980-11-24\",\r\n" + 
				"            \"email\": \"guswwspta.dfde@exampl1dd2e.org\",\r\n" + 
				"            \"phone\": \"4231234678\"\r\n" + 
				"	\r\n" + 
				"}";
		
		String p="{\"first_name\": \"Happy\",\"last_name\": \"singhj\",\"gender\": \"male\",\"dob\": \"1980-1-24\",\"email\": \"arjun@rtf.com\",\"phone\": \"4567890981\" }";
		
		request.body(payload);
		Response response=request.post("/users");
		System.out.println(response.asString());
		
	
	}

}
