package dynamicsJason;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson2_paramerize {
	@Test(dataProvider="BooksData")
	   public void AddBook(String arg1,String arg2) {
		   RestAssured.baseURI="http://216.10.245.166";

		   String responce=given().log().all().header("Content-Type","application/json")
		   .body(Payload.AddBook(arg1,arg2)).
		   when().post("/Library/Addbook.php").then().log().all().assertThat().
		   statusCode(200).extract().response().asString();
		   JsonPath js=ReusableMethods.RawTojson(responce);//check resuable class
		   String id=js.get("ID");
		   System.out.println(id);
		   
		   //delete book
		   
}
	@DataProvider(name="BooksData")
	   //multidynamically array=collections of array
	   public Object[][] getData() {
		   return new Object[][] {{"abhgg","562245"},{"jhbnc","632156"},{"mlcxm","32156"},{"kolkjd","96584"}};//collections of elemts=array
	   }
	}
