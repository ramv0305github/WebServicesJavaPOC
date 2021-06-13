import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class FindingTestElements {
	
	

	
	 public static void main(String[] args) {
	  WebDriverManager.edgedriver().setup(); WebDriver driver = new EdgeDriver();
	  driver.get("http://google.com"); driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //WebDriverWait wait = new WebDriverWait(driver, 5); String title =
	  driver.getTitle(); 
	  //System.out.println(title);
	 // System.out.println(title.length());
	  driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).
	  sendKeys("selenium"); driver.quit();
	   

}
}

