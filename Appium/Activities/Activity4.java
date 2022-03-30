package activities;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity4 {
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	  @BeforeClass
	  public void beforeClass() throws MalformedURLException  {
		  
		    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		    desiredCapabilities.setCapability("deviceId", "ZY322B8WZK");
		    desiredCapabilities.setCapability("platformName", "android");
		    desiredCapabilities.setCapability("automationName", "UiAutomator2");
		    desiredCapabilities.setCapability("appPackage", "com.android.dialer");
		    desiredCapabilities.setCapability("appActivity", "com.motorola.dialer.app.ExtendedDialtactsActivity");
		    desiredCapabilities.setCapability("noReset", true);

		    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
		    wait = new WebDriverWait(driver,10);
	  }
  @Test
  public void addContact() {
	  driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Contacts tab.\"]").click();
	  driver.findElementByXPath("//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.TextView").click();
	  driver.findElementByXPath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[1]").sendKeys("Test Name");
	  driver.findElementByXPath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[2]").sendKeys("Test LastName");
	  String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
	  driver.findElementByAndroidUIAutomator(UiScrollable + ".scrollForward()");
	  driver.findElementById("com.android.contacts:id/editors").sendKeys("123456789");
	  driver.findElementById("com.android.contacts:id/editor_menu_save_button").click();
	  String result = driver.findElementById("com.android.contacts:id/title_gradient").getText();
	  assertEquals(result,"Test Name Test LastName");
	  
	  System.out.println("New contact added is "+ result);
  }


  @AfterClass
  public void afterClass() {
	 driver.quit(); 
  }

}
