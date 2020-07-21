package com.qa.httpclientsAPItests;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.qa.util.TestUtil;



public class MyHttpClientUtil {
	public static StringEntity userEntity = null;
	
	public static CloseableHttpClient createHttpClient()
	{
		CloseableHttpClient httpClient=HttpClientBuilder.create().build();
		return httpClient;
	}
	
	
	public static HttpPost createRequestWithUrl(String url)
	{
		HttpPost postRequest=new HttpPost(url);
		return postRequest;
	}
	
	public static HttpPut updateRequestWithUrl(String url)
	{
		HttpPut putRequest	= new HttpPut(url);
		return putRequest;
	}
	public static HttpDelete deleteRequestWithUrl(String url)
	{
		HttpDelete deleteRequest=new HttpDelete(url);
		return deleteRequest;
	}
	public static HttpPut dputRequestWithUrl(String url)
	{
		HttpPut putRequest=new HttpPut(url);
		return putRequest;
	}
	
	public static void addHeaders(HttpPost postRequest)
	{
		postRequest.addHeader("Content-Type","application/json");
		postRequest.setHeader("accept","application/json");
		
	}
	
	
	public static void addToken(HttpPost postRequest, String token)
	{
		postRequest.addHeader("Authorization","Bearer "+token);
	}
	
	public static void addJsonPayloadBody(HttpPost postRequest, Object obj)
	{
		String entity = TestUtil.getSerilizedJson(obj);
		System.out.println(entity);
		
		try {
			userEntity = new StringEntity(entity);
			
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		postRequest.setEntity(userEntity);
		
		
		
	}
	
	public static CloseableHttpResponse executeAPI(HttpPost postRequest, CloseableHttpClient httpClient)
	{
		CloseableHttpResponse httpResponse=null;
		try {
			httpResponse=httpClient.execute(postRequest);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return httpResponse;
	}
	
	
	public static int getResponseStatusCode(CloseableHttpResponse httpResponse)
	{
	return httpResponse.getStatusLine().getStatusCode();
	}
	
	
	public static String getResponseBody(CloseableHttpResponse httpResponse)
	{
		String responseBody=null;
     HttpEntity httpEntity=httpResponse.getEntity();
		
		try {
			responseBody=EntityUtils.toString(httpEntity);
			System.out.println(responseBody);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseBody;

	}
	
	
	
	
	
	
	
	
	
	
	
}
