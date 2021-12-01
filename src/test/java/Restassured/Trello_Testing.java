package Restassured;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;



public class Trello_Testing {
	
	// https://api.trello.com/1/boards/{id}
	
	
	public static String baseurl = "https://api.trello.com";
	
	//Need to change this id to GET & DELETE the board
	public String id;
	public String url;
	
	
	
	@Test (priority = 0)
	public void createBoard()
	{
		RestAssured.baseURI = baseurl;
		// parameters,header,cookie
		
		Response response = (Response) given().contentType(ContentType.JSON)
		.queryParam("key", "e48b9c2f7a5612756cc98ee389dbd4f9")
		.queryParam("token","94a7abba38f610b7ac79eedbffed67dc057075b4e033921a0f5516e9e3dd236f")
		.queryParam("name", "new_Board23")
		
		.when()
		.post("1/boards/")

		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
		
		String jsonresponse = response.asString();
		System.out.println(jsonresponse);
		JsonPath responseBody = new JsonPath(jsonresponse);
		id = responseBody.get("id");
		System.out.println("this is id "+id);
		System.out.println("Board created succesfully !");
		
	}
	
	// GET Method
	@Test (priority = 1)
	public void getBoard()
	{
		RestAssured.baseURI = baseurl;
		
		Response response = given().param("key", "e48b9c2f7a5612756cc98ee389dbd4f9")
		.param("token","94a7abba38f610b7ac79eedbffed67dc057075b4e033921a0f5516e9e3dd236f")
		
		.when()
		.get("1/boards/" + id)
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
		
		String jsonresponse = response.asString();
		JsonPath responsebody = new JsonPath(jsonresponse);
		System.out.println("This is get board response "+responsebody);
		
	}

	
	// DELETE Method
	@Test (priority = 2)
	public void deleteBoard()
	{
		RestAssured.baseURI = baseurl;
		
		given().param("key", "e48b9c2f7a5612756cc98ee389dbd4f9")
		.param("token","94a7abba38f610b7ac79eedbffed67dc057075b4e033921a0f5516e9e3dd236f")
		
		.when()
		.delete("1/boards/"+id)
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON);
		System.out.println("Board deleted succesfully !");
		
	}

}
