package Restassured;

import org.testng.annotations.*;
import io.restassured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class Practice {
	// Initialising variables
	public static String baseurl = "";
	
	
	
	@BeforeTest
	public void BT()
	{
		System.out.println("Hey this is the msg is going to print before executing testcases");
	}
	
	@AfterTest
	public void AT()
	{
		System.out.println("Hey this is the msg is going to print after executing testcases");
	}
	
	// test cases as follows
	
	@Test
	public void testcase()
	{
		RestAssured.baseURI = baseurl;
		
		
	}
	
}
