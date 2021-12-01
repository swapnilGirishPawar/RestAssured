package APITest;
import org.testng.Assert;
import org.testng.annotations.*;


public class Demo_TestNG {
	
	@BeforeSuite
	public void BS()
	{
		System.out.println("1. This is going to execute before any test");
	}
	
	@BeforeTest
	public void BT()
	{
		System.out.println("2. This will run after test suite");
	}
	
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
		Assert.assertEquals("sunil", "sunil");
		
	}
}