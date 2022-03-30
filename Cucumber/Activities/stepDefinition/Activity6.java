package stepDefinition;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Activity6 {

	@Given("^I have given Smoketest tah in feature file$")
    public void smoketestfeature() {
		System.out.println("Testing smoke test tag");
	}
    
    @When("^Run the test runner file$")
    public void Run() {
    	System.out.println("Test Runner file executed with Smoketest tag");
       
    }
}
