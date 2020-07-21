package cm.qa.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FinalPayload {

	public static void main(String[] args) {

		Issuetype issue = new Issuetype("Task");
		Project project = new Project("TEST");
		Payload p  = new Payload("Demo1", "this is demo pojo", issue, project);
		
		Fields f= new Fields(p);
		
		String json = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(f);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		
		System.out.println(json);
	}
	
	

}
