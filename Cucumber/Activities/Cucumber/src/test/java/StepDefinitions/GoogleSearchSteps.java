package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("User is on Google Home Page")
	public void user_is_on_google_home_page() {
	    driver = new FirefoxDriver();
	    wait =new WebDriverWait(driver,Duration.ofSeconds(20));
	    driver.get("https://www.google.com/");
	}

	@When("User Types in Cheese and hits ENTER")
	public void user_types_in_cheese_and_hits_enter() {
		driver.findElement(By.name("q")).sendKeys("Cheese",Keys.RETURN);
	    
	}

	@Then("Show how many search results were shown")
	public void show_how_many_search_results_were_shown() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
		String stats = driver.findElement(By.id("result-stats")).getText();
		System.out.println(stats);
	}

	@And("close the browser")
	public void close_the_browser() {
		driver.close();
	}
	

}
