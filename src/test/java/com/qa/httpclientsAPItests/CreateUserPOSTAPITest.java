package com.qa.httpclientsAPItests;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.util.TestUtil;

import cm.qa.pojo.Users;

public class CreateUserPOSTAPITest {
	
	
	@Test(enabled=false)
	public void createUserAPITest()
	{
		StringEntity userEntity = null;
		CloseableHttpResponse responsePOST=null;
		
		CloseableHttpClient httpClient=HttpClientBuilder.create().build();
		
		// 1. Create a post request with url
		
		HttpPost postRequest=new HttpPost("https://gorest.co.in/public-api/users");
		
		
		//2. add headers:
		postRequest.addHeader("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		postRequest.addHeader("Content-Type","application/json");
		
		//3. add the json payload body
		
		Users user=new Users("varunh444", "zm", "male", "01-01-1987", "mk12ww3@gmail.com", "+1-9870879-765", "https://www.google.com", "prempark 1", "active");
		
		
		String entity = TestUtil.getSerilizedJson(user);
		System.out.println(entity);
		
		
		try {
			userEntity = new StringEntity(entity);
			
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		postRequest.setEntity(userEntity); // add the final payload - json body String
		
		//4. Hit the api with execute method:
		try {
			responsePOST=httpClient.execute(postRequest);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//5. get the status code
        int statusCode=responsePOST.getStatusLine().getStatusCode();
        System.out.println("Status code from response: "+statusCode);
	    //Assert.assertEquals(statusCode, 200);
		
		// 6. print the response body
		HttpEntity httpEntity=responsePOST.getEntity();
		
		try {
			String responseBody=EntityUtils.toString(httpEntity);
			System.out.println(responseBody);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createUserTest()
	{
		CloseableHttpClient httpClient=MyHttpClientUtil.createHttpClient();
		HttpPost postRequest = MyHttpClientUtil.createRequestWithUrl("https://gorest.co.in/public-api/users");
		MyHttpClientUtil.addHeaders(postRequest);
		MyHttpClientUtil.addToken(postRequest, "g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		
		
		Users user=new Users("varunsingh", "z", "male", "01-01-1987", "mvarunbg@gmail.com", "+1-9870879-765", "https://www.google.com", "prempark 1", "active");
		MyHttpClientUtil.addJsonPayloadBody(postRequest, user);
		
		CloseableHttpResponse httpResponse = MyHttpClientUtil.executeAPI(postRequest, httpClient);
		MyHttpClientUtil.getResponseStatusCode(httpResponse);
		String responseBody=MyHttpClientUtil.getResponseBody(httpResponse);
		System.out.println(responseBody);
	}

}
