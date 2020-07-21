package com.booking.api.test;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat; 


public class StudentAPITestNoSeroilization {

	public HashMap map=new HashMap();
	ArrayList alist=new ArrayList();
	
	
	@Test
	public void createNewStudent()
	{
		map.put("id",107);
		map.put("firstname", "Ardjun");
		map.put("lastname", "Sindgh");
		map.put("email", "Arjudns@gmail.com");
		map.put("programme", "SdDET");
	
		ArrayList<String> courseList=new ArrayList();
		
		courseList.add("Java");
		courseList.add("Selenium");
		
		map.put("courses", courseList);
		
		//RestAssured.baseURI="";
		
		//RestAssured.given().log().all();
		
		given().contentType(ContentType.JSON)
		.body(map)
		.when()
		.post("http://localhost:8085/student")
		.then()
		.statusCode(201)
		/*
		 * .assertThat() .body("msg",equalTo("Student added"))
		 */;
				
	}
	
	@Test(priority=2)
	public void getStudent()
	{
		given().when()
		.get("http://localhost:8085/student/101")
		.then()
		.statusCode(200)
		.assertThat()
		.body("id",equalTo(101)).log().all();
	}




	
}
