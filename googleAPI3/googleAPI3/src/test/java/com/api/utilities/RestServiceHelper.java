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

	/**
	 * Initiate the call of API
	 * 
	 */
	public void initiateRequest()
	{
		requestSpecification=RestAssured.given().relaxedHTTPSValidation();
		requestSpecification.given().log().all();
	}



	/**
	 * Endpoint url must be used when submitting REST API requests.
	 * @param uri in String format
	 */
	public void setbaseURI(String uri)
	{
		requestSpecification.baseUri(uri);
	}



	/**
	 * Query parameters are used to sort/filter resources
	 * @param key in String format
	 * @param value in String format
	 */

	public void setQueryparam(String key,String value)
	{
		requestSpecification.queryParam(key, value);
	}



	/**
	 *  Path parameters are used to identify a specific resource or resources
	 *  @param key in String format
	 *  @param value in String format
	 */

	public void setPathparam(String key,String value)
	{
		requestSpecification.pathParam(key, value);
	}




	/**
	 * Indicates the content type that is used in the body of the request.
	 * @param type indicates the content type 
	 * @param value indicates the type of the content
	 */

	public void setHeader(String type,String value)
	{
		requestSpecification.header(type,value);

	}



	/**
	 * The request body is used to send data via the REST API
	 * @param payload in String format
	 */
	public  void generatePostBodyFromJSONObject(String payload)

	{
		requestSpecification.body(payload);

	}



	/**
	 * Create a new resource in server
	 * @param uri in String format
	 * @return The response
	 */
	public Response setPostResourse(String uri)
	{
		return requestSpecification.when().post(uri);
	}




	/**
	 * Get the resource from the server
	 * @param uri in String format
	 * @return The response
	 */
	public Response setGetResourse(String uri)
	{
		return requestSpecification.when().get(uri);
	}



	/**
	 * Update the resource from the server
	 * @param uri in String format
	 * @return The response
	 */
	public Response setPutResourse(String uri)
	{
		return requestSpecification.when().put(uri);
	}


	/**
	 * Delete the resource from the server
	 * @param uri in String format
	 * @return The response
	 */
	public Response setDeleteResourse(String uri)
	{
		return requestSpecification.when().delete(uri);
	}



	/**
	 * To retrieve the response in log format
	 * @param resposne which receives from server
	 */
	public void checkResponse(Response response)
	{
		//System.out.println(response.then().log().all().assertThat().statusCode(200));
		System.out.println(response.then().log().all());

	}



	/**
	 * Status code of the response from the server
	 * @param response which receives from server
	 * @return status code in integer format
	 */
	public int getStatusCode(Response response)
	{
		return response.getStatusCode();

	}



	/**
	 * Converting response into String format
	 * @param response which receives from server
	 * @return response in String format
	 */
	public String getResponseAsString(Response response)
	{
		return response.then().extract().asString();
	}



	/**
	 * Converting response into JSON format
	 * @param response which receives from server
	 * @return response in JSON format
	 */
	public JsonPath getResponse(Response response)

	{
		JsonPath js=new JsonPath(response.then().extract().asString()); // for parsing json
		return js;

	}







}
