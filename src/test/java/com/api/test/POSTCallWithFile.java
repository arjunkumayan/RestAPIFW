package com.api.test;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTCallWithFile {
	
	@Test
	public void getTokenPOSTApiWithFileTest()
	{
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		RequestSpecification request = RestAssured.given().log().all();

		request.contentType("application/json");

		
		File file=new File("D:\\Users\\asingh6766\\eclipse-workspace\\RestAssuredProject\\src\\test\\java\\com\\api\\test\\Credentials.json");
		
		request.body(file);
		
		Response response=request.post("/auth");
		System.out.println(response.prettyPrint());
		
		
		
	}
	
	@Test
	public void getTokenPOSTApiWithInvalidJsonFileTest()
	{
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		RequestSpecification request = RestAssured.given().log().all();

		request.contentType("application/json");

		
		File file=new File("D:\\Users\\asingh6766\\eclipse-workspace\\RestAssuredProject\\src\\test\\java\\com\\api\\test\\InvalidCred.json");
		
		request.body(file);
		
		Response response=request.post("/auth");
		System.out.println(response.prettyPrint());
		
		
		
	}

}
