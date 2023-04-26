package staticJsonpayload;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;

//Read data from file
public class ReadBodyDataFromFile {
public static void main(String[] args) throws IOException {
	RestAssured.baseURI="https://rahulshettyacademy.com";
	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	.body(new String (Files.readAllBytes(Paths.get("D:\\eclipse-workspace1\\RestAssured\\TestData\\PayloadFile")))).when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
	.header("server", "Apache/2.4.41 (Ubuntu)");
}
}
