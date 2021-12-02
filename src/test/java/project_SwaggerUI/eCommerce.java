package project_SwaggerUI;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class eCommerce {
	public static String baseurl = "http://rest-api.upskills.in/";
	public String basicToken = "Basic dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9jbGllbnQ6dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9zZWNyZXQ=";
	
	@Test
	public void Token()
	{
		RestAssured.baseURI = baseurl;
		Response response = given().param(basicToken)
		.when()
		.post("api/rest_admin/oauth2/token/client_credentials/")
		.then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
		.extract().response();
		
		String jsonresponse = response.asString();
		//JsonPath responsebody = new JsonPath(jsonresponse);
		System.out.println(jsonresponse);
	}

}
