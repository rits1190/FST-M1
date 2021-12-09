package appiumProject;



import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

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

public class Project_Activity3 {
	
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
  public void googlekeep() throws InterruptedException {
	  
	  WebDriverWait wait =new WebDriverWait(driver,30);
	
		
		
	  
	  //find and click + button
	  
	  MobileElement addbutton = driver.findElementByAccessibilityId("New text note");
	  addbutton.click();
	  MobileElement title =driver.findElementById("editable_title");
	  title.sendKeys("Task 3");
	  
	  MobileElement note = driver.findElementById("edit_note_text");
	  note.sendKeys("complete 3rd activity");
	  
	  // click on reminder
	  MobileElement reminder = driver.findElementByAccessibilityId("Reminder");
	  reminder.click();
	  // find and date picker
	  
	  MobileElement dataPicker =driver.findElementByXPath("//*[@resource-id='com.google.android.keep:id/bs_list_view']/android.widget.LinearLayout");
	  dataPicker.click();
	  
	 // Thread.sleep(30);
	 
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.xpath("(//*[@resource-id='com.google.android.keep:id/text'])[2]")));
			  
	 
	 MobileElement time =driver.findElementByXPath("(//*[@resource-id='com.google.android.keep:id/text'])[2]");
	  time.click();
	  
	//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.xpath("//*[@resource-id='com.google.android.keep:id/reminder_time_evening']")));
	  
	  
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.xpath("(//*[@resource-id='com.google.android.keep:id/text'])[4]")));
	  
	 System.out.println("waiting in data picker is over");
	  Thread.sleep(30);
	  
	  // pick afternoon
//	  driver.findElementByXPath("//*[@resource-id='com.google.android.keep:id/reminder_time_afternoon']").click();
	
	  // pick evening
	 // driver.findElementByXPath("//*[@resource-id='com.google.android.keep:id/reminder_time_evening']").click();
	  driver.findElementByXPath("(//*[@resource-id='com.google.android.keep:id/text'])[4]").click();
	  
	  //click save
	  driver.findElementById("save").click();
	  
	//  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Open navigation drawer")));

	  Thread.sleep(30);  	  	  
	  // find back arrow and click
	  
	  MobileElement backArrow = driver.findElementByAccessibilityId("Open navigation drawer");
	  backArrow.click();
	  
	  
	  // click on options at top left( 3 horizontal lines)
	  driver.findElementByAccessibilityId("Open navigation drawer").click();
	  
	  //click reminders 
	  driver.findElementById("drawer_navigation_reminders").click();
	  
	  driver.findElementById("browse_note_interior_content").click();
	  
	  
	  //Adding assertion to see above task is added and  timer exists
	  String taskName = driver.findElementById("index_note_title").getText();
	  assertEquals(taskName,"Task 3");
	   
	  assertTrue(driver.findElementById("reminder_chip_icon")!=null);
	  
	  
  }
  @AfterClass
  public void teardown() {
	  driver.quit();
  }

}
