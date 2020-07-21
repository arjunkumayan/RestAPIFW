package com.api.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetUserAPISchemaTest {
	
	
	@Test
	public void getUserSchemaTest()
	{
		
		
		RestAssured.baseURI="https://gorest.co.in/public-api/users";
		
		RestAssured.given().log().all()
				
		           .contentType("application/json")
				
		           .header("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif")
				
				
		.when().log().all()
				
		          .get("/442")
				
				
		.then().log().all()
				
		.assertThat()
			
		.body(matchesJsonSchemaInClasspath("userschema.json"));
		
		
		
	}

}
