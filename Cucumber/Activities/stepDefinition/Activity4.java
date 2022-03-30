package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity4 {
	public class LoginSteps {
	    WebDriver driver;
	    WebDriverWait wait;
	    
	    @Given("^User is on Login page$")
	    public void loginPage4() {

	        driver = new FirefoxDriver();
	        wait = new WebDriverWait(driver, 10);
	        driver.get("https://www.training-support.net/selenium/login-form");
	    }
	    
	    
	    @When("^User enters \"(.*)\" and \"(.*)\"$")
	    public void user_enters_and(String username, String password) throws Throwable {
	        driver.findElement(By.id("username")).sendKeys(username);
	        driver.findElement(By.id("password")).sendKeys(password);
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	    }
	    
	    @Then("^Read the page title and confirmation message$")
	    public void readTitleAndHeading() {
	        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));

	        String pageTitle = driver.getTitle();
	        String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();

	        System.out.println("Page title is: " + pageTitle);
	        System.out.println("Login message is: " + confirmMessage);
	        Assert.assertEquals(confirmMessage, "Welcome Back, admin");
	    }
	    
	    @And("^Close the browser for activity4$")
	    public void closeBrowser() {

	        driver.close();
	    }

	}
}
