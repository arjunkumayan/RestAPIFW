package com.qa.httpclientsAPItests;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

public class DeleteUserAPITest {
	
	
	@Test
	public void deleteUserTest()
	{
		
		CloseableHttpClient httpClient = MyHttpClientUtil.createHttpClient();
		
		//1. Create HttpDelete Request
		HttpDelete deleteRequest = MyHttpClientUtil.deleteRequestWithUrl("https://gorest.co.in/public-api/users/10706");
		
		//2. add token headers
		
		deleteRequest.addHeader("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		
		//3. execute the api
		CloseableHttpResponse deleteResponse=null;
		try {
			deleteResponse = httpClient.execute(deleteRequest);
		} catch (ClientProtocolException e) {
						e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//4. status code
		
		int code = deleteResponse.getStatusLine().getStatusCode();
		System.out.println(code);
		
		//5 . response body
		String responseBody=null;
		
		HttpEntity  httpEntity = deleteResponse.getEntity();
		try {
			responseBody = EntityUtils.toString(httpEntity);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(responseBody);
		
	}

}
