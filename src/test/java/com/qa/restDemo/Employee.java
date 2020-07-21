package com.qa.restDemo;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cm.qa.pojo.Users;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.equalTo;
public class Employee {
	
	@Test(groups ="demo")
	public void createUser()
	{
		Users1 user=new Users1("manojsing", "fartyaal", "male", "01-01-1985", "manojfartayal@gmail.com", "+1-9871179-787", "https://www.google.com", "prempark 1", "active");
		POJOUSERS po = new POJOUSERS("arjunk", "singhkl", "male", "01-01-1988", "arjunkunhir@gmail.com", "+1-9880879-765");
		
		
				
		RequestSpecification  request = given().log().all();
		request.header("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		
		request.header("Content-Type","application/json");
		
		String jsonBody = null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonBody = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		request.body(jsonBody);
		
		Response response = request.post(EndPoint.GET_USERS);
		
		// Validate the response
		// map the response to java object using POJO
		
		// it will map the response to pojo class Users1
		Users1 usr=response.as(Users1.class, ObjectMapperType.GSON);
		
		// Now expected data may come from the Database, excel sheet, external files
		// validate the response of pojo to expected result
		
		usr.getAddress();
		
		
		
		System.out.println(response.prettyPrint());
		
		// Inline validation
		// 1. hard assertion
		/*
		 * response.then().log().all() .body("first_name",equalTo(user.getFirst_name()))
		 * .body("last_name",equalTo(user.getLast_name()))
		 * .body("gender",equalTo(user.getGender())) .body("dob",equalTo(user.getDob()))
		 * .body("email",equalTo(user.getEmail()))
		 * .body("phone",equalTo(user.getPhone()))
		 * .body("website",equalTo(user.getWebsite()))
		 * .body("address",equalTo(user.getAddress()))
		 * .body("status",equalTo(user.getStatus()));
		 */
		
		
		Assert.assertEquals(response.jsonPath().getString("result.first_name"), user.getFirst_name());
		      
		
		// 2. soft Assertion
		SoftAssert softassert = new SoftAssert();
		
		softassert.assertEquals(response.path("result.last_name"), user.getLast_name(),"last name is not matched");
		
		softassert.assertAll();
		
		// java object
		softassert.assertEquals(user.getEmail(), user.getLast_name());
		
	}
	
	
	
	
	
	
	
	

}
