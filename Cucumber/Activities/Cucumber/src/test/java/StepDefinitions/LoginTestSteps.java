package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestSteps {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("User is on Login page")
	public void user_is_on_login_page() {
		//Setup instances
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        
        //Open browser
        driver.get("https://www.training-support.net/selenium/login-form");
	}

	@When("User enters username and password")
	public void user_enters_username_and_password() {
		//Enter username
        driver.findElement(By.id("username")).sendKeys("admin");
        //Enter password
        driver.findElement(By.id("password")).sendKeys("password");
        //Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("Read the page title and confirmation message")
	public void read_the_page_title_and_confirmation_message() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
        
        //Read the page title and heading
        String pageTitle = driver.getTitle();
        String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();
        
        //Print the page title and heading
        System.out.println("Page title is: " + pageTitle);
        System.out.println("Login message is: " + confirmMessage);
	}
	
	@And("Browser close")
	public void close_the_browser() {
		driver.close();
	}
}
