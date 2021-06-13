package com.api.googleAPI;

import com.api.excelReader.ExcelReader;
import com.api.report.ExtentReport;
import com.api.utilities.RestServiceHelper;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdatePlace {

	public static void execute(int i) throws Exception {
		RestServiceHelper restserviceHelper=new RestServiceHelper();
		Response response;
		int statusCode;
		String msg;
		//ExtentReport.report();
		ExtentReport.startTest("Update Place in Google API");
		String baseURL="https://rahulshettyacademy.com";
		restserviceHelper.initiateRequest();
		restserviceHelper.setbaseURI(baseURL);
		restserviceHelper.setQueryparam("key", "qaclick123");
		restserviceHelper.setHeader("Content-Type","application/json");
		restserviceHelper.generatePostBodyFromJSONObject(Payload.payloadUpdate());
		response=restserviceHelper.setPutResourse("/maps/api/place/update/json");
		restserviceHelper.checkResponse(response);
		JsonPath js=restserviceHelper.getResponse(response);
		msg=js.getString("msg");
		statusCode=restserviceHelper.getStatusCode(response);
		ExcelReader.setValue(i, "ActualStatusCode",String.valueOf(statusCode) );
		ExcelReader.setValue(i, "Response","Msg:"+msg);
		String actualStatusCode=String.valueOf(statusCode);
		if(actualStatusCode.equalsIgnoreCase("200"))
		{
			ExcelReader.setValue(i, "ExecutionStatus","PASS");
			ExtentReport.statusPass(LogStatus.PASS, "Status code:"+statusCode+"  "+"Updated the Place into Google API");
			ExtentReport.statusPass(LogStatus.PASS,restserviceHelper.getResponseAsString(response));
		}
		else {
			ExcelReader.setValue(i, "ExecutionStatus","FAIL");
			ExtentReport.statusFail(LogStatus.FAIL, "Status code:"+statusCode);
			ExtentReport.statusFail(LogStatus.PASS,restserviceHelper.getResponseAsString(response));
		}


	}

}
