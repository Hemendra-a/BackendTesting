package pojoDS_S;

import static io.restassured.RestAssured.given;

//import java.util.ArrayList.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class Oauth2_pojo {
public static void main(String[] args) {
	String[] courseTitles= { "Selenium Webdriver Java","Cypress","Protractor"};
	String url="https://rahulshettyacademy.com/getCourse.php?code=4%2F0AVHEtk4pzWEG51k9ck89Q0AwbCwZ1TkR7_nE4DOTtLtgYrQ0aStjfandTE80AQUTW8uTYQ&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
    String partialcode=url.split("code=")[1];

    String code=partialcode.split("&scope")[0];

    System.out.println(code);
	String Accesstokenresponce=given().urlEncodingEnabled(false).
			queryParams("code",code)
			.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
			.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
			.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
			.queryParams("grant_type","authorization_code")
			.when().log().all()
			.post("https://www.googleapis.com/oauth2/v4/token").asString();
	        System.out.println(Accesstokenresponce);
	        JsonPath js=new JsonPath(Accesstokenresponce);
	        String aceessToken=js.getString("access_token");
	        System.out.println("aceessToken :"+aceessToken);
	        //uses pojo classes 
	        GetCourse getcourses=given().queryParam("access_token",aceessToken).expect().defaultParser(Parser.JSON)
	        		.when()
	        		.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
	        System.out.println(getcourses.getInstructor());
	        System.out.println(getcourses.getUrl());
	        System.out.println(getcourses.getServices());
	        System.out.println(getcourses.getExpertise());
//	        System.out.println(getcourses.getCourses().getApi().get(0).getCourseTitle());
//	        System.out.println(getcourses.getCourses().getApi().get(0).getPrice());
//	        System.out.println(getcourses.getCourses().getApi().get(1).getCourseTitle());
//	        System.out.println(getcourses.getCourses().getApi().get(1).getPrice());
//	        System.out.println(getcourses.getCourses().getWebAutomation().get(0).getCourseTitle());
//	        System.out.println(getcourses.getCourses().getWebAutomation().get(0).getPrice());
//	        System.out.println(getcourses.getCourses().getWebAutomation().get(1).getCourseTitle());
//	        System.out.println(getcourses.getCourses().getWebAutomation().get(1).getPrice());
//	        System.out.println(getcourses.getCourses().getMobile().get(0).getCourseTitle());
//	        System.out.println(getcourses.getCourses().getMobile().get(0).getPrice());
	        
	        //lets optimize the code
	        List<Api> apiCourses=getcourses.getCourses().getApi();
			for(int i=0;i<apiCourses.size();i++)
			{
				System.out.println(apiCourses.get(i).getCourseTitle());
				if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
						{
					System.out.println(apiCourses.get(i).getPrice());
						}
			}
			
			//Get the course names of WebAutomation
			ArrayList<String> a= new ArrayList<String>();
			
			
			List<WebAutomation> w=getcourses.getCourses().getWebAutomation();
			
			for(int j=0;j<w.size();j++)
			{
				a.add(w.get(j).getCourseTitle());
			}
			
			List<String> expectedList=Arrays.asList(courseTitles);
			
			Assert.assertTrue(a.equals(expectedList));

	        System.out.println(getcourses.getLinkedIn());
//	        System.out.println(responce);


}
}
