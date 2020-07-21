package com.qa.twitter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CooksAPITest {
	String tokenId=null;
	
	@BeforeMethod
	public void setUp()
	{

		RequestSpecification request=RestAssured.given()
				.formParam("client_id", "AprilAPI")
				.formParam("client_secret", "c37dd8ce50d2a987941d756964d78d29")
				.formParam("grant_type", "client_credentials");
				
		   
		Response response =request.post("http://coop.apps.symfonycasts.com/token");
	
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
		tokenId= response.jsonPath().getString("access_token");
		
	}
	
	@Test(priority=1)
	public void feedChickenTest()
	{
		RequestSpecification request1=RestAssured.given().auth().oauth2(tokenId);
		
		   
		Response response2 =request1.post("http://coop.apps.symfonycasts.com/api/879/chickens-feed");
	
		System.out.println(response2.prettyPrint());
		
	}
	
	@Test(priority=2)
	public void eggCollectTest()
	{
		
	}
}
