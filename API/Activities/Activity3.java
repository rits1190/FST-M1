package restAssuredExample;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;




public class Activity3 {
	RequestSpecification requestSpec;	
	ResponseSpecification responsespec;
	@BeforeClass
	public void setUp() {
	    // Create request specification
	    requestSpec = new RequestSpecBuilder()
	        .setContentType(ContentType.JSON)
	        .setBaseUri("https://petstore.swagger.io/v2/pet")
	        .build();
	    responsespec= new ResponseSpecBuilder()
	    		.expectStatusCode(200)
	    		.expectContentType("application/json")
	    		.expectBody("status",equalTo("alive"))
	    		.build();
	    		
	}
	
@DataProvider	
public Object[][] petInfo(){
	Object[][] testData =new Object[][] {
		{ 20201, "July", "alive" }, 
        { 20202, "Chubby", "alive" }
    };
	return testData;
}
  @Test(priority=1)
  public void addpets() {
	  String reqBody ="{\"id\": 20201, \"name\": \"July\", \"status\": \"alive\"}";
	  
	  Response response = given().spec(requestSpec) // Use requestSpec
              .body(reqBody) // Send request body
              .when().post(); // Send POST request

	   reqBody ="{\"id\": 20202, \"name\": \"Chubby\", \"status\": \"alive\"}";	
	  
	  response = given().spec(requestSpec) // Use requestSpec
              .body(reqBody) // Send request body
              .when().post(); // Send POST request
	  
	  response.then().spec(responsespec);
  }
  
  
  @Test(dataProvider = "petInfo", priority=2)
  public void getpets(int id, String name, String status) {
	  Response response = given().spec(requestSpec) // Use requestSpec
              .pathParam("petId", id) // Add path parameter
              .when().get("/{petId}"); // Send GET request
 
	// Print response
      System.out.println(response.asPrettyString());
      // Assertions
      response.then()
      .spec(responsespec) // Use responseSpec
      .body("name", equalTo(name)); // Additional Assertion
  }
  
  @Test(dataProvider = "petInfo", priority=3)
  public void deletePets(int id, String name, String status) {
      Response response = given().spec(requestSpec) // Use requestSpec
              .pathParam("petId", id) // Add path parameter
              .when().delete("/{petId}"); // Send GET request

      // Assertions
      response.then().body("code", equalTo(200));
  }
}
