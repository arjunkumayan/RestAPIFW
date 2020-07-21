package com.booking.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.test.HTTPStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookingAPITest extends BookingDates {
	
	@Test
	public void doBookingTest()
	{
		String bookingJSON=null;
		RestAssured.baseURI="https://restful-booker.herokuapp.com/";
		
		RequestSpecification request=RestAssured.given().log().all();
		
		request.contentType("application/json");
		
		BookingDates bd=new BookingDates("2020-02-05","2020-04-12");
		Booking booking=new Booking("Priyankdd", "manddav", 1997, true, "WIFI and desktop", bd);
		
		ObjectMapper mapper=new ObjectMapper();
		
	
		
		try {
			bookingJSON=mapper.writeValueAsString(booking);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println(bookingJSON);
		
		request.body(bookingJSON);
		
		Response response=request.post("/booking");
		
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
		
		
		Assert.assertEquals(response.getStatusCode(), HTTPStatus.HTTP_Status_code_200);
		
		JsonPath json=response.jsonPath();
		
		int bookingID=json.get("bookingid");
		System.out.println(bookingID);
		
		String firstName=json.get("booking.firstname");
		System.out.println(firstName);
	
		Assert.assertNotNull(bookingID);
		
		Assert.assertEquals(json.get("booking.firstname"), booking.getFirstname());
		Assert.assertEquals(json.get("booking.lastname"), booking.getLastname());
		Assert.assertEquals(json.get("booking.totalprice"), booking.getTotalprice());
		Assert.assertEquals(json.get("booking.additionalneeds"), booking.getAdditionalneeds());
		Assert.assertEquals(json.get("booking.depositpaid"), booking.isDepositpaid());
		
		
		System.out.println(bd.getCheckin());
		System.out.println(bd.getCheckout());
		
		Assert.assertEquals(json.get("booking.bookingdates.checkin"),bd.getCheckin());
		
		Assert.assertEquals(json.get("booking.bookingdates.checkout"),bd.getCheckout());
		// complex validation

		Booking bking = response.as(Booking.class, ObjectMapperType.GSON);
		BookingDates  dates = bking.getBookingdates();
		Assert.assertEquals(dates.getCheckin(),"2020-02-05");
	
	}

}
