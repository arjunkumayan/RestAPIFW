package com.qa.pojo1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FinalPayloadsTest {

	public static void main(String[] args) {
		Issuetype is = new Issuetype("5");
		Parent p = new Parent("TEST-101");
		
		Project pr = new Project("TEST");
		
				
		Payloads pl=new Payloads(pr, p, "sub-task of test-101", "Don't forget to do this too", is);
		Fields fl = new Fields(pl);
		String jsonValue = null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
		jsonValue =	mapper.writerWithDefaultPrettyPrinter().writeValueAsString(fl);
		} catch (JsonProcessingException e) {
				e.printStackTrace();
		}
		System.out.println(jsonValue);
		
		
	}

}
