import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

public class RestAssuredPOC {

	public static void main(String[] args) 
	{
		// Validate if Add Place API is working fine
		//Given - All Inout details
		//when - resource and http methods
		//then - validate
		
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\r\n" 
				+ "    \"location\":{\r\n"
				+ "\r\n"
				+ "        \"lat\" : -38.383494,\r\n"
				+ "\r\n"
				+ "        \"lng\" : 33.427362\r\n"
				+ "\r\n"
				+ "    },\r\n"
				+ "\r\n"
				+ "    \"accuracy\":50,\r\n" 
				+ "\r\n"
				+ "    \"name\":\"MiniUP fest pro\",\r\n"
				+ "\r\n"
				+ "    \"phone_number\":\"(+91) 999 899 4748\",\r\n"
				+ "\r\n"
				+ "    \"address\" : \"63, side layout, cohen 12\",\r\n"
				+ "\r\n"
				+ "    \"types\": [\"shoe park\",\"shop\"],\r\n"
				+ "\r\n"
				+ "    \"website\" : \"http://rahulshettyacademy.com\",\r\n"
				+ "\r\n"
				+ "    \"language\" : \"French-IN\"\r\n"
				+ "\r\n"
				+ "}").when().post("/maps/api/place/add/json")
		.then().log().all().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		System.out.println(response);
		JsonPath js=new JsonPath(response); // for parsing json
		String placeId = js.getString("place_id");
		System.out.println(placeId);

		//Update Place
				String newAddress = "DownTown, Denver";
				
				given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
				.body("{\r\n" + 
						"\"place_id\":\""+placeId+"\",\r\n" + 
						"\"address\":\""+newAddress+"\",\r\n" + 
						"\"key\":\"qaclick123\"\r\n" + 
						"}").when().put("maps/api/place/update/json")
				.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
				
				//Get Place
				String getPlaceResponse=given().log().all().queryParam("key", "qaclick123")
						.queryParam("place_id",placeId)
						.when().get("maps/api/place/get/json")
						.then().assertThat().log().all().statusCode(200).extract().response().asString();
						JsonPath js1= new JsonPath(getPlaceResponse);
						String actualAddress =js1.getString("address");
						System.out.println(actualAddress);
						
						//Delete place
                        given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
                        .body("{\r\n"  
                                + "\r\n" 
                                     + "\"place_id\":\""+placeId+"\"\r\n" + 
                                      "}").when().delete("/maps/api/place/delete/json?key=qaclick123")
                      .then().assertThat().log().all().statusCode(200).body("status", equalTo("OK"));
                                
                    //get place for delete verification
                        given().log().all().queryParam("key", "qaclick123")
                                .queryParam("place_id",placeId)
                                .when().get("maps/api/place/get/json")
                         .then().assertThat().log().all().statusCode(404).body("msg", equalTo("Get operation failed, looks like place_id  doesn't exists"));

	} 
  
}
 
