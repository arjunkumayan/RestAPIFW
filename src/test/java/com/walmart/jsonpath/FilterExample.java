package com.walmart.jsonpath;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

public class FilterExample {
	
	public static final String APIKEY="75e3u4sgb2khg673cbv2gjup";
	public static RequestSpecBuilder builder;
	public static RequestSpecification requestSpec;
	public static ResponseSpecBuilder responseBuilder;
	public static ResponseSpecification responseSpec;
	
	
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI= "http://api.walmartlabs.com";
		RestAssured.basePath= "/v1";
		builder = new RequestSpecBuilder();
		builder.addQueryParam("query", "samsung");
		builder.addQueryParam("apiKey", APIKEY);
		builder.addQueryParam("format", "json");
		//builder.addQueryParam("facet", "on");
		builder.addHeader("Accept", "*/*");	
		requestSpec = builder.build();
		responseBuilder = new ResponseSpecBuilder();
		
	   responseBuilder.expectHeader("Content-Type", "application/json");
	   responseBuilder.expectStatusCode(200);
	   responseBuilder.expectBody("query",equalTo("samsung"));
	   
	   responseBuilder.expectBody("numItems",equalTo(10));
	    // responseBuilder.expectBody("items.name",hasItem(""));
	   
	   responseSpec = responseBuilder.build();
	   
		
	}
	
	@Test(enabled=false)
	public void test001() {			
	         given()
				
				.queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       
		       .then().log().all();

	}
	
	@Test(enabled=true)
	public void getUsingRequestSpec() {			
	         given()
				.spec(requestSpec)
				.when()
		       .get("/search")
		        .then().log().all();

	}
	
	@Test(enabled=true)
	public void getUsingRequestSpec1() {
		
	         given()
				.spec(requestSpec)
				.when()
		       .get("/search")
		        .then().spec(responseSpec);
	         
	}
	
}
