package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity2 {

	WebDriver driver;
	WebDriverWait wait;

	@Given("^User is on Login page$")
	public void launchWebsite() throws Throwable{
		
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,20);
		driver.get("https://www.training-support.net/selenium/login-form");
	}
	
	@When("^User enters username and password$")
	public void enterCredentials() throws Throwable{
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	
	@When("^User enters \"(.*)\" and \"(.*)\"$")
	    public void user_enters_and(String username, String password) throws Throwable {
	        driver.findElement(By.id("username")).sendKeys(username);
	        driver.findElement(By.id("password")).sendKeys(password);
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	   }
	   
	@Then("^Read the page title and confirmation message$")
	public void title() throws Throwable{
		
		String Message = driver.findElement(By.id("action-confirmation")).getText();
		System.out.println("title of the page is " + driver.getTitle());
		System.out.println("login message is " + Message);
	}
	
	@And ("^Close the browser for activity2$")
    public void closeTheBrowser() throws Throwable {
        driver.close();
    }
	

}
