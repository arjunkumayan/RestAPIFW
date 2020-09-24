package com.students.tests;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;


public class StudentGetRequest extends TestBase {
	
	@Test
	public void getStudents() {
		
		RestAssured.given()
		           .when()
		           .get("http://localhost:8080/student/list")
		           .then()
		           .assertThat().statusCode(200);
		

	}
	@Test
	public void getStudentsUsingGiven() {

		given().when().expect().statusCode(200).when().get("http://localhost:8080/student/list");

	}
	
	@Test
	public void getCSStudent() {		
		 Response response=   given()
		       .queryParam("programme", "Computer Science")
		       .queryParam("limit", 1)
		       .when().get("http://localhost:8080/student/list");
		System.out.println(response.prettyPrint());
	}
	
	@Test
	public void getCSStudentAsParams() {		
		 Response response=   given()
		       .queryParams("programme", "Computer Science", "limit", 1)
		       .when().get("http://localhost:8080/student/list");
		System.out.println(response.prettyPrint());
	}
	
	
	@Test
	public void getCSStudentAsMap() {	
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("programme", "Computer Science");
		params.put("limit", 1);
		
		 Response response=   given().queryParams(params)
		       .when().get("http://localhost:8080/student/list");
		 System.out.println(response.prettyPrint());
	}
	
	@Test
	public void getTheFirstStudentAsParam() {	
		
		 Response response=  given().pathParam("id", 2)
		       .when().get("http://localhost:8080/student/{id}");
		 System.out.println(response.prettyPrint());
	}
	
	@Test
	public void getCheckWithoutHardCode() {
		given().pathParam("id", 2)
		       .when()
		       .get("/{id}")
		       .then().assertThat().statusCode(200);
		
		Response response = given().pathParam("id", 2)
	       .when()
	       .get("/{id}");
		System.out.println(response.prettyPrint());
		
		RestAssured.reset();
		Response response1 = given().pathParam("id", 2)
			       .when()
			       .get("/{id}");
				System.out.println(response.prettyPrint());
		System.out.println(response1.prettyPrint());
		
	}
	
	

}
