package dynamicsJason;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import files.ReusableMethods;
import  io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
//Dynamically build json payload with external data inputs
//parameterize the api Tests with multiple data sets

public class DynamicJson {
   @Test
   public void AddBook() {
	   RestAssured.baseURI="http://216.10.245.166";
	   String arg1="abcdegf";//dynamic
	   String arg2="95682";
	   
	   String responce=given().log().all().header("Content-Type","application/json")
	   .body(Payload.AddBook(arg1,arg2)).
	   when().post("/Library/Addbook.php").then().log().all().assertThat().
	   statusCode(200).extract().response().asString();
	   JsonPath js=ReusableMethods.RawTojson(responce);//check resuable class
	   String id=js.get("ID");
	   System.out.println(id);
	   
	   //delete book
	   
   }
   
}
