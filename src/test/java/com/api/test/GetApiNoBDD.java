package com.api.test;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class GetApiNoBDD {
	
	@Test(priority=2,enabled=true)
	public void getUserApiWithParamTest()
	{
		RestAssured.baseURI="https://gorest.co.in";
		
		RequestSpecification request=RestAssured.given().log().all();
		request.header("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		request.queryParam("first_name", "Quinton");
		request.queryParam("gender", "male");
		request.queryParam("status", "active");
		
		Response response=request.get("/public-api/users");
		
		System.out.println(response.prettyPrint());
		
	int statusCode=response.getStatusCode();
	Assert.assertEquals(statusCode, 200);
	System.out.println(response.getStatusCode());
System.out.println(response.contentType());
	String serverName=response.getHeader("Server");
	Assert.assertEquals(serverName, "nginx");
	}
	
	@Test(priority=1,enabled=false)
	public void getUserApi()
	{
		RestAssured.baseURI="https://gorest.co.in";
		
		RequestSpecification request=RestAssured.given().log().all();
		request.header("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		
		Response response=request.get("/public-api/users");
		
		System.out.println(response.prettyPrint());
		
	int statusCode=response.getStatusCode();
	Assert.assertEquals(statusCode, 200);
	System.out.println(response.getStatusCode());
System.out.println(response.contentType());
	String serverName=response.getHeader("Server");
	Assert.assertEquals(serverName, "nginx");
	}	

}
