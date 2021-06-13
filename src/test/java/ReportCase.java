import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ReportCase
{

	public  void doLogin() 
	{
		
		System.out.println("Executing Login Test");
		
	}
	
	public void doUserReg() 
	{

	System.out.println("Reg Passed");
	}
	
	public void isSkip() {

		System.out.println("Skipping the test case");
	}
	
	
	public static void main(String[] args) 
	{
		ReportCase rc = new ReportCase();
		ExtentHtmlReporter  htmlReporter = new ExtentHtmlReporter("C:\\Users\\ramkumar.viswanathan\\git\\WebServicesJava\\SeleniumTesting\\reports\\extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("W2A Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.DARK);
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Rest Assured POC", "Rest Team");
		extent.setSystemInfo("Organization", "Batch 1");
		extent.setSystemInfo("Build No", "W2A-1234");
		//extent.createTest("Login Test");
		rc.doLogin();
		//extent.createTest("doUserReg");
		rc.doUserReg();
		//extent.createTest("isSkip");
		rc.isSkip();
		extent.flush();
		System.out.println("Report Generated");
			
	} 

}
