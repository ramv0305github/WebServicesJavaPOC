import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserConfig 
{
	public static void main(String[] args)
	{
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\ramkumar.viswanathan\\OneDrive - HCL Technologies Ltd\\Desktop\\Resume\\Personal Info\\Selenium\\Edge driver\\msedgedriver.exe");
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("http://way2automation.com");
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println(title.length());
		driver.quit();	
	
	}
	
	}



