package day2;

import org.testng.annotations.Test;                     
import static io.restassured.RestAssured.*;              //use static word in each import 
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
/*ways to create request body
1.Hashmap
2.using org.json
3.using POJO(Plan old java object)
4.using external json file
*/
public class Diffwaystocreatepostrequestbody {
	
@Test
void tespostusingHashMap() {
	HashMap data = new HashMap();
	data.put("name","Scott");
	data.put("location", "France");
	data.put("phone", "123456");
	String courseArr[]= {"C","C++"}; //as we have multiple values in course
	
	data.put("courses",courseArr);
	
	given()
	.contentType("application/json")
	.body(data);
	
	.when()
	.post("")
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
