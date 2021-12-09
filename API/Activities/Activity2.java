package restAssuredExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity2 {
 String ROOT_URI="https://petstore.swagger.io/v2/user";
// This way of declaring in class is not working . with in a method is working	
//baseURI = "https://petstore.swagger.io/v2/pet";
  @Test(priority=1)
  public void post_usr() throws IOException  {
	 FileInputStream inputJSON = new FileInputStream("src/input1.json");
	  
	// Read JSON file as String
     byte[] buffer = new byte[10];
     StringBuilder sb = new StringBuilder();
     while (inputJSON.read(buffer) != -1) {
         sb.append(new String(buffer));
         buffer = new byte[10];
     }
     inputJSON.close();
	 String reqBody=sb.toString();
//	 String reqBody ="{\n" + 
//	 		"  \"id\":20200505,\n" + 
//	 		"  \"username\": \"Sukanya\",\n" + 
//	 		"  \"firstName\": \"Sukanya\",\n" + 
//	 		"  \"lastName\": \"Mankala\",\n" + 
//	 		"  \"email\": \"sukanya@mail.com\",\n" + 
//	 		"  \"password\": \"password123\",\n" + 
//	 		"  \"phone\": \"1234567890\"\n" + 
//	 		"}";
	
	 System.out.println(reqBody);
	  
	  
	  Response response =RestAssured.given().contentType(ContentType.JSON)
			  .body(reqBody)
			  .when().post(ROOT_URI);
	 
	  inputJSON.close();
	  
	  System.out.println(response.getBody().asPrettyString());
	  
	  response.then().body("code", equalTo(200));
	  response.then().body("message", equalTo("20200505"));
	   
  }
  
  @Test(priority=2)
  public void getuser() {
	  File outputJSON = new File("src/output.json");
	  Response response =RestAssured.given().contentType(ContentType.JSON)
			  .when().pathParam("username", "Sukanya")// passing path param
			  .get(ROOT_URI+"/{username}");
	  
	  String responseBody = response.getBody().asPrettyString();
	  
	  try {
		  // creating json file
		  outputJSON.createNewFile();
		  FileWriter writer= new FileWriter(outputJSON.getPath());
		  writer.write(responseBody);
		  writer.close();
	  }catch (Exception e) {
		  e.printStackTrace();
	  }
	  
	// Assertion
      response.then().body("id", equalTo(20200505));
      response.then().body("username", equalTo("Sukanya"));
      response.then().body("firstName", equalTo("Sukanya"));
      response.then().body("lastName", equalTo("Mankala"));
      response.then().body("email", equalTo("sukanya@mail.com"));
      response.then().body("password", equalTo("password123"));
      response.then().body("phone", equalTo("1234567890"));
  }
  
  @Test(priority=3)
  public void deleteUser() throws IOException {
      Response response = 
          given().contentType(ContentType.JSON) // Set headers
          .pathParam("username", "Sukanya") // Add path parameter
          .when().delete(ROOT_URI + "/{username}"); // Send POST request

      // Assertion
      response.then().body("code", equalTo(200));
      response.then().body("message", equalTo("Sukanya"));
  }
  
}

