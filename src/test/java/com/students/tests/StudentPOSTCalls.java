package com.students.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class StudentPOSTCalls extends TestBase {
	
	@Test
	public void createStudent() {
		
		String payload="{\"firstName\":\"arjun\",\"lastName\":\"singgg\",\"email\":\"arjun.sin@Duisac.net\",\"programme\":\"Financial Analysis\",\"courses\":[\"Accounting\",\"Statistics\"]}";
		RestAssured.given()
		            .when()
		            .contentType(ContentType.JSON)
		            .when()
		            .body(payload)
		            .post()
		            .then().statusCode(201);
		
	}

	
	@Test
	public void createStudentAsObject() {
		StudentPojo student = new StudentPojo();
		
		student.setFirstName("kuldeep");
		student.setLastName("sing");
		student.setEmail("kuk1234@fff.com");
		student.setProgramme("Software developer");
		
		List<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("C++");
		student.setCourses(courses);
		
						
		RestAssured.given()
		            .when()
		            .contentType(ContentType.JSON)
		            .when()
		            .body(student)
		            .post()
		            .then().statusCode(201);
		
	}

	@Test
	public void createStudentAsObjectUsingFacker() {
		StudentPojo student = new StudentPojo();
		
	   Faker fake = new Faker();
		student.setFirstName(fake.name().firstName());
		student.setLastName(fake.name().lastName());
		student.setEmail(fake.internet().emailAddress());
		student.setProgramme("Software developer");
		
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
		            .contentType(ContentType.JSON)
		            .when()
		            .body(payload)
		            .post()
		            .then().statusCode(201);		
	}
	
	
	
}
