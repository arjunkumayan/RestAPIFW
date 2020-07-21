package com.qa.restDemo;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class RestAssuredConfiguration {

	@BeforeSuite(alwaysRun = true)
	public void configure()
	{
		RestAssured.baseURI="https://gorest.co.in";
		RestAssured.basePath="/public-api";
	}

}
