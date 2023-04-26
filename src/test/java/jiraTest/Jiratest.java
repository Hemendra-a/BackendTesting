package jiraTest;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;



import files.Payload;

public class Jiratest {
//create issue
	@Test
	public void Jiratest1() {
		//login 
		RestAssured.baseURI="http://localhost:8080";
		SessionFilter session=new SessionFilter();//?
		String responce=given().log().all().header("Content-Type","application/json")
		.body("{ \"username\": \"plz enter username\", \"password\": \"plz enter password\" }").log().all().filter(session).when().post("rest/auth/1/session").then().log().all().assertThat().
		statusCode(200).header("Content-Encoding","gzip").extract().response().asString();
		System.out.println(responce);
		JsonPath js=new JsonPath(responce);
		String ValueID = js.getString("session.value");
		System.out.println(ValueID); 
		
		//create issue
		RestAssured.baseURI="http://localhost:8080";
		String Postresponce=given().log().all().header("Content-Type","application/json").header("Cookie","JSESSIONID="+ValueID+"")
		.body(Payload.JiraIssue()).when().post("/rest/api/2/issue").then().log().all().assertThat().
		statusCode(201).header("Content-Encoding","gzip").extract().response().asString();
		System.out.println(Postresponce);
		JsonPath js1=new JsonPath(Postresponce);
		String ID = js1.getString("id");
		System.out.println(ID); 
		
		//add comment
		String expectedmessage="Hii,how are you";
		String Postresponce1=given().log().all().header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"body\": \""+expectedmessage+"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(session).when().post("/rest/api/2/issue/"+ID+"/comment").then().log().all().assertThat().
		statusCode(201).extract().response().asString();
		System.out.println(Postresponce1);
		JsonPath js2=new JsonPath(Postresponce1);
		String CommentID = js2.getString("id");
		System.out.println(CommentID);
		//add atachement
		System.out.println("<<<<<<<<<<<<<<Attachment>>>>>>>>>>");
	       given().header("X-Atlassian-Token","no-check").filter(session).pathParam("key", ID).
	       header("Content_Type","multipart/form-data").
	       multiPart("file",new File("jira.txt")).when().post("/rest/api/2/issue/{key}/attachments").then().log().all().
	       assertThat().statusCode(200);
	       
	       //get issue 
	       String issuedetails=given().filter(session).pathParam("key", ID).when().get("/rest/api/2/issue/{key}").then().
	       log().all().extract().response().asString();
	       System.out.println(issuedetails);
	       JsonPath js3=new JsonPath(issuedetails);
	       int commentcount=js3.getInt("fields.comment.comments.size()");
	       System.out.println(commentcount);
	       String commentIDIssue="";
	       for(int i=0;i<commentcount;i++) {
	    	   commentIDIssue=js3.get("fields.comment.comments["+i+"].id").toString();
	    	   System.out.println(commentIDIssue);
	    	   if(commentIDIssue.equalsIgnoreCase(CommentID)) {
	    		  String message= js3.get("fields.comment.comments["+i+"].body").toString();
	    		  System.out.println(message);
	    		  Assert.assertEquals(message, expectedmessage);
	       }
	}

}}
