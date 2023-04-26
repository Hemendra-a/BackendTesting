package files;



public class Payload {
	
public static String AddPayload() {
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
			+ "  \"website\": \"http://google.com\",\r\n"
			+ "  \"language\": \"French-IN\"\r\n"
			+ "}";
}
          public static String payload1(String placeId,String New_Address) {
	        return "{\r\n"
			+ "\"place_id\":\""+placeId+"\",\r\n"
			+"\"address\":\""+New_Address+"\",\r\n"
			+ "\"key\":\"qaclick123\"\r\n"
			+ "}";
}
       public static String CoursePrice() {
    	   return "{\r\n"
    	   		+ "\r\n"
    	   		+ "\"dashboard\": {\r\n"
    	   		+ "\r\n"
    	   		+ "\"purchaseAmount\": 1660,\r\n"
    	   		+ "\r\n"
    	   		+ "\"website\": \"rahulshettyacademy.com\"\r\n"
    	   		+ "\r\n"
    	   		+ "},\r\n"
    	   		+ "\r\n"
    	   		+ "\"courses\": [\r\n"
    	   		+ "\r\n"
    	   		+ "{\r\n"
    	   		+ "\r\n"
    	   		+ "\"title\": \"Selenium Python\",\r\n"
    	   		+ "\r\n"
    	   		+ "\"price\": 50,\r\n"
    	   		+ "\r\n"
    	   		+ "\"copies\": 6\r\n"
    	   		+ "\r\n"
    	   		+ "},\r\n"
    	   		+ "\r\n"
    	   		+ "{\r\n"
    	   		+ "\r\n"
    	   		+ "\"title\": \"Cypress\",\r\n"
    	   		+ "\r\n"
    	   		+ "\"price\": 40,\r\n"
    	   		+ "\r\n"
    	   		+ "\"copies\": 4\r\n"
    	   		+ "\r\n"
    	   		+ "},\r\n"
    	   		+ "\r\n"
    	   		+ "{\r\n"
    	   		+ "\r\n"
    	   		+ "\"title\": \"RPA\",\r\n"
    	   		+ "\r\n"
    	   		+ "\"price\": 45,\r\n"
    	   		+ "\r\n"
    	   		+ "\"copies\": 10\r\n"
    	   		+ "\r\n"
    	   		+ "},\r\n"
    	   		+ "  {\r\n"
    	   		+ "\r\n"
    	   		+ "\"title\": \"Appium\",\r\n"
    	   		+ "\r\n"
    	   		+ "\"price\": 50,\r\n"
    	   		+ "\r\n"
    	   		+ "\"copies\": 15\r\n"
    	   		+ "\r\n"
    	   		+ "}\r\n"
    	   		+ "\r\n"
    	   		+ "]\r\n"
    	   		+ "\r\n"
    	   		+ "}";
       }
       public static String AddBook(String arg1, String arg2) {
    	   return "{\r\n"
    	   		+ "\r\n"
    	   		+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
    	   		+ "\"isbn\":\""+arg1+"\",\r\n"
    	   		+ "\"aisle\":\""+arg2+"\",\r\n"
    	   		+ "\"author\":\"John foe\"\r\n"
    	   		+ "}";
       }
       public static String JiraIssue() {
    	   return "{ \"fields\": {\r\n"
    	   		+ "        \"project\": {\r\n"
    	   		+ "            \"key\": \"RES\"\r\n"
    	   		+ "        },\r\n"
    	   		+ "        \"summary\": \"Credit card is not working\",\r\n"
    	   		+ "        \"description\":\"second issue in sec project\",\r\n"
    	   		+ "        \"issuetype\": {\r\n"
    	   		+ "            \"name\":\"Bug\"\r\n"
    	   		+ "        }\r\n"
    	   		+ "        }}";
       }
}
