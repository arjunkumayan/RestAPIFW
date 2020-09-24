package com.walmart.jsonpath;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;

import io.restassured.RestAssured;

public class SearchJsonPath {
	
	public static final String APIKEY="75e3u4sgb2khg673cbv2gjup";
	
	
	@BeforeClass
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
	}
	
	
	@Test
	public void test002() {
		System.out.println("-------Starting test-----------");
		
		String queryName  = given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       .then().extract().path("query");	
		System.out.println(queryName);
	}
	
	
	// Extract name from hashmap
	@Test
	public void test003() {
		System.out.println("-------Starting test-----------");
		
		HashMap<String,Object>  imageOptions  = given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       .then().extract().path("items[0].imageEntities[0]");	
		System.out.println(imageOptions.toString());
	}
	
	
	@Test
	public void test004() {
		System.out.println("-------Starting test-----------");
		
		int  arraysize  = given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       .then().extract().path("items.size");	
		System.out.println(arraysize);
	}

	@Test
	public void test005() {
		System.out.println("-------Starting test-----------");
		
		List<String>  nameList  = given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       .then().extract().path("items.name");	
		System.out.println(nameList);
	}
	
	@Test
	public void test006() {
		System.out.println("-------Starting test-----------");
		
		List<HashMap<String,Object>> mp  = given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       .then().extract().path("items.findAll{it.name='Intel Celeron N3060'}");	
		System.out.println(mp);
	}
	
	@Test
	public void test007() {
		System.out.println("-------Starting test-----------");
		
		List<Float> mp  = given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       .then().extract().path("items.findAll{it.name='Intel Celeron N3060'}.salePrice");	
		System.out.println(mp);
	}
	
	@Test
	public void test008() {
		System.out.println("-------Starting test-----------");
		
		List<String> names = given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       .then().extract().path("items.findAll{it.salePrice<50}.name");	
		System.out.println(names);
	}
	
	@Test
	public void test009() {
		System.out.println("-------Starting test-----------");
		
		List<String> msrpValues = given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       .then().extract().path("items.findAll{it.name==~/SAM.*/}.msrp");	
		System.out.println(msrpValues);
	}
	
	
	@Test
	public void test010() {
		System.out.println("-------Starting test-----------");
		
		List<String> msrpValues = given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "json")
		       .when()
		       .get("/search")
		       .then().extract().path("items.findAll{it.name==~/.*2020/}.salePrice");	
		System.out.println(msrpValues);
	}
}
