package appiumProject;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Project_Activity1 {
	 AndroidDriver<MobileElement> driver;	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		 DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("deviceName", "Pixel4Emu");
		    caps.setCapability("platformName", "android");
		    caps.setCapability("automationName", "UiAutomator2");
		    caps.setCapability("appPackage", "com.google.android.apps.tasks");
		    caps.setCapability("appActivity", ".ui.TaskListsActivity");
		    caps.setCapability("noReset", true);
		    
		    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		    driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
		
	}
  @Test
  public void googleTask() {
	  
	  String[] titles = {"Complete Activity with Google Tasks","Complete Activity with Google Keep","Complete the second Activity Google Keep"};
	  WebDriverWait wait =new WebDriverWait(driver,10);
	//  wait.until(ExpectedConditions.visibilityOf(driver.findElementByAccessibilityId("Create new task")));
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task")));
	  
	  //find and click add (+) option - Then create a task 1
	  for(int i=0;i<titles.length;i++) {
		  MobileElement addbutton = driver.findElementByAccessibilityId("Create new task");
		  addbutton.click();
		  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
		  driver.findElementById("add_task_title").sendKeys(titles[i]);
		  driver.findElementById("add_task_done").click();
		 
	  }
	  	 
	  List<MobileElement> tasks = driver.findElementsByXPath("//android.view.View[@content-desc=\"Mark as complete\"]");
	  System.out.println(tasks.size());
	  
	  assertEquals(tasks.size(),2,"Task count Not matching");
	 
  }
  
@AfterClass
  public void teardown() {
	  driver.quit();
  }
}
