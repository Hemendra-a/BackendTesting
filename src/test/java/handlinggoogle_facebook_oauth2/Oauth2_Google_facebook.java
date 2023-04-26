package handlinggoogle_facebook_oauth2;

import static io.restassured.RestAssured.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.parsing.Parser;

import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;

import io.restassured.response.ResponseBody;

public class Oauth2_Google_facebook {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
//		WebDriverManager.chromedriver().setup();
//	    driver = new ChromeDriver();
//	    driver.get("https://accounts.google.com");
//	    driver.findElement(By.cssSelector("input[type='email']")).sendKeys("enter ema");
//	    driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
//	    Thread.sleep(3000);
//	    driver.findElement(By.cssSelector("input[type='pasword']")).sendKeys("enter password");
//	    driver.findElement(By.cssSelector("input[type='pasword']")).sendKeys(Keys.ENTER);
//	    Thread.sleep(3000);
//	    String url=driver.getCurrentUrl();
		
		//we need to do perform this manually because google dont allow this via automation
		String url="https://rahulshettyacademy.com/getCourse.php?code=4%2F0AVHEtk6mW6tVkbpN3BpaZVsiyEp51drc2sTUzjAHy7PPnP_wEInHrH7vIpSYa2JrqW8yQw&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
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
		        
		        String responce=given().queryParam("access_token",aceessToken)
		        		.when().log().all()
		        		.get("https://rahulshettyacademy.com/getCourse.php").asString();
		        System.out.println(responce);


		}}


