package activities;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity5 {
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	  @BeforeClass
	  public void beforeClass() throws MalformedURLException  {
		  
		    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		    desiredCapabilities.setCapability("deviceId", "ZY322B8WZK");
		    desiredCapabilities.setCapability("platformName", "android");
		    desiredCapabilities.setCapability("automationName", "UiAutomator2");
		    desiredCapabilities.setCapability("appPackage", "com.google.android.apps.messaging");
		    desiredCapabilities.setCapability("appActivity", ".ui.ConversationListActivity");
		    desiredCapabilities.setCapability("noReset", true);

		    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
		    wait = new WebDriverWait(driver,10);
	  }
  @Test
  public void smsapptest() {
	  driver.findElementByAccessibilityId("Start chat").click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("recipient_text_view")));
	  driver.findElementById("com.google.android.apps.messaging:id/recipient_text_view").sendKeys("7028926593");
		 
	  driver.findElementById("com.google.android.apps.messaging:id/compose_message_text").sendKeys("Hello from Appium");
	  driver.findElementById("com.google.android.apps.messaging:id/send_message_button_icon").click();
	  assertEquals(driver.findElementById("com.google.android.apps.messaging:id/message_status").isDisplayed(),true);
	  System.out.println("SMS sent successfully");
	  
  }


  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
