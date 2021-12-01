package APITest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Demo2 {
	
	@BeforeClass
	public void BC()
	{
		System.out.println("this is before class method");
	}
	
	@BeforeMethod
	public void BM()
	{
		System.out.println("3. This will execute before the method");
	}
	
	@Test
	public void TST()
	{
		System.out.println("4. All test cases are executing");
		
	}
	
	
	@AfterMethod
	public void AM()
	{
		System.out.println("5. This will execute after the method");
	}
	@AfterTest
	public void AT()
	{
		System.out.println("6. This will execute after all the test");
	}
	
	@AfterSuite
	public void AS()
	{
		System.out.println("7. this will execute at the end");
	}

}
