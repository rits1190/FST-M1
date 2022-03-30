package activities;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

//import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity6 {
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
  @BeforeClass
  public void beforeClass() throws MalformedURLException{
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
  public void f() {
	  
	  //launching url
	  driver.findElementById("com.android.chrome:id/search_box_text").click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.android.chrome:id/url_bar"))).sendKeys("https://www.training-support.net/selenium");
	  driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.LinearLayout").click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.className("android.widget.Button")));
	
	  //scrolling to popus view
	  String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
	  MobileElement view= driver.findElementByAndroidUIAutomator(UiScrollable + ".scrollIntoView(textContains(\"Popups\"))");
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  view.click();
	  
	  //open Sign in form
	  driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View/android.widget.Button").click();
	  
	  //verification of popups login with valid credentials
	  System.out.println("Testing valid credentials");
	  driver.findElementByXPath("//android.view.View/android.view.View/android.view.View/android.widget.EditText[1]").sendKeys("admin");
	  driver.findElementByXPath("//android.view.View/android.view.View/android.view.View/android.widget.EditText[2]").sendKeys("password");
	  driver.findElementByAndroidUIAutomator(UiScrollable + ".scrollForward()");
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  driver.findElementByXPath("//android.view.View/android.view.View/android.view.View/android.widget.Button").click();
	  //String text = driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.widget.TextView[4]").getText();
	  //assertEquals(text, "Welcome Back,admin");
	  //System.out.println("Message on the panel is" + text);
  
	 //verification of popups login with invalid credentials
	  System.out.println("Testing invalid credentials");
	  driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View/android.widget.Button").click();
	  driver.findElementByXPath("//android.view.View/android.view.View/android.view.View/android.widget.EditText[1]").sendKeys("admin0123");
	  driver.findElementByXPath("//android.view.View/android.view.View/android.view.View/android.widget.EditText[2]").sendKeys("admin");
	  driver.findElementByAndroidUIAutomator(UiScrollable + ".scrollForward()");
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  driver.findElementByXPath("//android.view.View/android.view.View/android.view.View/android.widget.Button").click();
	  //String text2 = driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.widget.TextView[4]").getText();
	  //assertEquals(text2, "Invalid Credentials");
	  //System.out.println("Message on the panel is" + text2);
  }


  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  

}
