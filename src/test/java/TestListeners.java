import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestListeners {

	public static void main(String[] args) 
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		EventFiringWebDriver driver1 = new EventFiringWebDriver(driver);
		WebListeners listener = new WebListeners();
		driver1.register(listener);
		driver1.get("https://www.rediff.com/");
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver1.findElement(By.xpath("//*[@id=\"signin_info\"]/a[2]")).click(); 

	}

}
