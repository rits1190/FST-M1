package activities;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity3 {
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
@BeforeClass
	  public void beforeClass() throws MalformedURLException {
	DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("deviceId", "ZY322B8WZK");
    desiredCapabilities.setCapability("platformName", "android");
    desiredCapabilities.setCapability("automationName", "UiAutomator2");
    desiredCapabilities.setCapability("appPackage", "com.google.android.keep");
    desiredCapabilities.setCapability("appActivity", ".activities.BrowseActivity");
    desiredCapabilities.setCapability("noReset", true);

    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
    wait = new WebDriverWait(driver,10);
	  }
	@Test
  public void f() {
		  //creating new note
		  driver.findElementById("com.google.android.keep:id/new_note_button").click();
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.keep:id/editable_title"))).sendKeys("TestReminders");
	      driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("TestRemindersNote");	
	      
	      //adding remainder for the note
	      driver.findElementById("com.google.android.keep:id/menu_switch_to_grid_view").click();
	      driver.findElementByXPath("//android.view.ViewGroup[1]/android.widget.TextView[1]").click();
	      
	      //verifying remainder is added
	      MobileElement button = driver.findElementByAccessibilityId("Open navigation drawer");
	      wait.until(ExpectedConditions.visibilityOf(button)).click();
	      
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.keep:id/index_note_title"))).isDisplayed();
	      String result1 = driver.findElementById("com.google.android.keep:id/index_note_title").getText();
		  System.out.println("Title: " + result1);
		  assertEquals(result1,"TestReminders");
		  String result2 = driver.findElementById("com.google.android.keep:id/index_note_text_description").getText();
		  System.out.println("Note: " + result2);
		  assertEquals(result2,"TestRemindersNote");
		 
		  assertEquals(driver.findElementById("com.google.android.keep:id/reminder_chip_text").isDisplayed(),true);
		  
		  
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  

}
