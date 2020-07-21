package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DELETECallAPI {

	@Test
	public void deleteUserAPITest()
	{
RestAssured.baseURI="https://gorest.co.in/";
		
		RequestSpecification request=RestAssured.given().log().all();
		request.contentType("application/json");
		request.header("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		
		
		Response response=request.delete("public-api/users/8858");
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		JsonPath json=response.jsonPath();
		String res=json.get("result");
		System.out.println("Result is: "+res);
		Assert.assertEquals(res, null);
		
		Assert.assertNull(json.get("result"));
	}
	
	
	
	
	
}
