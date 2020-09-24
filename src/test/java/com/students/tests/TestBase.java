package com.students.tests;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class TestBase {
	
	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;
		RestAssured.basePath="/student";
	}
	

}
