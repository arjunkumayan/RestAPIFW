package com.students.tests;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

public class LoggingRequest extends TestBase{
	
	// Print Request Headers
	@Test
	public void logRequest() {
		System.out.println("--------Printing Request Headers-------------");
		given().log().headers()
		     .when()
		     .get("http://localhost:8080/student/1")
             .then().statusCode(200);  		
	}
	
	@Test
	public void logRequest2() {
		System.out.println("--------Printing Request Parameters-------------");
		given().param("programme", "Financial Analysis")
		        .param("limit", 1).log().params()
		     .when()
		     .get("http://localhost:8080/student/1")
             .then().statusCode(200);  		
	}
	
	@Test
	public void logRequest3() {
		StudentPojo student = new StudentPojo();
		
		   Faker fake = new Faker();
			student.setFirstName(fake.name().firstName());
			student.setLastName(fake.name().lastName());
			student.setEmail(fake.internet().emailAddress());
			student.setProgramme("Software developer2");
			
			List<String> courses = new ArrayList<String>();
			courses.add("Java");
			courses.add("C++");
			student.setCourses(courses);
			String payload=null;
			ObjectMapper mapper = new ObjectMapper();
			try {
				payload = mapper.writeValueAsString(student);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
							
			RestAssured.given()
			            .when()
			            .contentType(ContentType.JSON).log().body()
			            .when()
			            .body(payload)
			            .post()
			            .then().statusCode(201);		
		}
	@Test
	public void logRequest4() {
		StudentPojo student = new StudentPojo();		
		   Faker fake = new Faker();
			student.setFirstName(fake.name().firstName());
			student.setLastName(fake.name().lastName());
			student.setEmail(fake.internet().emailAddress());
			student.setProgramme("Software developer3");
			
			List<String> courses = new ArrayList<String>();
			courses.add("Java");
			courses.add("C++");
			student.setCourses(courses);
			String payload=null;
			ObjectMapper mapper = new ObjectMapper();
			try {
				payload = mapper.writeValueAsString(student);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
							
			RestAssured.given()
			            .when()
			            .contentType(ContentType.JSON).log().all()
			            .when()
			            .body(payload)
			            .post()
			            .then().statusCode(201);		
		}
	
	@Test
	public void logRequest5() {
		System.out.println("------------- Print object request if validation fails -----------");
		StudentPojo student = new StudentPojo();		
		   Faker fake = new Faker();
			student.setFirstName(fake.name().firstName());
			student.setLastName(fake.name().lastName());
			student.setEmail(fake.internet().emailAddress());
			student.setProgramme("Software developer3");
			
			List<String> courses = new ArrayList<String>();
			courses.add("Java");
			courses.add("C++");
			student.setCourses(courses);
			String payload=null;
			ObjectMapper mapper = new ObjectMapper();
			try {
				payload = mapper.writeValueAsString(student);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
							
			RestAssured.given()
			            .when()
			            .contentType(ContentType.JSON).log().ifValidationFails()
			            .when()
			            .body(payload)
			            .post()
			            .then().statusCode(201);		
		}

	@Test
	public void logResponse001() {
		System.out.println("------------- Print object response---------");

		given().param("programme", "Financial Analysis")
		        .param("limit", 1).log().params()
		     .when()
		     .get("http://localhost:8080/student/1")
             .then().log().headers().statusCode(200);  		
	
}
	

	@Test
	public void logResponse002() {
		System.out.println("------------- Print object response---------");
		given().param("programme", "Financial Analysis")
		        .param("limit", 1).log().params()
		     .when()
		     .get("http://localhost:8080/student/1")
             .then().log().ifError().statusCode(200);  		
	
}

	@Test
	public void logResponse003() {
		System.out.println("------------- Print object response---------");
		given().param("programme", "Financial Analysis")
		        .param("limit", 1).log().params()
		     .when()
		     .get("http://localhost:8080/student/1")
             .then().log().ifValidationFails().statusCode(200); 
	
        }

	@Test
	public void logResponse004() {
		System.out.println("------------- Print object response Status Line---------");
		given().param("programme", "Financial Analysis")
		        .param("limit", 1).log().params()
		     .when()
		     .get("http://localhost:8080/student/1")
             .then().log().status().statusCode(200); 
	
        }
	
	@Test
	public void logResponse005() {
		System.out.println("------------- Print object response Status Line---------");
		given().param("programme", "Financial Analysis")
		        .param("limit", 1).log().params()
		     .when()
		     .get("http://localhost:8080/student/1")
             .then().log().ifStatusCodeIsEqualTo(200).statusCode(200); 
	
        }
	
	@Test
	public void logResponse006() {
		System.out.println("------------- Print object response Status body---------");
		given().param("programme", "Financial Analysis")
		        .param("limit", 1).log().params()
		     .when()
		     .get("http://localhost:8080/student/1")
             .then().log().body().statusCode(200); 
	
        }

	@Test
	public void logResponse007() {
		System.out.println("------------- Print object response Status body incase of an error---------");
		given().param("programme", "Financial Analysis")
		        .param("limit", -1).log().params()
		     .when()
		     .get("http://localhost:8080/student/1")
             .then().log().ifError(); 
	
        }

}
