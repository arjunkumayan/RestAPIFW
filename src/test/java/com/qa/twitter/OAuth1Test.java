package com.qa.twitter;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OAuth1Test {

	
	@Test
	public void postATweetTest()
	{
	
		
		
		RequestSpecification  request = RestAssured
				.given()
				.auth()
				.oauth("whrXx6BAsx8AZom7oT4aT3EaY", "5dvffdYPrKXcJzUmBOK8EJF1jDfNZUQGnJoS9lIeou1dOHdF6S", "942322901998379008-py7k7cwJzM8SpraL4lqKeNE9xy9tCrr", "ZRKEeTmLIJrXhmrBw4hj72pcv0SJBdwXRE9z4ekdGrbPa");
		
		Response response=request.post("https://api.twitter.com/1.1/statuses/update.json?status=hello this is my third tweet on twitter account");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		
	}
	
	@Test
	public void retweetATweetTest()
	{
	RequestSpecification  request = RestAssured
				.given()
				.auth()
				.oauth("whrXx6BAsx8AZom7oT4aT3EaY", "5dvffdYPrKXcJzUmBOK8EJF1jDfNZUQGnJoS9lIeou1dOHdF6S", "942322901998379008-py7k7cwJzM8SpraL4lqKeNE9xy9tCrr", "ZRKEeTmLIJrXhmrBw4hj72pcv0SJBdwXRE9z4ekdGrbPa");
		
		Response response=request.get("https://api.twitter.com/1.1/statuses/retweets/1246013305275080705.json");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		
	}
	
}
