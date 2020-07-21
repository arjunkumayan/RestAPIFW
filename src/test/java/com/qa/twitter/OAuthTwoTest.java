package com.qa.twitter;

import org.jsoup.Connection.Request;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OAuthTwoTest {
	
	@Test(enabled=false)
	public void checkOAuth2Test()
	{
		
		RequestSpecification request=RestAssured.given().auth().oauth2("40336a00bd89764ac71526716131caa3e6f514ec");
		
   
		Response response =request.post("http://coop.apps.symfonycasts.com/api/879/chickens-feed");
	
		System.out.println(response.prettyPrint());
	
	}
	
	@Test
	public void getOAuth2Test()
	{
		
		RequestSpecification request=RestAssured.given()
				.formParam("client_id", "AprilAPI")
				.formParam("client_secret", "c37dd8ce50d2a987941d756964d78d29")
				.formParam("grant_type", "client_credentials");
				
		   
		Response response =request.post("http://coop.apps.symfonycasts.com/token");
	
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
		String tokenId= response.jsonPath().getString("access_token");
	

		RequestSpecification request1=RestAssured.given().auth().oauth2(tokenId);
		
   
		Response response2 =request1.post("http://coop.apps.symfonycasts.com/api/879/chickens-feed");
	
		System.out.println(response2.prettyPrint());
	}

}
