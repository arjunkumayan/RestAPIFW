package com.students.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class StudentPUTCall extends TestBase {

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
						
		Response response= RestAssured.given()
		            .when()
		            .contentType(ContentType.JSON)
		            .when()
		            .body(payload)
		            .post();
		
		System.out.println(response.prettyPrint());
		JsonPath js = response.jsonPath();
		
		          	
	}
	
	@Test
	public void updateStudentAsObjectUsingFacker() {
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
						
		Response response= RestAssured.given()
		            .when()
		            .contentType(ContentType.JSON)
		            .when()
		            .body(payload)
		            .put("/101");
		
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
		          	
	}
	
	@Test
	public void patchUpdateStudentAsObjectUsingFacker() {
		StudentPojo student = new StudentPojo();
		
	    Faker fake = new Faker();
	    
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
						
		Response response= RestAssured.given()
		            .when()
		            .contentType(ContentType.JSON)
		            .when()
		            .body(payload)
		            .patch("/101");
		
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
		          	
	}
	
	
	@Test
	public void deleteStudentAsObjectUsingFacker() {						
		Response response= RestAssured.given()
		            .when()
		            .contentType(ContentType.JSON)
		            .when()
		            .delete("/101");
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
		          	
	}
}
