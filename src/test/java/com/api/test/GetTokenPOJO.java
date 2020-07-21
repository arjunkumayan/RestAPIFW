package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetTokenPOJO {

	
	@Test
	public void tokenPOSTApiTest() 
	{
		
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		
		RequestSpecification request=RestAssured.given().log().all();
		
		request.contentType("application/json");
		
		Credential cred=new Credential("admin","password123");
		
		Credential cred1=new Credential("naveen","test123");
		
		Credential cred2=new Credential("arjun","mango123");
		
		// POJO to json
		// Jackson-databind
		
		
		String credJson=null;
		String credJson1=null;
		String credJson2=null;
		
		ObjectMapper mapper=new ObjectMapper();
		
		try {
			credJson=mapper.writeValueAsString(cred);
			credJson1=mapper.writeValueAsString(credJson1);
			credJson2=mapper.writeValueAsString(credJson2);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println("Credentials json payload"+credJson);
		
		/*
		 * { "username","admin", "password":"password123"
		 * 
		 * }
		 */
		
		//Hit the post api
		request.body(credJson);
		
		Response response=request.post("/auth");
		
		System.out.println(response.prettyPrint());
		System.out.println(response.statusCode());
		
		
	JsonPath json=response.jsonPath();
	String tokenId=json.get("token");
	System.out.println("token is: "+tokenId);
	
	Assert.assertNotNull(tokenId);
	Assert.assertEquals(response.statusCode(),HTTPStatus.HTTP_Status_code_200);
	
	}
	
	@Test
	public void tokenAPIWithWrongCredentialTest()
	{
       RestAssured.baseURI="https://restful-booker.herokuapp.com";
		
		RequestSpecification request=RestAssured.given().log().all();
		
		request.contentType("application/json");
		
		Credential cred=new Credential("admin","admin");
		
		ObjectMapper mapper=new ObjectMapper();
		
		String credJsonValue=null;
		
		try {
			credJsonValue= mapper.writeValueAsString(cred);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println("Credential payload is: "+credJsonValue);
		request.body(credJsonValue);
		
		Response response=request.post("/auth");
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
		
		JsonPath json=response.jsonPath();
		
		String reasonMsg=json.get("reason");
		System.out.println("Reason is: "+reasonMsg);
		Assert.assertEquals(reasonMsg, HTTPStatus.WRONG_CREDENTIAL_MESSAGE);
		
		
	}
	// 400 - when you enter the wrong payload
	@Test
	public void getTokenAPIWithBadJSONPayloadTest()
	{
		RestAssured.baseURI="https://restful-booker.herokuapp.com";

		RequestSpecification request=RestAssured.given().log().all();
		
		request.contentType("application/json");
		
		String payload = "{\"username\" : \"admin\" \"password\" : \"password123\"}";
		request.body(payload);
		
		request.body(payload);
		
		Response response=request.post("/auth");
		
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(), HTTPStatus.HTTP_Status_code_400);
		//System.out.println(response.getStatusCode());
		
		//JsonPath json=response.jsonPath();
		
		
		//Assert.assertEquals(json.get("reason"),HTTPStatus.WRONG_CREDENTIAL_MESSAGE);
	

	
	}
}
