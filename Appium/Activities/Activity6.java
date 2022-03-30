package activities;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity6 {
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	  @BeforeClass
	  public void beforeClass() throws MalformedURLException  {
		  
		    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		    desiredCapabilities.setCapability("deviceId", "ZY322B8WZK");
		    desiredCapabilities.setCapability("platformName", "android");
		    desiredCapabilities.setCapability("automationName", "UiAutomator2");
		    desiredCapabilities.setCapability("appPackage", "com.android.chrome");
		    desiredCapabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		    desiredCapabilities.setCapability("noReset", true);

		    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
		    wait = new WebDriverWait(driver,10);
		    
	  }
  @Test
  public void chrometest() {
	  driver.findElementById("com.android.chrome:id/search_box_text").click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.android.chrome:id/url_bar"))).sendKeys("https://www.training-support.net/selenium/lazy-loading");
	
      MobileElement pageTitle = driver.findElementByClassName("android.widget.TextView");
      wait.until(ExpectedConditions.textToBePresentInElement(pageTitle, "Lazy Loading"));

      
      List<MobileElement> numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
      System.out.println("Number of image shown currently: " + numberOfImages.size());
      
      
      assertEquals(numberOfImages.size(), 4);
      
  
      driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"helen\")"));
      
   
      numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
      System.out.println("Number of image shown currently: " + numberOfImages.size());
      
      assertEquals(numberOfImages.size(), 4);
}

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
