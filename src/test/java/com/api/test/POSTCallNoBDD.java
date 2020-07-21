package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTCallNoBDD {

	@Test
	public void tokenPOSTApiTest() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";

		String body = "{\r\n" + "    \"username\" : \"admin\",\r\n" + "    \"password\" : \"password123\"\r\n" + "}";

		RequestSpecification request = RestAssured.given().log().all();

		request.contentType("application/json");

		String payload = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
		request.body(payload);

		Response response = request.post("/auth");
		
		System.out.println(response.prettyPrint());
		
		System.out.println(response.getStatusCode());
		JsonPath js=response.jsonPath();
		
		String tokenId=js.get("token");
		System.out.println("token id is: "+tokenId);
	
		Assert.assertNotNull(tokenId);

		//POJO or DTO
		
	}
}
