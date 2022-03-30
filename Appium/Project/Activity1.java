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

public class Activity1 {
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass()throws MalformedURLException {
	      DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	      //desiredCapabilities.setCapability("deviceName", "Emulator_Pixel");
	      desiredCapabilities.setCapability("deviceId", "ZY322B8WZK");
	      desiredCapabilities.setCapability("platformName", "android");
	      desiredCapabilities.setCapability("automationName", "UiAutomator2");
	      desiredCapabilities.setCapability("appPackage", "com.google.android.apps.tasks");
	      desiredCapabilities.setCapability("appActivity", ".ui.TaskListsActivity");
	      desiredCapabilities.setCapability("noReset", true);

	      URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	      driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
	      wait = new WebDriverWait(driver,10);

	  }

  @Test
  public void f() {
	  
	  MobileElement addTask = driver.findElementById("com.google.android.apps.tasks:id/tasks_fab");
	  addTask.click();
	  //creating task 1
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.apps.tasks:id/add_task_title"))).sendKeys("Complete Activity with Google Tasks");
	  MobileElement save = driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
	  save.click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.apps.tasks:id/task_name"))).isDisplayed();
	  String result = driver.findElementById("com.google.android.apps.tasks:id/task_name").getText();
	  System.out.println("task 1: " + result);
	  assertEquals(result,"Complete Activity with Google Tasks");
	  
	  //creating task 2
	  MobileElement addTask2 = driver.findElementById("com.google.android.apps.tasks:id/tasks_fab");
	  wait.until(ExpectedConditions.visibilityOf(addTask2)).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.apps.tasks:id/add_task_title"))).sendKeys("Complete Activity with Google Keep");
	  MobileElement save2 = driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
	  save2.click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.apps.tasks:id/task_name"))).isDisplayed();
	  String result2 = driver.findElementById("com.google.android.apps.tasks:id/task_name").getText();
	  System.out.println("task 2: " + result2);
	  assertEquals(result2,"Complete Activity with Google Keep");
	  
	  //creating task 3
	  MobileElement addTask3 = driver.findElementById("com.google.android.apps.tasks:id/tasks_fab");
	  wait.until(ExpectedConditions.visibilityOf(addTask3)).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.apps.tasks:id/add_task_title"))).sendKeys("Complete the second Activity Google Keep");
	  MobileElement save3 = driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
	  save3.click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.apps.tasks:id/task_name"))).isDisplayed();
	  String result3 = driver.findElementById("com.google.android.apps.tasks:id/task_name").getText();
	  System.out.println("task 3: " + result3);
	  assertEquals(result3,"Complete the second Activity Google Keep");
	
  }
 

  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

}
