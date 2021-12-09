package activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1 {
	AndroidDriver<MobileElement> driver;
	
	@Test
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
		
		System.out.println("Calculator app is open");
			
	}
  
}
