package com.api.googleAPI;

import com.api.excelReader.ExcelReader;
import com.api.utilities.RestServiceHelper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetPlace {


	public static void execute(int i) throws Exception {
		// TODO Auto-generated method stub
		RestServiceHelper restserviceHelper=new RestServiceHelper();
		Response response;
		int statusCode;
		String baseURL="https://rahulshettyacademy.com";
		restserviceHelper.initiateRequest();
		restserviceHelper.setbaseURI(baseURL);
		restserviceHelper.setQueryparam("key", "qaclick123");
		restserviceHelper.setQueryparam("place_id",AddPlace.placeId);
		response=restserviceHelper.setGetResourse("/maps/api/place/get/json");
		restserviceHelper.checkStatusCodeIs200(response);
		JsonPath js=restserviceHelper.getResponse(response);
		statusCode=restserviceHelper.getStatusCode(response);
		ExcelReader.setValue(i, "ActualStatusCode",String.valueOf(statusCode) );
		String actualStatusCode=String.valueOf(statusCode);
		if(actualStatusCode.equalsIgnoreCase("200"))
		{
			ExcelReader.setValue(i, "Response","Address:"+js.getString("address"));
			ExcelReader.setValue(i, "ExecutionStatus","PASS");
		}
		else
		{
			ExcelReader.setValue(i, "Response","Msg:"+js.getString("msg"));
			ExcelReader.setValue(i, "ExecutionStatus","FAIL");

		}

	}

}
