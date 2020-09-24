package com.walmart.jsonpath;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.path.xml.XmlPath.*;

import java.util.HashMap;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AssertionExamples {
	
	public static final String APIKEY="75e3u4sgb2khg673cbv2gjup";
	
	
	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI= "http://api.walmartlabs.com";
		RestAssured.basePath= "/v1";
	}
	
	@Test
	public void test001() {
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
	public void test002() {
		System.out.println("-------Starting test-----------");
		
		   given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       .then().body("numItems",equalTo(10));	
	}
	
	@Test
	public void test003() {
		System.out.println("-------Starting test-----------");
		
		   given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       .then().body("query",equalTo("samsung"));	
	}
	
	@Test
	public void test004() {
		System.out.println("-------Starting test-----------");
		
		   given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       .then().body("query",equalToIgnoringCase("samsung"));	
	}
	
	@Test
	public void test005() {
		System.out.println("-------Starting test-----------");
		
		   given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       .then()
		       .body("items.name",hasItem("SAMSUNG 70\" Class 4K UHD (2160p) LED Smart TV with HDR UN70NU6900FXZA"));	
	}
	
	@Test
	public void test006() {
		System.out.println("-------Starting test-----------");
		
		   given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       .then()
		       .body("items.name",hasItem("SAMSUNG 70\" Class 4K UHD (2160p) LED Smart TV with HDR UN70NU6900FXZA"));	
	}
	
	@Test
	public void test007() {
		System.out.println("-------Starting test-----------");
		
		   given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       .then()
		       .body("items.name",hasItems("SAMSUNG 55” Class 4K Crystal UHD (2160P) LED Smart TV with HDR UN55TU7000 2020","SAMSUNG 70\" Class 4K UHD (2160p) LED Smart TV with HDR UN70NU6900FXZA"));	
	}
	
	@Test
	public void test008() {
		System.out.println("-------Starting test-----------");
		
		   given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       .then()
		       .body("items[0].giftOptions",hasKey("allowGiftWrap"));
		   
	}
	@Test
	public void test009() {
		System.out.println("-------Starting test-----------");
		
		   given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       .then()
		       .body("items.findAll{it.name=='give the name'}",hasItem(hasEntry("name", "Apple")));
		   
	}
	@Test
	public void multipleAssertions() {
		System.out.println("-------Starting test-----------");
		
		   given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       .then()
		       .body("items.findAll{it.name=='give the name'}",hasItem(hasEntry("name", "Apple")))
		       .body("items[0].giftOptions",hasKey("allowGiftWrap")).statusCode(200);
		   
	}
	
	@Test
	public void getAllTheNames() {
		System.out.println("-------Starting test-----------");
		
		   given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       .then()
		       .body("items.size()",equalTo(10))
		       .body("items.size()", greaterThan(5))
		       .body("items.size()", lessThan(20))
		       .body("items.size()", greaterThanOrEqualTo(10))
		       .body("items.size()", lessThanOrEqualTo(10));
	     
		   
	}
	
	//Soft Assertions in RestAssured
	
	
}
