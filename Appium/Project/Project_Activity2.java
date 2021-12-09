package appiumProject;



import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Project_Activity2 {
	
	 AndroidDriver<MobileElement> driver;	
		@BeforeClass
		public void setUp() throws MalformedURLException {
			 DesiredCapabilities caps = new DesiredCapabilities();
			    caps.setCapability("deviceName", "Pixel4Emu");
			    caps.setCapability("platformName", "android");
			    caps.setCapability("automationName", "UiAutomator2");
			    caps.setCapability("appPackage", "com.google.android.keep");
			    caps.setCapability("appActivity", ".activities.BrowseActivity");
			    caps.setCapability("noReset", true);
			    
			    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
			    driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
			
		}
  @Test
  public void googlekeep() {
	  
	  //find and click + button
	  
	  MobileElement addbutton = driver.findElementByAccessibilityId("New text note");
	  addbutton.click();
	  MobileElement title =driver.findElementById("editable_title");
	  title.sendKeys("Task 1");
	  
	  MobileElement note = driver.findElementById("edit_note_text");
	  note.sendKeys("complete 2nd activity");
	  	  
	  // find back arrow and click
	  
	  MobileElement backArrow = driver.findElementByAccessibilityId("Open navigation drawer");
	  backArrow.click();
	  
	  //Adding assertion to see above task is added
	  String taskName = driver.findElementById("index_note_title").getText();
	  assertEquals(taskName,"Task 1");
	  
	
  }
  @AfterClass
  public void teardown() {
	  driver.quit();
  }

}
