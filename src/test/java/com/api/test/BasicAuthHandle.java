package com.api.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAuthHandle {
	
	
	
	@Test
	public void basicAuthRestAssuredTest()
	{
		
		RestAssured.baseURI="http://the-internet.herokuapp.com";
		
		RequestSpecification request = RestAssured.given().log().all();
		
		request.auth().basic("admin","admin");
		Response response=request.get("/basic_auth");
		
		System.out.println(response.prettyPrint());
		
		
		
	}

}
