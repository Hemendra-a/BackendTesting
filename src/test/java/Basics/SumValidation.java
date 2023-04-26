package Basics;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	@Test
   public void SumOfCourses() {
		  JsonPath js=new JsonPath(Payload.CoursePrice());//dummy api
		     int count =js.getInt("courses.size()");
		     System.out.println(count);
		  
		     int sum=0;
		     for(int i=0;i<count;i++) {
		    	 int price=js.get("courses["+i+"].price");
		    	 int copies=js.get("courses["+i+"].copies");
		    	int amount=price*copies;
		    	 sum=sum+amount;
		    	 System.out.println(amount);
		    	
		     }
		     System.out.println(sum);
		     int purchaseamount=js.getInt("dashboard.purchaseAmount");
		     Assert.assertEquals(purchaseamount, sum);
   }
}
