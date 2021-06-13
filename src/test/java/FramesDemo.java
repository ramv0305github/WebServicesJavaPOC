import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesDemo 
{

	public static void main(String[] args) 
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_form_submit");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//*[@id=\"myForm\"]/input[3]")).click();
		driver.switchTo().defaultContent();
		List <WebElement> frames =  driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for(WebElement frame : frames)
		{
			System.out.println(frame.getAttribute("id"));
			System.out.println("Done");  
		}
	} 
}
