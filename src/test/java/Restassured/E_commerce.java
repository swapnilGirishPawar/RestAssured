package Restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class E_commerce {
	
	public static String accessToken;
	public static String id;
	public static String baseurl = "https://ecommerceservice.herokuapp.com";
	public static int count;
	public String email1;
	public String finalid;
	public String requestBody = "{\r\n"
			+ "	\"email\": \"donotdeletethismail4@gmail.com\",\r\n"
			+ "	\"password\": \"donot@123\"\r\n"
			+ "}\r\n"
			+ "";
	
	@Test (priority = 0,enabled = false)
	public void signup()
	{
		RestAssured.baseURI = baseurl;
		
		
		
		// I want to know my response 
		Response response = given()
			.header("content-Type","application/json")
			.body(requestBody)
			
			.when()
			.post("user/signup")
			
			.then()
			.assertThat().statusCode(201).and().contentType(ContentType.JSON)
			.extract().response();
		
		// output format is in string format need to convert into json to read it then use jsonpath.
		
		String jsonresponse = response.asString();
		JsonPath responsebody = new JsonPath(jsonresponse);
		System.out.println(responsebody.get("message"));	
	}
	
	@Test (priority = 1)
	public void login()
	{
		RestAssured.baseURI = baseurl;
		
		String requestBody = "{\r\n"
				+ "	\"email\": \"donotdeletethismail4@gmail.com\",\r\n"
				+ "	\"password\": \"donot@123\"\r\n"
				+ "}\r\n"
				+ "";
		
		Response response = given()
				.header("content-Type","application/json")
				.body(requestBody)
				
				.when()
				.post("user/login")
				
				.then()
				.assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.extract().response();
		
		String jsonresponse = response.asString();
		JsonPath responsebody = new JsonPath(jsonresponse);
		System.out.println(responsebody.get("accessToken"));
		accessToken = responsebody.get("accessToken");
		
	}
	
	@Test (priority = 2)
	public void getusers()
	{
		RestAssured.baseURI = baseurl;
		
		Response response = given()
				.header("content-Type","application/json")
				.header("Authorization","bearer "+accessToken)
				
				.when()
				.get("/user")
				
				.then()
				.assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.extract().response();
		
		String jsonresponse = response.asString();
		JsonPath responsebody = new JsonPath(jsonresponse);
//		count = responsebody.get("count");
//		email1 = requestBody.substring(14,44); // Wrong approach...
//		System.out.println("this is output of email "+email1);
//		 
//		for (int i=0; i<=count; i++)
//		{
//			if (responsebody.get("users[i].email") == email1)
//			{
//				finalid = responsebody.get("users[i]._id");
//			}
//		}
//		System.out.println(finalid);
		System.out.println(responsebody.get("users[145]._id"));
		id = responsebody.get("users[145]._id");
	}
	
	@Test (priority = 3)
	public void delete()
	{
		RestAssured.baseURI = baseurl;
		
		Response response = given()
				.header("content-Type","application/json")
				.header("Authorization","bearer "+accessToken)
				
				.when()
				.delete("/user/"+id)
				
				.then()
				.assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.extract().response();
		
		String jsonresponse = response.asString();
		JsonPath responsebody = new JsonPath(jsonresponse);
		System.out.println(responsebody.get("message"));
	}
}
