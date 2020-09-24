package com.students.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonPathJsonSlurperExamples {
	ValidatableResponse validateResponse;
	
	@BeforeClass
	public void setUp()
	{	RestAssured.baseURI = "http://localhost";
		RestAssured.port = 3030;	
		System.out.println(" BeforeClass ");
		validateResponse = given().when().get("/stores").then();
	}
	
	@BeforeMethod
	public void printToConsole()
	{
	System.out.println("-------- Starting the test method ---------- ");	
	System.out.println("      ");
	}
	
	@AfterMethod
	public void printToConsoleAgain() {
		System.out.println("-------- Ending the test method ---------- ");
		System.out.println("      ");
	}
	
	
	@Test
	public void getTotal() {
		System.out.println(" Print  ");
		int total = validateResponse.extract().path("total");
		System.out.println(total);
	}
	
	@Test
	public void getFirstStoreName() {
		System.out.println(" getFirstStoreName  ");
		String firstName = validateResponse.extract().path("data[0].name");
		System.out.println(firstName);
	}

	@Test
	public void getID() {
		System.out.println(" getFirstStoreName  ");
		int id = validateResponse.extract().path("data[0].services[0].id");
		System.out.println(id);
	}
	
	@Test
	public void getName() {
		System.out.println(" getFirstStoreName  ");
		String name = validateResponse.extract().path("data[0].services[0].name");
		System.out.println(name);
	}

	@Test
	public void findStoreWithZip() {
		System.out.println(" findStoreWithZip  ");
		Map<String,?> info = validateResponse.extract().path("data.find{it.zip=='55901'}");
	
		System.out.println(info.toString());
	}
	
	@Test
	public void findStoreAddressWithZip() {
		System.out.println(" findStoreWithZip  ");
		String address = validateResponse.extract().path("data.find{it.zip=='55901'}.address");
	
		System.out.println(address);
	}
	
	@Test
	public void getInfofStoreWithMaxID() {
		System.out.println(" findStoreWithZip  ");
		Map<String,?> ids = validateResponse.extract().path("data.max{it.id}");
	
		System.out.println(ids);
	}
	@Test
	public void getInfofStoreWithMaxID1() {
		System.out.println(" findStoreWithZip  ");
		int ids = validateResponse.extract().path("data.max{it.id}.id");
	
		System.out.println(ids);
	}
	
	@Test
	public void getInfofStoreWithIdlessThan10() {
		System.out.println(" findStoreWithZip  ");
		List<String> zipcode = validateResponse.extract().path("data.findAll{it.id<15}.zip");
	
		System.out.println(zipcode.toString());
		zipcode.stream().forEach((val)->{
			System.out.println(val);
		});
	}
	
	@Test
	public void getNameForAllStores() {
		System.out.println(" getNameForAllStores  ");
		List<List<String>> names = validateResponse.extract().path("data.services.findAll{it.name}.name");
	
		System.out.println(names.toString());
		names.stream().forEach((val)->{
			System.out.println(val);
		});
	}
}
