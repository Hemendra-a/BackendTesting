package Basics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import files.Payload;
import io.restassured.RestAssured;

public class LetsObtimiseBasic {
	public static void main(String[] args) {
		//Given:all inputs details
		//when:submit the api,resources ,http method goes under when
		//Then:validate the responce
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.AddPayload()).when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("server", "Apache/2.4.41 (Ubuntu)");

		}
}
