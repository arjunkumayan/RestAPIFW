package com.students.tests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*; 
import static io.restassured.matcher.RestAssuredMatchers.*;

public class StudentGetTest {
	// http://localhost:8080/student/list
	
	@BeforeClass
	public static void init()
	{
		// Set the defaults  - parameter
		RestAssured.baseURI = "http://localhost";
		RestAssured.port=8080;
		RestAssured.basePath="/student";
		
		
	}
	
	@Test
	public void getAllStudentInformation()
	{
		/**
		 * given().
		 *                set cookes, auth, headers, add parameter
		 * .        when()
		 * GET, POST, PUT, DELETE etc
		 *         then you get the response and 
		 *.then()
		 *       validate status code, extract response,extract cookies, headers
		 *       extract response body
		 * 
		 * 
		 */
		
		
		Response response =given()
				.when()
                .get("/list");
		    System.out.println( response.body().prettyPrint());
		    
		    // validate the status code
		    
		    given()
			.when()
            .get("/list")
            .then()
            .statusCode(200);
		    
		    
	}
	
	@Test
	public void getSingleStudent()
	{
		Response response = given()
		.when()
		.get("/1") ; 
		System.out.println("Pretty print"+response.body().prettyPrint());
		System.out.println("Pretty preek"+response.body().prettyPeek().prettyPrint());
		
		int statusCode = response.getStatusCode();
		
	}
	
	@Test
	public void getStudentFromFA()
	{
		System.out.println("----------------");
		Response response = given()
				.when()
				.get("/list?programme=Financial Analysis&limit=2");
		System.out.println(response.prettyPeek().prettyPrint());
		
		
		Response respo = given()
				.param("programme", "Financial Analysis")
				.param("limit", 2)
				.when()
				.get("/list");
		
		System.out.println("Response after parametr added"+respo.prettyPeek().prettyPrint());
	}
	

}
