package APITest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo3 {
	
	@BeforeTest
	public void BT()
	{
		System.out.println("before test this will execute");
	}
	
	@AfterTest
	public void AT()
	{
		System.out.println("After test this will execute");
	}
	
	@Test
	public void testcase1()
	{
		System.out.println("This is my only testcase !");
	}

}
