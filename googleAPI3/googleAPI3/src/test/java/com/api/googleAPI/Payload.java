package com.api.googleAPI;

public class Payload {
	
	public static String payloadAdd()
	{
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://rahulshettyacademy.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
	public static String payloadUpdate()
	{
		return "{\r\n"
		+ "\"place_id\":\""+AddPlace.placeId+"\",\r\n"
		+ "\"address\":\"80 Summer walk, USA\",\r\n"
		+ "\"key\":\"qaclick123\"\r\n"
		+ "}\r\n"
		+ "";
	}
	
	public static String payloadDelete()
	{
		return "{\r\n"  
                + "\r\n" 
                     + "\"place_id\":\""+AddPlace.placeId+"\"\r\n" + 
                      "}";
	}

}
