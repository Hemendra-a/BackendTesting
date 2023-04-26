package Basics;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import io.restassured.RestAssured;
import files.Payload;
import files.ReusableMethods;
import io.restassured.path.json.JsonPath;

public class Getresponce3 {
	public static void main(String[] args) {
		//Given:all inputs details
		//when:submit the api,resources ,http method goes under when
		//Then:validate the responce
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String Postresponce=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.AddPayload()).when().post("maps/api/place/add/json").then().log().all().assertThat().
		statusCode(200).body("scope",equalTo("APP"))
		.header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
		System.out.println(Postresponce);
		//how to extract data from responce this is in the json
		JsonPath js=new JsonPath(Postresponce);
		String placeId=js.getString("place_id");
		System.out.println(placeId); 
//		//update place
		String New_Address ="72 Summer walk, USA";
		        given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
				.body(Payload.payload1(placeId, New_Address)).when().put("maps/api/place/update/json").then().log().all().assertThat().
				statusCode(200).body("msg",equalTo("Address successfully updated"));

		//get place
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String GetResponce=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId).header("Content-Type","application/json")
		.when().get("maps/api/place/get/json").then().log().all().assertThat().
		statusCode(200).body("name",equalTo("Frontline house")).extract().response().asString();
		JsonPath js1=ReusableMethods.RawTojson(GetResponce);
		
		String actualaddress=js1.getString("address");
		System.out.println(actualaddress);
		//junit and testng cucumber
		Assert.assertEquals(actualaddress, New_Address);
		} 
}
