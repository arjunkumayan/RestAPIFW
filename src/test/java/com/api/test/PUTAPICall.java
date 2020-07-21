
package com.api.test;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUTAPICall {
	// PUt- to update the resource
	
	@Test
	public void updateUserwithPUTTest()
	{
		
		RestAssured.baseURI="https://gorest.co.in/";
		
		RequestSpecification request=RestAssured.given().log().all();
		request.contentType("application/json");
		request.header("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		
		File file=new File("D:\\Users\\asingh6766\\eclipse-workspace\\RestAssuredProject\\src\\test\\java\\com\\api\\test\\updateUser.json");
		
		
		request.body(file);
		
		Response response=request.put("public-api/users/8851");
		
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
		
		
		Response requenceGet=request.get("public-api/users?first_name=reGupta");
		
		System.out.println(requenceGet.prettyPrint());
		System.out.println(requenceGet.getStatusCode());
	}

}
