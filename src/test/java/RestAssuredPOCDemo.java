import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
 
public class RestAssuredPOCDemo 
{

	public void AddPlaceAPI()
	{
		System.out.println("Add Place API");
	}
	
	public void UpdatePlaceAPI()
	{
		System.out.println("Update Place API");
	}
	
	public void UpdateGetAPI()
	{
		System.out.println("UpdateGet Place API");
	}
	
	
	public void DeletePlaceAPI()
	{
		System.out.println("Delete Place API");
	}
	
	public void DeleteGetAPI()
	{
		System.out.println("DeleteGet API");
	}
	
	public static void main(String[] args)  
	{
		// Validate if Add Place API is working fine
		// Given - All Input details  
		// when - resource and http methods 
		// then - validate
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
		
		RestAssuredPOCDemo rapidtest = new RestAssuredPOCDemo();
		
		BasicConfigurator.configure();
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(payload.AddPlace()).when().post("/maps/api/place/add/json").then().log().all().statusCode(200)
				.body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)").extract().response()
				.asString();
		System.out.println(response);
		JsonPath js = new JsonPath(response); // for parsing json
		String placeId = js.getString("place_id");
		System.out.println(placeId);
		Logger log = Logger.getLogger("devpinoyLogger");
		ExcelReader excel = new ExcelReader("C:\\filewriting\\ExcelReader\\TestData.xlsx");
		String sheetName = "Trainer";
		log.debug("Entering the data");
		excel.setCellData(sheetName, "Actual Status Code", 2, "200");
		excel.setCellData(sheetName, "Placeid", 2, placeId); 
		excel.setCellData(sheetName, "ExecutionStatus", 2, "PASS");
		extent.createTest("Add Place API");
		rapidtest.AddPlaceAPI();
		System.out.println("File and Report updated");
				
		// Update Place
		String newAddress = "DownTown, Denver"; 

		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body("{\r\n" + "\"place_id\":\"" + placeId + "\",\r\n" + "\"address\":\"" + newAddress + "\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}")
				.when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200)
				.body("msg", equalTo("Address successfully updated"));
		
		excel.setCellData(sheetName, "Actual Status Code", 3, "200");
		excel.setCellData(sheetName, "Placeid", 3, placeId); 
		excel.setCellData(sheetName, "ExecutionStatus", 3, "PASS");
		extent.createTest("UpdatePlace API");
		rapidtest.UpdatePlaceAPI();
		System.out.println("File and report updated");
			
		// Get Place
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
				.when().get("maps/api/place/get/json").then().assertThat().log().all().statusCode(200).extract()
				.response().asString();
		JsonPath js1 = ReUsableMethods.rawToJson(getPlaceResponse);
		// JsonPath js1= new JsonPath(getPlaceResponse);
		String actualAddress = js1.getString("address");
		System.out.println(actualAddress);
		// Assert.assertEquals(actualAddress, newAddress);
		
		excel.setCellData(sheetName, "Actual Status Code", 4, "200");
		excel.setCellData(sheetName, "Placeid", 4, placeId); 
		excel.setCellData(sheetName, "ExecutionStatus", 4, "PASS");
		extent.createTest("GetPlace API");
		rapidtest.UpdateGetAPI();
		System.out.println("File and report updated");
		

		// Delete place
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body("{\r\n" + "\r\n" + "\"place_id\":\"" + placeId + "\"\r\n" + "}").when()
				.delete("/maps/api/place/delete/json?key=qaclick123").then().assertThat().log().all().statusCode(200)
				.body("status", equalTo("OK")); 
		
		excel.setCellData(sheetName, "Actual Status Code", 5, "200");
		excel.setCellData(sheetName, "Placeid", 5, placeId); 
		excel.setCellData(sheetName, "ExecutionStatus", 5, "PASS");
		extent.createTest("DeletePlace API");
		rapidtest.DeletePlaceAPI();
		System.out.println("File and report updated");
		
		// get place for delete verification
		given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId).when()
				.get("maps/api/place/get/json").then().assertThat().log().all().statusCode(404)
				.body("msg", equalTo("Get operation failed, looks like place_id  doesn't exists"));
		
		excel.setCellData(sheetName, "Actual Status Code", 6, "404");
		excel.setCellData(sheetName, "Placeid", 6, "Get operation failed, looks like place_id  doesn't exists"); 
		excel.setCellData(sheetName, "ExecutionStatus", 6, "PASS");
		extent.createTest("GetPlace API");
		rapidtest.DeleteGetAPI();
		System.out.println("File and report updated");
		extent.flush();
	}  
} 
