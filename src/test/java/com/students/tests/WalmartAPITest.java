package com.students.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*; 
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.testng.Assert.assertTrue;
import static io.restassured.path.xml.XmlPath.*;
import static io.restassured.RestAssured.*; 
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.assertion.BodyMatcher.fallbackToResponseBodyIfContentParserIsNull;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
public class WalmartAPITest {
	
	/** Please hit this defaults to understand the requirements
	 * RestAssured.baseURI="https://api.walmartlabs.com";
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "json");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
		Response response = given().queryParams(queryParam)
		.when()
		.get("/v1/search");
	 * 
	 * 
	 * 
	 */
	
	
	@Test
	public void getTheResponseAndValidate()
	{
		
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "json");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
		RestAssured.baseURI="https://api.walmartlabs.com";
		
		//RequestSpecification request = RestAssured.given().log().all();
		//request.queryParams(queryParam);
		
		//Response response = request.get("/v1/search");
		
		//System.out.println(response.prettyPrint());
		
		String name =  given().queryParams(queryParam)
		.when()
		.get("/v1/search")
		.then().extract().path("items[0].name");
		
		System.out.println("name:   "+name);
		
		
		
	}
	@Test
	public void getTheResponseAndValidate1()
	{
		
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "json");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
		RestAssured.baseURI="https://api.walmartlabs.com";
		
		//RequestSpecification request = RestAssured.given().log().all();
		//request.queryParams(queryParam);
		
		//Response response = request.get("/v1/search");
		
		//System.out.println(response.prettyPrint());
		
		String name =  given().queryParams(queryParam)
		.when()
		.get("/v1/search").getBody().toString();
	
		
		System.out.println("name:   "+name);
		
		
		
	}
	
	@Test
	public void getTheResponseAndStoreToHashMap()
	{
		
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "json");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
		RestAssured.baseURI="https://api.walmartlabs.com";
		
		//RequestSpecification request = RestAssured.given().log().all();
		//request.queryParams(queryParam);
		
		//Response response = request.get("/v1/search");
		
		//System.out.println(response.prettyPrint());
		
		HashMap<String, String > giftoptions =  given().queryParams(queryParam)
		.when()
		.get("/v1/search")
		.then().extract().path("items[0].giftOptions");
		
		System.out.println("giftoptions:   "+giftoptions);
		
		
		
	}
	
	// Extract the size from the array
	@Test
	public void getTheSizeOfTheArray()
	{
		
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "json");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
		RestAssured.baseURI="https://api.walmartlabs.com";
		
		//RequestSpecification request = RestAssured.given().log().all();
		//request.queryParams(queryParam);
		
		//Response response = request.get("/v1/search");
		
		//System.out.println(response.prettyPrint());
		
		int size = given().queryParams(queryParam)
		.when()
		.get("/v1/search")
		.then().extract().path("items.size()");
		
		System.out.println("Size of the item:   "+size);
		
		
		
	}
	
	@Test
	public void testdd()
	{
		String s1="Apple iPod Touch 16GB A1421 - Space Gray (Refurbished) (5th Generation), Refurbished Apple iPod Touch 5th gen 16GB WiFi MP3 MP4 Digital Music Video Player MGG82LL, Refurbished Apple iPod Touch 16GB MGG82LLA - Space Gray (5th generation), Apple iPod touch 6th Generation 128GB - Space Gray (Previous Model), Apple iPod Nano 7th Generation 16GB Silver, (Latest Model) New in Plain White Box MKN22LL/A, Apple iPod touch 7th Generation 32GB - Space Gray (New Model), Apple iPod touch 7th Generation 128GB - Gold (New Model), Apple iPod touch 7th Generation 256GB - PRODUCT(RED) (New Model), Apple iPod Touch 6th Generation 32GB Blue, Like New in Plain White Box, Apple iPod Nano 8th Generation 16GB Space Gray , Like New in Retail Packaging";
		String s2="Apple iPod Touch 16GB A1421 - Space Gray (Refurbished) (5th Generation), Refurbished Apple iPod Touch 5th gen 16GB WiFi MP3 MP4 Digital Music Video Player MGG82LL/A, Refurbished Apple iPod Touch 16GB MGG82LLA - Space Gray (5th generation), Apple iPod touch 6th Generation 128GB - Space Gray (Previous Model), Apple iPod Nano 7th Generation 16GB Silver, (Latest Model) New in Plain White Box MKN22LL/A, Apple iPod touch 7th Generation 32GB - Space Gray (New Model), Apple iPod touch 7th Generation 128GB - Gold (New Model), Apple iPod touch 7th Generation 256GB - PRODUCT(RED) (New Model), Apple iPod Touch 6th Generation 32GB Blue, Like New in Plain White Box, Apple iPod Nano 8th Generation 16GB Space Gray , Like New in Retail Packaging]";
	if(s1.equalsIgnoreCase(s2))
	{
		System.out.println("correct");
	}
	else
		System.out.println("fail");
	
	
	}
	
	
	// code is fine the only thing is the extract method with path name not returning the correct name back - /la
	@Test
	public void getallTheNameFromTheArray()
	{
		
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "json");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
		RestAssured.baseURI="https://api.walmartlabs.com";
		
		//RequestSpecification request = RestAssured.given().log().all();
		//request.queryParams(queryParam);
		
		//Response response = request.get("/v1/search");
		
		//System.out.println(response.prettyPrint());
		
		ArrayList<String> nameList = given().queryParams(queryParam)
		.when()
		.get("/v1/search")
		.then().extract().path("items.name");
		
		System.out.println("Actual: "+nameList);
		
		Iterator<String> itr= nameList.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}System.out.println("Size of the item:   "+nameList);
		
		
		ArrayList<String> expectedList = new ArrayList<String>();
		
		expectedList.add("Apple iPod Touch 16GB A1421 - Space Gray (Refurbished) (5th Generation)");
		expectedList.add("Refurbished Apple iPod Touch 5th gen 16GB WiFi MP3 MP4 Digital Music Video Player MGG82LL");
		expectedList.add("Refurbished Apple iPod Touch 16GB MGG82LLA - Space Gray (5th generation)");
		expectedList.add("Apple iPod touch 6th Generation 128GB - Space Gray (Previous Model)");
		expectedList.add("Apple iPod Nano 7th Generation 16GB Silver, (Latest Model) New in Plain White Box MKN22LL/A");
		expectedList.add("Apple iPod touch 7th Generation 32GB - Space Gray (New Model)");
		expectedList.add("Apple iPod touch 7th Generation 128GB - Gold (New Model)");
		expectedList.add("Apple iPod touch 7th Generation 256GB - PRODUCT(RED) (New Model)");
		expectedList.add("Apple iPod Touch 6th Generation 32GB Blue, Like New in Plain White Box");
		expectedList.add("Apple iPod Nano 8th Generation 16GB Space Gray , Like New in Retail Packaging");
		
		System.out.println("Expected: "+expectedList );
		assertTrue(nameList.equals(expectedList));
		
	}
	
	// Extract the all value where name is = Apple iPod touch 7th Generation 128GB - Gold (New Model)
	// this is like follow the json response
	
			
	
	@Test
	public void getTheAllDetailsWithFilter()
	{
		RestAssured.baseURI="https://api.walmartlabs.com";
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "json");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
	List<HashMap<String,Object>> values =given().queryParams(queryParam)
		.when()
		.get("/v1/search")
		.then().extract().path("items.findAll{it.name=='Apple iPod touch 7th Generation 256GB - PRODUCT(RED) (New Model)'}");
	
	// this will extract the values which have name as = given above
	System.out.println("Values: "+values);
	
	
	
	}
	
	@Test
	public void getTheItemsFromList()
	{
		RestAssured.baseURI="https://api.walmartlabs.com";
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "json");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
		Response response = given().queryParams(queryParam)
		.when()
		.get("/v1/search");
		List<Object> itemIDList = response.path("items.itemId");
		System.out.println(itemIDList);
	}
	
	@Test
	public void getTheItemsForTheSpecific()
	{
		RestAssured.baseURI="https://api.walmartlabs.com";
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "json");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
		Response response = given().queryParams(queryParam)
		.when()
		.get("/v1/search");
		List<Object> itemForAllList = response.path("items.findAll{it.name=='Apple iPod touch 7th Generation 256GB - PRODUCT(RED) (New Model)'}.salePrice");
		System.out.println(itemForAllList);
	}
	
	@Test
	public void getAllTheSalePrice()
	{
		RestAssured.baseURI="https://api.walmartlabs.com";
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "json");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
		Response response = given().queryParams(queryParam)
		.when()
		.get("/v1/search");
		List<String> salePriceList = response.path("items.findAll{it.salePrice<150}.name");
		System.out.println(salePriceList);
		
		// it will give you the name which has sale price list
	}
	
	
	// name starts with REf
	@Test
	public void getTheMapwhereNameStartsWithRef()
	{
		RestAssured.baseURI="https://api.walmartlabs.com";
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "json");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
		Response response = given().queryParams(queryParam)
		.when()
		.get("/v1/search");
		List<String> msrpValue = response.path("items.findAll{it.name==~/Ref.*/}.msrp");
		System.out.println(msrpValue);
		
		// it will give you the name which has sale price list
	}
	
	
	// name ends with ed
	@Test
	public void getTheSalePriceWhereNameEndsWithed()
	{
		RestAssured.baseURI="https://api.walmartlabs.com";
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "json");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
		Response response = given().queryParams(queryParam)
		.when()
		.get("/v1/search");
		List<String> msrpValue = response.path("items.findAll{it.name==~/.*ed/}.salePrice");
		System.out.println(msrpValue);
		
		// it will give you the name which has sale price list
	}
	
	//  -----------------XML----------------------------------------
	
	// get the response in XML
	@Test
	public void getTheResponseInXML()
	{
		RestAssured.baseURI="https://api.walmartlabs.com";
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "xml");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
		String body = given().queryParams(queryParam)
		.when()
		.get("/v1/search").prettyPrint();
		
		System.out.println(body);
		
		}
	
	@Test
	public void getTheNumItems()
	{
		RestAssured.baseURI="https://api.walmartlabs.com";
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "xml");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
		String items = given().queryParams(queryParam)
		.when()
		.get("/v1/search").then().extract().path("searchresponse.numItems");
		
		System.out.println(items);
		
		}

	
	@Test
	public void getTheproductNameFromItems()
	{
		RestAssured.baseURI="https://api.walmartlabs.com";
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "xml");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
		String productName = given().queryParams(queryParam)
		.when()
		.get("/v1/search").then().extract().path("searchresponse.items.item[0].name");
		
		System.out.println(productName);
		
		}

	@Test
	public void getTheGiftOptionsFromXMLPath() {
		RestAssured.baseURI="https://api.walmartlabs.com";
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "xml");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
		String xml = given().queryParams(queryParam)
		.when()
		.get("/v1/search").asString();
		
		String giftOptions = with(xml).getString("searchresponse.items.item[1].giftOptions");
		
		System.out.println(giftOptions);
		}
	
	@Test
	public void getTheSizeOfItem() {
		RestAssured.baseURI="https://api.walmartlabs.com";
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "xml");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
		NodeChildrenImpl val = given().queryParams(queryParam)
		.when()
		.get("/v1/search").then().extract().path("searchresponse.items.item");
		
		System.out.println("size of items: "+val.size());
	}
	
	@Test
	public void getExtractAllName() {
		RestAssured.baseURI="https://api.walmartlabs.com";
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "xml");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
		String xml= given().queryParams(queryParam)
		.when()
		.get("/v1/search").asString();
		
		List<String> nameList  = with(xml).getList("searchresponse.items.item.name");
		
		System.out.println(nameList);
		}
	
	// get the sale price where name = Apple ipod
	@Test
	public void getExtract() {
		RestAssured.baseURI="https://api.walmartlabs.com";
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "xml");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
		String xml= given().queryParams(queryParam)
		.when()
		.get("/v1/search").asString();
		
		List<String> salePriceList  = with(xml).getList("searchresponse.items.item.findAll{it.name=='pple iPod touch 7th Generation 256GB - PRODUCT(RED) (New Model)'}.salePrice");
		
		System.out.println(salePriceList);
		}
	
	// deep serach in xml path
	@Test
	public void getAlltheSalePrice() {
		RestAssured.baseURI="https://api.walmartlabs.com";
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "xml");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
		String xml= given().queryParams(queryParam)
		.when()
		.get("/v1/search").asString();
		
		List<String> salePriceList  = with(xml).getList("**.findAll{it.name=='pple iPod touch 7th Generation 256GB - PRODUCT(RED) (New Model)'}.salePrice");
		
		System.out.println(salePriceList);
		}
	
	
	//------------------------------------------------
	/// Hamcrest mathods
	
	//json
	@Test
	public void getTheITem() {
		RestAssured.baseURI="https://api.walmartlabs.com";
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "json");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
		int item= given().queryParams(queryParam)
		.when()
		.get("/v1/search").then().extract().path("numItems");

		
		System.out.println(item);
		
		}
	
	
	
	//Hamcrest equalTO methods
	@Test
	public void getTheITemAndVerify() {
		RestAssured.baseURI="https://api.walmartlabs.com";
		HashMap<String, String > queryParam = new HashMap<String,String>();
		queryParam.put("query", "ipod");
		queryParam.put("format", "json");
		queryParam.put("apiKey", "75e3u4sgb2khg673cbv2gjup");
		
		given().queryParams(queryParam)
		.when()
		.get("/v1/search").then().body("numItems", equalTo(10));

		
		
		}
}
