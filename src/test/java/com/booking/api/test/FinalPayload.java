package com.booking.api.test;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FinalPayload {

	// Serialization - The process of converting java object to a file - the file can be stored anywhere in a db etc
	// Java object to JSON
	// By usin FileOutputStream and ObjectOutputStream classes we can achieve serilization.
	
	@Test
	public void IssuePOJOCreation()
	{
		String jsonPayload=null;
		
		Issuetype issue=new Issuetype("Task");
		Projects proj=new Projects("REST");
		Payload p=new Payload("Demo1", "Demo1 Description", issue, proj);
		Fields f=new Fields(p);
		
		ObjectMapper mapper=new ObjectMapper();
		try {
			jsonPayload=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(f);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		
		System.out.println(jsonPayload);
	}
}
