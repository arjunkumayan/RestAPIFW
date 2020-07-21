package com.api.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class GETCallApi {
	
	// Rest Assured BDD approach
	// API -06
	@Test(priority=1, enabled=false)
	public void getUsers1Api()
	{
	
		RestAssured.baseURI="https://gorest.co.in/";
		
		given().log().all()
		        .contentType("application/json")
		        .header("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif")
		 .when()
		        .get("public-api/users")
		        
		.then().log().all()
		       .statusCode(200)
		       .and()
		       .header("server", "nginx")
		       .header("X-Rate-Limit-Limit", "30");
		  
		        
		
		
	}

	
	@Test(priority=2,enabled=false)
	public void getUserWithSpecificApi()
	{
	
		RestAssured.baseURI="https://gorest.co.in/";

		given().log().all()
		        .contentType("application/json")
		        .header("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif")
		 .when()
		        .get("public-api/users?first_name=Lisette")
		        
		.then().log().all()
		       .statusCode(200)
		       .and()
		       .header("server", "nginx")
		       .header("X-Rate-Limit-Limit", "30");
		  
		        
		
		
	}

	// Query parameter= question mark and is used to filter the data
	@Test(priority=3)
	public void getUserWithOneQueryParameterApi()
	{
	
		RestAssured.baseURI="https://gorest.co.in/";

		given().log().all()
		        .contentType("application/json")
		        .header("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif")
		        .queryParam("gender", "male")
		 .when()
		        .get("public-api/users")
		        
		.then().log().all()
		       .statusCode(200)
		       .and()
		       .header("server", "nginx")
		       .header("X-Rate-Limit-Limit", "30");
				
	}

}
