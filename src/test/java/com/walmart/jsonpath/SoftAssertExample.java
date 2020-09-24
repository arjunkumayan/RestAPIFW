package com.walmart.jsonpath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class SoftAssertExample {
public static final String APIKEY="75e3u4sgb2khg673cbv2gjup";
	
	
	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI= "http://api.walmartlabs.com";
		RestAssured.basePath= "/v1";
	}
	
	@Test
	public void hardAssert() {
		System.out.println("-------Starting test-----------");
		
		int numitems  = given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       .then().extract().path("numItems");	
		System.out.println(numitems);
		
		Assert.assertEquals(numitems, 10);
	}
	
	@Test
	public void softAssert() {
		System.out.println("-------Starting test-----------");
		
		   given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       .then()
		       .body("items.size()",equalTo(10),greaterThan(5),lessThan(20),greaterThanOrEqualTo(10),lessThanOrEqualTo(10));
		  
	     
		   
	}
	

}
