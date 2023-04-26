package Basics;

import files.Payload;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.path.json.JsonPath;
public class ComplexJsonParse {
	public static void main(String[] args) {
		  JsonPath js=new JsonPath(Payload.CoursePrice());//dummy api
		     int count =js.getInt("courses.size()");
		     System.err.println(count);//number of array in api
		   int totalamount=  js.getInt("dashboard.purchaseAmount");
		   System.out.println(totalamount);
		   String titleFirstcourse=js.get("courses[0].title");
		   System.out.println(titleFirstcourse);
		   //if array is dynamic
		 
		   for (int i=0;i<count;i++) {
			 String Totalcourses= js.get("courses["+i+"].title");
			 System.out.println("Course "+Totalcourses);

			 System.out.println("Courses price "+js.get("courses["+i+"].price").toString());

			   //get copies
        	   System.out.println("No of copies soled "+js.get("courses["+i+"].copies").toString());
		   }
		   System.out.println("Print no of copies sold by RPA Course");
		   
		   for(int i=0;i<count;i++)
		   {
		  	  String courseTitles=js.get("courses["+i+"].title");
		  	  if(courseTitles.equalsIgnoreCase("RPA"))
		  	  {
		  		  int copies=js.get("courses["+i+"].copies");
		  		  System.out.println(copies);
		  		  break;
		  	  }
		  	
		  	  
		   }
	  
	}
   
}
