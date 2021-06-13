package com.api.googleAPI;

import com.api.excelReader.ExcelReader;
import com.api.report.ExtentReport;
import com.api.utilities.RestServiceHelper;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class DeletePlace {

	public static void execute(int i) throws Exception {

		RestServiceHelper restserviceHelper=new RestServiceHelper();
		String baseURL="https://rahulshettyacademy.com";
		restserviceHelper.initiateRequest();
		restserviceHelper.setbaseURI(baseURL);
		RestAssured.baseURI ="https://rahulshettyacademy.com"; 
		Response response; 
		int statusCode; 
		String status;
		baseURL="https://rahulshettyacademy.com"; 
		//ExtentReport.report();
		ExtentReport.startTest("Delete Place in Google API");
		restserviceHelper.initiateRequest();
		restserviceHelper.setQueryparam("key","qaclick123");
		restserviceHelper.setHeader("Content-Type","application/json");
		restserviceHelper.generatePostBodyFromJSONObject(Payload.payloadDelete());
		response=restserviceHelper.setDeleteResourse("/maps/api/place/delete/json/");
		restserviceHelper.checkResponse(response);
		JsonPath js=restserviceHelper.getResponse(response);
		status=js.getString("status");
		statusCode=restserviceHelper.getStatusCode(response); 
		ExcelReader.setValue(i,"ActualStatusCode",String.valueOf(statusCode) );
		ExcelReader.setValue(i, "Response","Status:"+status);
		String actualStatusCode=String.valueOf(statusCode);
		if(actualStatusCode.equalsIgnoreCase("200"))
		{
			ExcelReader.setValue(i,"ExecutionStatus","PASS"); 
			ExtentReport.statusPass(LogStatus.PASS, "Status code:"+statusCode+"  "+"Place has been deleted from Google API");
			ExtentReport.statusPass(LogStatus.PASS,restserviceHelper.getResponseAsString(response));
		} 
		else {
			ExcelReader.setValue(i,"ExecutionStatus","FAIL");
			ExtentReport.statusFail(LogStatus.FAIL, "Status code:"+statusCode);
			ExtentReport.statusFail(LogStatus.PASS,restserviceHelper.getResponseAsString(response));
		}

	}

}
