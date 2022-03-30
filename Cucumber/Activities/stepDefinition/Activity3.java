package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity3 {

	WebDriver driver;
	WebDriverWait wait;

	@Given("^User is on the page$")
	public void launchAlert() throws Throwable{
		
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,20);
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
	}
	
	@When("^User clicks the Simple Alert button$")
	public void simpleAlert() throws Throwable{
		
		driver.findElement(By.id("simple")).click();

	}
	@When("^User clicks the Confirm Alert button$")
	public void confirmAlert() throws Throwable{
		
		driver.findElement(By.id("confirm")).click();
	}
	
	@When("^User clicks the Prompt Alert button$")
	public void promptAlert() throws Throwable{
		
		driver.findElement(By.id("prompt")).click();
	}
	
	@Then("^Alert opens$")
	public void alertOpen() throws Throwable{
		driver.switchTo().alert();
	}
	
	@And ("^Read the text from it and print it$")
    public void readMsg() throws Throwable {
		String Message = driver.switchTo().alert().getText();
		System.out.println("Alert message is " + Message);
    }
	
	@And ("^Write a custom message in it$")
    public void writeMsg() throws Throwable {
		driver.switchTo().alert().sendKeys("Priyank's Message");
    }
	
	@And ("^Close the alert$")
    public void closeAlert() throws Throwable {
		driver.switchTo().alert().accept();
    }
	
	@And ("^Close the alert with Cancel$")
    public void cancleAlert() throws Throwable {
		driver.switchTo().alert().dismiss();
    }
	@And ("^Read the result text$")
    public void readResult() throws Throwable {
		String msg= driver.findElement(By.xpath("//div[@class='content']")).getText();
		System.out.println("result text is " + msg);
    }
	
	@And ("^Close Browser for activity3$")
    public void closeTheBrowser() throws Throwable {
        driver.close();
    }


}
