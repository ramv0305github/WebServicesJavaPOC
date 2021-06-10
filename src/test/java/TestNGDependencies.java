import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDependencies
{
	@Test(priority=1)	
	public void setup()
	{
		System.out.println("Configure TestNG and create user");
		Assert.fail("user not registered");
		
	}
	
	@Test(priority=2,dependsOnMethods="setup",alwaysRun=true)
	public void OpenBrowser()
	{
		System.out.println("Open Edge browser");
		
	}  
	 
}
