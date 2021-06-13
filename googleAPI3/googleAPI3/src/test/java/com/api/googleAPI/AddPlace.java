package com.api.googleAPI;

import com.api.excelReader.ExcelReader;
import com.api.report.ExtentReport;
import com.api.utilities.RestServiceHelper;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * 
 * @author karthika_thiru
 *
 */
public class AddPlace {

	static String placeId;
	public static void execute(int i) throws Exception {
		RestServiceHelper restserviceHelper=new RestServiceHelper();
		Response response;
		int statusCode;
		String baseURL="https://rahulshettyacademy.com";
		ExtentReport.startTest("Add Place in Google API");
		restserviceHelper.initiateRequest();
		restserviceHelper.setbaseURI(baseURL);
		restserviceHelper.setQueryparam("key", "qaclick123");
		restserviceHelper.setHeader("Content-Type","application/json");
		restserviceHelper.generatePostBodyFromJSONObject(Payload.payloadAdd());
		response=restserviceHelper.setPostResourse("/maps/api/place/add/json");
		restserviceHelper.checkResponse(response);
		JsonPath js=restserviceHelper.getResponse(response);
		placeId = js.getString("place_id");
		//System.out.println(placeId);
		statusCode=restserviceHelper.getStatusCode(response);
		ExcelReader.setValue(i, "ActualStatusCode",String.valueOf(statusCode) );
		ExcelReader.setValue(i, "Response","PlaceId:"+placeId );
		String actualStatusCode=String.valueOf(statusCode);
		if(actualStatusCode.equalsIgnoreCase("200"))
		{
			ExcelReader.setValue(i, "ExecutionStatus","PASS");
			ExtentReport.statusPass(LogStatus.PASS, "Status code:"+statusCode+"  "+"Place has been added into Google API");
			ExtentReport.statusPass(LogStatus.PASS,restserviceHelper.getResponseAsString(response));

		}
		else {
			ExcelReader.setValue(i, "ExecutionStatus","FAIL");
			ExtentReport.statusFail(LogStatus.FAIL, "Status code:"+statusCode);
			ExtentReport.statusFail(LogStatus.FAIL,restserviceHelper.getResponseAsString(response));
		}

	}

}


