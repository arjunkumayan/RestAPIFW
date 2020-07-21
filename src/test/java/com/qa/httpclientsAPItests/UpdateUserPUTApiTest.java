package com.qa.httpclientsAPItests;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.qa.util.TestUtil;

import cm.qa.pojo.Users;

public class UpdateUserPUTApiTest {
	
	@Test
	public void updateUserTest()
	{
		// 1. create a new user
		//2. get the id from POST response body
		//3. use update API and append id with url
		//4. update the POJO
		//4 . hit the put call
		//5. get the response
		
CloseableHttpClient httpClient = MyHttpClientUtil.createHttpClient();
		
		HttpPost postRequest = MyHttpClientUtil.createRequestWithUrl("https://gorest.co.in/public-api/users");
		
		MyHttpClientUtil.addHeaders(postRequest);
		MyHttpClientUtil.addToken(postRequest, "g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		
		// create the pojo
		Users user=new Users();
		user.setFirst_name("Dr Amit");
		user.setLast_name("Sinha");
		user.setGender("male");
		user.setDob("-9-08-1978");
		user.setEmail("arkusingh@gmail.com");
		user.setPhone("+1-456-980-2345");
		user.setAddress("address1");
		user.setWebsite("https://www.google.com");
		user.setStatus("active");
		
		MyHttpClientUtil.addJsonPayloadBody(postRequest, user);
		
		// hit the api with execute method
		CloseableHttpResponse httpResponse = MyHttpClientUtil.executeAPI(postRequest, httpClient);
		
		// get the status code
		int responseCode= MyHttpClientUtil.getResponseStatusCode(httpResponse);
		System.out.println("Response code is: "+responseCode);
		
		// print the response json
		String responseBody = MyHttpClientUtil.getResponseBody(httpResponse);
		
		System.out.println(responseBody);
		
		//10708
		
		Object document = Configuration.defaultConfiguration().jsonProvider().parse(responseBody);
		
		List<String> idList=JsonPath.read(document, "$..id");
		System.out.println("user id is: "+idList.get(0));
		String id=idList.get(0);
		
		// PUT Call
		String putUrl="https://gorest.co.in/public-api/users/"+id;
		
		HttpPut putRequest=new HttpPut(putUrl);
		
		putRequest.addHeader("Content-Type","application/json");
		putRequest.setHeader("accept","application/json");
		putRequest.addHeader("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		
		
		user.setStatus("inactive");
		
		String entityPut= TestUtil.getSerilizedJson(user);
		System.out.println(entityPut);
		
		StringEntity userEntity=null;
		try {
			userEntity=new StringEntity(entityPut);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// add the json payload
		putRequest.setEntity(userEntity);
		
		CloseableHttpResponse httpPutResponse =null;
		try {
			httpPutResponse=httpClient.execute(putRequest);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// get the status code
		int putResponseCode=httpPutResponse.getStatusLine().getStatusCode();
		
		System.out.println(putResponseCode);
		
		// Get the response body
		
		HttpEntity httpEntityPut =httpPutResponse.getEntity();
		
		String responseBodyPut=null;
		try {
			responseBodyPut=EntityUtils.toString(httpEntityPut);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("=======PUT Response body=====");
		System.out.println(responseBodyPut);
		
	Object document1 = Configuration.defaultConfiguration().jsonProvider().parse(responseBodyPut);
		
		List<String> idList1=JsonPath.read(document, "$..id");
		System.out.println("user id after put is: "+idList.get(0));
		String id1=idList.get(0);
		System.out.println(id1);
		
	}
	
	
	
	
	
	
	
	
	

}
