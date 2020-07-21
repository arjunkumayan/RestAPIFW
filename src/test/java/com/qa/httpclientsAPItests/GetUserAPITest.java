package com.qa.httpclientsAPItests;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserAPITest {

	
	@Test
	public void goRestUserAPITest()
	{
		CloseableHttpResponse response=null;
		CloseableHttpClient httpClient  =HttpClientBuilder.create().build();
		
		//1. give url:
		HttpGet getRequest=new HttpGet("https://gorest.co.in/public-api/users");
		
	    //2. add headers
		getRequest.addHeader("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		
		//3. execute the api
		try {
			response=httpClient.execute(getRequest);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//4. get the status code
		
		int status = response.getStatusLine().getStatusCode();
		System.out.println(status);
		Assert.assertEquals(status, 200);
		
		//5. get the response body
		HttpEntity  httpEntity=response.getEntity();
		try {
			String responseBody=EntityUtils.toString(httpEntity);
			System.out.println(responseBody);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
