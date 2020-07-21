package com.qa.httpclientsAPItests;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class BasicAuthWithHttpClient {
	
	
	@Test(enabled=true)
	public void basicAuthWithHttpHandleTest()
	{
		
		// basic auth: username and password
		
		CredentialsProvider  creds=new BasicCredentialsProvider();
		
		creds.setCredentials(
				new AuthScope("httpbin.org",80),
				new UsernamePasswordCredentials("user", "passwd"));
				
		
		CloseableHttpClient  httpCleint=HttpClients.custom().setDefaultCredentialsProvider(creds).build();
	
	  HttpGet httpGetRequest=new HttpGet("http://httpbin.org/basic-auth/user/passwd");
	  CloseableHttpResponse httpResponse =null;
	  try {
		  httpResponse = httpCleint.execute(httpGetRequest);
	} catch (ClientProtocolException e) {
			e.printStackTrace();
	} catch (IOException e) {
		  e.printStackTrace();
	}
	  
	  System.out.println(httpResponse.getStatusLine().getStatusCode());
	  
	  	try {
			System.out.println(EntityUtils.toString(httpResponse.getEntity()));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
		}
	}


@Test(enabled=false)
public void basicAuthHttpHandleTest()
{
	
	// basic auth: username and password
	
	CredentialsProvider creds = new BasicCredentialsProvider();
	
	creds.setCredentials(
			new AuthScope("the-internet.herokuapp.com",80),
			new UsernamePasswordCredentials("admin", "admin"));
			
	
	CloseableHttpClient  httpCleint=HttpClients.custom().setDefaultCredentialsProvider(creds).build();

  HttpGet httpGetRequest=new HttpGet("http://the-internet.herokuapp.com/basic-auth");
  CloseableHttpResponse httpResponse =null;
  try {
	  httpResponse = httpCleint.execute(httpGetRequest);
} catch (ClientProtocolException e) {
		e.printStackTrace();
} catch (IOException e) {
	  e.printStackTrace();
}
  
  System.out.println(httpResponse.getStatusLine().getStatusCode());
  
  	try {
		System.out.println(EntityUtils.toString(httpResponse.getEntity()));
	} catch (ParseException e) {
		e.printStackTrace();
	} catch (IOException e) {
			e.printStackTrace();
	}
}

}
