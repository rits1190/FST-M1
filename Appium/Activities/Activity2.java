package activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2 {
	WebDriverWait wait;
	AndroidDriver<MobileElement> driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps =new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel4Emu");
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);
		
		URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		driver =new AndroidDriver<MobileElement>(remoteUrl,caps);
		
		wait = new WebDriverWait(driver, 10);
			
	}
	
	@Test
	public void chromeTest() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.training-support.net/");
		
		
		
		String title=driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
		
		System.out.println(title);
		// Click about us link
		driver.findElementByXPath("//android.view.View[@content-desc='About Us']").click();
        String newtitle =driver
                .findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]")
                .getText();
 
        System.out.println("Title on new page: " + newtitle);
		
	}

}
