//import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//import org.testng.asserts.SoftAssert;

public class TestNGAssertions 
{
	
	@BeforeSuite
	public void first()
	{
		System.out.println("This is the first method"); 
	}
	
	@AfterSuite
	public void Last()
	{
		System.out.println("This is the last method");
	}
	
	@Test
	public void skipTest()
	{
		throw new SkipException("Skipping test"); 
		
	}
	@Test(priority=1,groups="functional")  
	public void validateTitles()
	{
		String expectedTitle = "Google.com";
		String actualTitle  = "Google.com";	
		
		/*
		 * if(expectedTitle.equals(actualTitle)) System.out.println("Test case pass");
		 * else System.out.println("Test case fail");
		 */
          
		//Assert.assertEquals(expectedTitle, actualTitle);
		
		// Assert.fail("Failing as condition is not met"); 
		
		System.out.println("Checking pre conditions");
          
		//Assert.assertEquals(expectedTitle, actualTitle);
		
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Checking post conditions");
		softassert.assertAll();
						 
	} 
	 
} 
