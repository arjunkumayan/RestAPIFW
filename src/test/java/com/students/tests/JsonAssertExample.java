package com.students.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class JsonAssertExample {
	
	
	@Test
	public void getStudentList() throws IOException {
		
		String expectedValue = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+
				File.separator+"ExpectedFile.txt")));
		
		System.out.println(expectedValue);
		
		String actualValue = RestAssured.given().when().get("http://localhost:8080/student/list").asString();
		
		System.out.println(actualValue);
		
	//	Assert.assertEquals(actualValue, expectedValue);
		
		try {
			JSONAssert.assertEquals(expectedValue, actualValue, JSONCompareMode.LENIENT);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void getStudentListdifforder() throws IOException {
		
		String expectedValue = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+
				File.separator+"ExpectedFile.txt")));
		
		System.out.println(expectedValue);
		
		String actualValue = RestAssured.given().when().get("http://localhost:8080/student/list").asString();
		
		System.out.println(actualValue);
		
			try {
			JSONAssert.assertEquals(expectedValue, actualValue, JSONCompareMode.STRICT);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
