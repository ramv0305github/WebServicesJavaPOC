import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGCase1 
{

@Test(priority=4)	
public void doLogin() 
{
	System.out.println("Login Test ");
}

@Test(priority=3)
public void doUserReg() 
{
	System.out.println("Do user Registration");
}

@Test(priority=2)
public void OpenBrowser()
{
	System.out.println("Open Edge browser");
	
}
@Test(priority=1)	
public void setup()
{
	System.out.println("Configure TestNG");
	
}
@Test(priority=5)	
public void shutdown()
{
	System.out.println("Close the browsers");
}

@BeforeTest()
public void InitSetup()
{
	System.out.println("Configure and setup java");
}
@AfterTest()
public void jarSetup()
{
	System.out.println("Configure and setup a jar file");
}
{
	
}

}
