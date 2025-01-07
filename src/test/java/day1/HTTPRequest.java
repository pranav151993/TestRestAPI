package day1;

import org.testng.annotations.Test;                     
import static io.restassured.RestAssured.*;              //use static word in each import 
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
/*

//these 3 are methods. test case is devided in these 3 sections.
given()   //Pre requsities-content type,set cookies,add auth, add param,set headers info etc.

when()   //Request-get,post,put,delete.

then()  //Validations-validate status code,extract response,extract headers cookies & response body.
*/

public class HTTPRequest {
	
	   
	// by default we are folowing BDD approach.
     
	// gherking - keywords
	
	int id; //created global variable int to fetch value from response to use it in future.
	
	
	@Test(priority=1)
	void getUsers() {  //get method
		
	given()	  //for first method no need of dot. //for these 3 keywords,need to import static packages from rest website document
	
	.when()
	.get("https://reqres.in/api/users?page=2") //request url
	
	.then()
		.statusCode(200) // validation of status code
		.body("page",equalTo(2)) //validation of page parameter with value 2
		.log().all();  //to get response body in console
	}
	                  // run code as TestNG
	
	
	@Test(priority=2)	
	void createUser()        //post method
	{
	HashMap hm = new HashMap();	//here we are using test data in hash map format , but in real time its not usedbecause we have to hardcore the data.
		hm.put("name","pranav");
		hm.put("job","trainer");
			
		id = given()           //return path for id variable to store it.//specify type of data and request body.
		.contentType("application/json")
		.body(hm)
		
		.when()               //specify request method and url
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");  //to fetch id from the response to use/update it in future.
		
		//.then()
		//.statusCode(201)   //for post request use 201.
		//.log().all();
		
	}
	
	@Test (priority=3,dependsOnMethods= {"createUser"})
	void UpdateUser()              //put method
	{
		HashMap hm = new HashMap();	//here we are using test data in hash map format , but in real time its not usedbecause we have to hardcore the data.
		hm.put("name","bipin");
		hm.put("job","teacher");
			
		given()           //return path for id variable to store it.//specify type of data and request body.
		.contentType("application/json")
		.body(hm)
		
		.when()               //specify request method and url
		.put("https://reqres.in/api/users/"+id)  //passed id to which we r updating data
		
		.then()
		.statusCode(200)   //for put request use 201.
		.log().all();				
	}
	
	@Test(priority=4)
	void deletsUser()
	{
	given()
	
	
	.when()
	.delete("https://reqres.in/api/users/"+id)
	
	.then()
		.statusCode(204)
		.log().all();		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
