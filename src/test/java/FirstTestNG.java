import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestNG 
{

	@BeforeTest
	public void opening()
	{
		System.out.println("Do the opening setup");
	}
	@BeforeMethod
	public void launchBrowser()
	{
		System.out.println("Launch the browser");
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		System.out.println("Close the browser");
		
	}
		
	@Test(priority=1)
	public void setup()
	{
		System.out.println("setting up TestNG");
	}
	
	@AfterTest
	public void Closing()
	{
		System.out.println("Do the opening setup");
	}
	
}
