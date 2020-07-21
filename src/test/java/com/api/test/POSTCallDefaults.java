package com.api.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class POSTCallDefaults {

	@BeforeSuite(alwaysRun = true)
	public void setUp()
	{
		RestAssured.baseURI="https://gorest.co.in";
		RestAssured.basePath="/public-api";
	}
	
	@Test
	public void createUser()
	{
		
	}
	
	@AfterSuite
	public void tearDown()
	{
		
	}
	
}
