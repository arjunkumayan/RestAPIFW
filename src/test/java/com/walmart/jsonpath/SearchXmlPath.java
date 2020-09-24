package com.walmart.jsonpath;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.path.xml.XmlPath.*;

import java.util.HashMap;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;

public class SearchXmlPath {
	
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
		       .queryParam("format", "xml")
		       .when()
		       .get("/search")
		       .then().extract().path("searchresponse.numitems");	
		System.out.println(numitems);
	}
	
	@Test
	public void test002() {
		System.out.println("-------Starting test-----------");
		
		String productName  = given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "xml")
		       .when()
		       .get("/search")
		       .then().extract().path("searchresponse.items.item[0].name");	
		System.out.println(productName);
	}
	
	
	@Test
	public void test003() {
		System.out.println("-------Starting test-----------");
		String xml = given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "xml")
		       .when()
		       .get("/search")
		       .asString();	
		System.out.println(xml);
		
		//String giftOptions = with().get(xml, "searchresponse.items.item[0].imageEntities");
	
				//.getString("searchresponse.items.item[0].imageEntities");
		
	}
	
	@Test
	public void test004() {
		System.out.println("-------Starting test-----------");
		NodeChildrenImpl val = given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "xml")
		       .when()
		       .get("/search").then().extract().path("searchresponse.items.item");
		
		System.out.println(val.size());
	}
	
	@Test
	public void test005() {
		System.out.println("-------Starting test-----------");
		String xml = given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "xml")
		       .when()
		       .get("/search").asString();
		
		List<String> names = with(xml).getList("searchresponse.items.item.name");	
		System.out.println(names);
	
	}
	
	@Test
	public void test006() {
		System.out.println("-------Starting test-----------");
		String xml = given().queryParam("query", "samsung")
		       .queryParam("apiKey", APIKEY)
		       .queryParam("format", "xml")
		       .when()
		       .get("/search").asString();
		
		List<String> slePrice = with(xml).getList("searchresponse.items.item.findAll{it.name=='Straight Talk SAMSUNG Galaxy A20, 32GB Black - Prepaid Smartphone'}.salePrice");		
	
		System.out.println(slePrice);
	}
	
	
}
