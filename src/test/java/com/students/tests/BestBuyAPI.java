package com.students.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BestBuyAPI {
	
	String jsonResponse;
	
	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI="http://localhost";
		RestAssured.port=3030;
		jsonResponse = given().when().get("/products").asString();		
	}
	
	@Test
	public void getRoot() {
		Map<String,Object> rootElement = JsonPath.read(jsonResponse, "$");
		System.out.println(rootElement.toString());
	}
	
	@Test
	public void getTotalFromResponse() {
		Integer totalValue = JsonPath.read(jsonResponse, "$.total");
		System.out.println("total value = "+totalValue);
	}
	
	@Test
	public void getAllDataElement() {
		List<HashMap<String,Object>> dataElements = JsonPath.read(jsonResponse, "$.data");

		dataElements.stream().forEach((val)->{
			System.out.println(val);
		});
	
	}
	
	@Test
	public void getFirstDataElement() {
		HashMap<String,Object> dataElements = JsonPath.read(jsonResponse, "$.data[0]");
		
		Set<Entry<String, Object>> s = dataElements.entrySet();
		for(Entry<String, Object> st:s) {
			System.out.println(st);
		}
	}
	
	@Test
	public void getLastDataElement() {
		HashMap<String,Object> dataElements = JsonPath.read(jsonResponse, "$.data[-1]");
		
		Set<Entry<String, Object>> s = dataElements.entrySet();
		for(Entry<String, Object> st:s) {
			System.out.println(st);
		}
	}
	
	@Test
	public void getAllIdsUnderData() {
		List<String> idDataElements = JsonPath.read(jsonResponse, "$.data[*].id");
		
		System.out.println(idDataElements.toString());
	}
	
	@Test
	public void getAllIds() {
		List<String> allIds = JsonPath.read(jsonResponse, "$..[*].id");
		
		System.out.println(allIds.toString());
	}
	
	@Test
	public void getName() {
		List<String> names = JsonPath.read(jsonResponse, "$.data[?(@.price>5)].name");
		
		names.stream().forEach(System.out::println);
	}
	
	
	
}
