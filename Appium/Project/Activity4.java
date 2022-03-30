package activities;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity4 {
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
	  
	  String tasks[] = {
			  "Add tasks to list",
			  "Get number of tasks",
			  "Clear the list"
	  };
	  
	 //launching url 
	 driver.findElementById("com.android.chrome:id/search_box_text").click();
	 wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.android.chrome:id/url_bar"))).sendKeys("https://www.training-support.net/selenium");
	 driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.LinearLayout").click();
	 wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.className("android.widget.Button")));
	 
	 //scrolling to To DO List 
	  String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
	  MobileElement view= driver.findElementByAndroidUIAutomator(UiScrollable + ".scrollIntoView(textContains(\"To-Do List\"))");
      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      view.click();
      
      //adding tasks using loop
	  for(String task : tasks) {
      driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText").sendKeys(task);
      driver.findElementByXPath("//android.view.View/android.view.View/android.view.View[1]/android.widget.Button").click();     
	  }
	  
	  //clearing tasks using loop
      for (int i=2;i<=4;i++) {	  
	  String result = driver.findElementByXPath("(//android.view.View/android.view.View[2]/android.view.View["+i+"]/android.widget.TextView)").getText();	  
	  assertEquals(result, tasks[i-2]);
	  System.out.println("clearing the task: " + result);
      driver.findElementByXPath("(//android.view.View/android.view.View[2]/android.view.View["+i+"]/android.widget.TextView)").click();
	  }
	  //clearing task list
      driver.findElementByXPath("//android.view.View/android.view.View[3]/android.widget.TextView[2]").click();
      System.out.println("task list is cleared ");
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
