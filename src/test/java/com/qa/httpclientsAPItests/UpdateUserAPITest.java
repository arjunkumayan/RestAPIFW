package com.qa.httpclientsAPItests;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.testng.annotations.Test;

import cm.qa.pojo.Users;

public class UpdateUserAPITest {
	
	int userID;
	
	@Test
	public void updateUserTest()
	{
		// POST Request
		CloseableHttpClient httpClient = MyHttpClientUtil.createHttpClient();
		
		HttpPost postRequest = MyHttpClientUtil.createRequestWithUrl("https://gorest.co.in/public-api/users");
		
		MyHttpClientUtil.addHeaders(postRequest);
		MyHttpClientUtil.addToken(postRequest, "g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		
		Users user=new Users();
		user.setFirst_name("Dr Amit");
		user.setLast_name("Sinha");
		user.setGender("male");
		user.setDob("-9-08-1978");
		user.setEmail("dramsingh@gmail.com");
		user.setPhone("+1-456-980-2345");
		user.setWebsite("https://www.google.com");
		user.setStatus("active");
		
		MyHttpClientUtil.addJsonPayloadBody(postRequest, user);
		
		CloseableHttpResponse httpResponse = MyHttpClientUtil.executeAPI(postRequest, httpClient);
		
		String responseBody = MyHttpClientUtil.getResponseBody(httpResponse);
		
		System.out.println(responseBody);
		// PUT Request
		//CloseableHttpClient httpClient = MyHttpClientUtil.createHttpClient();
		
		//MyHttpClientUtil.updateRequestWithUrl("https://gorest.co.in/public-api/users"+userID);
		
		
		
	}
	
	

}
