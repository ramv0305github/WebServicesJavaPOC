package com.api.utilities;


import org.springframework.util.Assert;

//import core.googleAPI.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestServiceHelper {

	private RequestSpecification requestSpecification;
	private Response response;
	public void initiateRequest()
	{
		requestSpecification=RestAssured.given().relaxedHTTPSValidation();
		requestSpecification.given().log().all();
	}

	public void setbaseURI(String uri)
	{
		requestSpecification.baseUri(uri);
	}

	public void setQueryparam(String key,String value)
	{
		requestSpecification.queryParam(key, value);
	}

	public void setPathparam(String key,String value)
	{
		requestSpecification.pathParam(key, value);
	}

	public void setHeader(String type,String value)
	{
		requestSpecification.header(type,value);

	}

	public  void generatePostBodyFromJSONObject(String payload)

	{
		requestSpecification.body(payload);

	}

	public Response setPostResourse(String uri)
	{
		return requestSpecification.when().post(uri);
	}

	public Response setGetResourse(String uri)
	{
		return requestSpecification.when().get(uri);
	}

	public Response setPutResourse(String uri)
	{
		return requestSpecification.when().put(uri);
	}
	
	public Response setDeleteResourse(String uri)
	{
		return requestSpecification.when().delete(uri);
	}


	public void checkStatusCodeIs200(Response response)
	{
		//System.out.println(response.then().log().all().assertThat().statusCode(200));
		System.out.println(response.then().log().all());

	}

	public int getStatusCode(Response response)
	{
		return response.getStatusCode();

	}

	public JsonPath getResponse(Response response)

	{
		JsonPath js=new JsonPath(response.then().extract().asString()); // for parsing json
		return js;

	}







}
