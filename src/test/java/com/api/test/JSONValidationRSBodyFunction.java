package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.istack.NotNull;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import org.hamcrest.collection.HasItemInArray;
import org.hamcrest.core.Is;

public class JSONValidationRSBodyFunction {

	
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
		
		System.out.println("===================");
		ResponseBody body = response.getBody();
		System.out.println("Response Body: "+body.asString());
		
		ValidatableResponse resp = response.then();
		
		resp.assertThat().statusCode(HTTPStatus.HTTP_Status_code_200);
		
		resp.assertThat().body("name", equalTo("India"));
		
		resp.body("alpha2Code", Is.is("IN"));
		
		resp.body("languages.name[0]", Is.is("Hindi"));
		//resp.body("languages.name", hasItems("Hindi,English"));
		
		//.body("languages.name[0]", Is.is("HINDI")).log().all();
		
		
		
		//.body("regionalBlocs.acronym", equalTo("SAARC"));
		//.body("cioc",equalTo("IND")).body("languages[].name",hasItems("Hindi","English")).log().all();
		
	}
}
