package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity3 {
	AndroidDriver<MobileElement> driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps =new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel4Emu");
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.android.calculator2");
		caps.setCapability("appActivity", ".Calculator");
		caps.setCapability("noReset", true);
		
		URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		driver =new AndroidDriver<MobileElement>(remoteUrl,caps);
				
	}
	
  @Test
  public void add() {
	  driver.findElementById("digit_5").click();
	  driver.findElementById("op_add").click();
	  driver.findElementById("digit_9").click();
	  driver.findElementByAccessibilityId("equals").click();
	  String resultText= driver.findElementById("result").getText();
	  System.out.println(resultText);
	  
	  assertEquals(resultText,"14");
	  }
  
  @Test
  public void subtract() {
	  driver.findElementById("digit_1").click();
	  driver.findElementById("digit_0").click();
	  driver.findElementById("op_sub").click();
	  driver.findElementById("digit_5").click();
	  driver.findElementByAccessibilityId("equals").click();
	  String resultText= driver.findElementById("result").getText();
	  System.out.println(resultText);
	  
	  assertEquals(resultText,"5");
	 
  }
  
  @Test
  public void mul() {
	  driver.findElementById("digit_5").click();
	  driver.findElementById("op_mul").click();
	  driver.findElementById("digit_1").click();
	  driver.findElementById("digit_0").click();
	  driver.findElementById("digit_0").click();
	  driver.findElementByAccessibilityId("equals").click();
	  String resultText= driver.findElementById("result").getText();
	  System.out.println(resultText);
	  
	  assertEquals(resultText,"500");
	 
  }
  
  @Test
  public void div() {
	  driver.findElementById("digit_5").click();
	  driver.findElementById("digit_0").click();
	  driver.findElementById("op_div").click();
	  driver.findElementById("digit_2").click();
	  driver.findElementByAccessibilityId("equals").click();
	  String resultText= driver.findElementById("result").getText();
	  System.out.println(resultText);
	  
	  assertEquals(resultText,"25");
	 
  }
  
}
