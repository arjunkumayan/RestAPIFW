package com.students.tests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.pojo1.StudentsPojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StudentPostTest {
	
	
	@BeforeClass
	public static void init()
	{
		// Set the defaults  - parameter
		RestAssured.baseURI = "http://localhost";
		RestAssured.port=8080;
		RestAssured.basePath="/student";
	
	}

	
	@Test
	public void createNewStudnet()
	{				    
		    // validate the status code
		    
		    ArrayList<String> courses= new ArrayList<String>();
		    courses.add("java");
		    courses.add("API");
		    
		    StudentsPojo student = new StudentsPojo("Arjun","singhdd","ar@email.com","sdet",courses);
		    
		    given().contentType(ContentType.JSON)
		    .when().body(student).post().then().statusCode(201);
		    
	}
	
	@Test
	public void updateStudnet()
	{				    
		    // validate the status code
		    
		    ArrayList<String> courses= new ArrayList<String>();
		    courses.add("java and Selenium");
		    courses.add("API with Rest java");
		    
		    StudentsPojo student = new StudentsPojo("Arjun","singhdd","ar@email.com","sdet",courses);
		    
		    given().contentType(ContentType.JSON)
		    .when().body(student).put("/101").then().statusCode(200);
		    
	}
	@Test
	public void patchStudnet()
	{				    
		    // validate the status code
		    
		    ArrayList<String> courses= new ArrayList<String>();
		    courses.add("java and Selenium");
		    courses.add("API with Rest java");
		    
		    StudentsPojo student = new StudentsPojo("Arjun","singhdd","arjun@email.com","sdet",courses);
		    
		    given().contentType(ContentType.JSON)
		    .when().body(student).patch("/101").then().statusCode(200);
		    
	}
	
	@Test
	public void deleteStudnet()
	{				    
		    // validate the status code
		    
		    ArrayList<String> courses= new ArrayList<String>();
		    courses.add("java and Selenium");
		    courses.add("API with Rest java");
		    
		   // StudentsPojo student = new StudentsPojo("Arjun","singhdd","arjun@email.com","sdet",courses);
		    
		    given()
		    .when().delete("/101").then().statusCode(204);
		    
	}
	
	// logging parameters
	@Test
	public void getStudentParameters()
	{				    
		    // validate the status code
		    System.out.println("printing request headers");
		    		    
		    given()
		    .param("programme", "Financial Analysis")
		    .param("limit", 1)
		    .log()
		    .parameters()
		    .when().get("/1").then().statusCode(200);
		    
	}
	
	//loggine headers
	@Test
	public void getStudentHeaders()
	{				    
		    // validate the status code
		    System.out.println("printing request headers");
		    		    
		    given()
		      .log()
		      .headers()
		       .when().get("/1").then().statusCode(200);
		    
	}
	
	
	//loggine body
	@Test
	public void createNewStudnetForLoggingBody()
	{				    
		    // validate the status code
		    
		System.out.println("Request body printing");
		    ArrayList<String> courses= new ArrayList<String>();
		    courses.add("javawd11");
		    courses.add("API1w1d");
		    
		    StudentsPojo student = new StudentsPojo("Arjunsdssinghe","sinddghdd","arewddd@email.com","sdet",courses);
		    
		    given().log().ifValidationFails().contentType(ContentType.JSON)
		    .when().body(student).post().then().statusCode(201);
	
}
	
	@Test
	public void getStudentResponseHeaders()
	{				    
		    // validate the status code
		    System.out.println("printing request headers");
		    		    
		    given()
		      .log()
		      .headers()
		       .when().get("/1").then().log().ifError().statusCode(200);
		    
	}
}