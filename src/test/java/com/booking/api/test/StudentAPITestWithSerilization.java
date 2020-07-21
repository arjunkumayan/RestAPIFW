package com.booking.api.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat; 


public class StudentAPITestWithSerilization {

	String stuDetails=null;
	Student stu=new Student();
		
	@Test(priority=1)
	public void createNewStudentSerilization() throws JsonProcessingException
	{
		
		stu.setFirstname("Arjun");
		stu.setLastname("Singh");
		stu.setId(109);
		stu.setEmail("singha@gmail.com");
				
		ArrayList<String> courseList=new ArrayList();
		courseList.add("Java");
		courseList.add("Selenium");
		
		stu.setCourses(courseList);
		
		ObjectMapper mapper=new ObjectMapper();
		String stuDetails=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(stu);
		
	System.out.println(stuDetails);
		
		
	}
	
	@Test(priority=2,enabled=true)
	public void getStudent()
	{
		
		System.out.println(stu.getFirstname());
		System.out.println(stu.getLastname());
		System.out.println(stu.getEmail());
		System.out.println(stu.getId());
		System.out.println(stu.getCourses());
		
		List<String> alist=stu.getCourses();
		
		System.out.println(alist);
		
		
		
		
		
	}



	
}
