package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;

public class JSONValidationJSONPath {

	
	@Test
	public void verifyJsonResponse()
	{
		RestAssured.baseURI="https://restcountries.eu/rest/v2/alpha";
		
		RequestSpecification  request = RestAssured.given().log().all();
		
		Response  response = request.get("/IN");
		
		System.out.println(response.prettyPrint());
		
		// how to validate the large json
		// 1. First way using the restassured in build method body
		
		// 2. Second way using the JsonPath
		// 3. Third way using java object(map the response to java object and then extract)
		
		
		int status = response.getStatusCode();
		Assert.assertEquals(status, 200);
		
		
		JsonPath js =response.jsonPath();
		
		
		
	}
}
