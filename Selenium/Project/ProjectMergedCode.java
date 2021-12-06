package com.ibm.SeleniumProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class ProjectMergedCode {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
		

		Assert.assertEquals(driver.getTitle(), "Alchemy LMS – An LMS Application");
		System.out.println("Title is correct");

		Assert.assertEquals(
				driver.findElement(By.xpath("//h1[contains(text(),'Learn from Industry Experts')]")).getText(),
				"Learn from Industry Experts");
		System.out.println("Heading is correct");

		Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'Actionable Training')]")).getText(),
				"Actionable Training");
		System.out.println("Firstbox wording is correct");

		Assert.assertEquals(
				driver.findElement(By.xpath("//h3[contains(text(),'Email Marketing Strategies')]")).getText(),
				"Email Marketing Strategies");
		System.out.println("Secondmost popular course is correct");
		
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		 driver.findElement(By.id("user_login")).sendKeys("root");
		  driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		  driver.findElement(By.id("wp-submit")).click();
		  
		  
		driver.findElement(By.xpath("//a[contains(.,'Howdy')]")).isDisplayed();
		driver.findElement(By.xpath("//a[contains(text(),'All Courses')]")).click();
		
		List<WebElement> list = driver.findElements(By.cssSelector(".caption .entry-title"));
		
		System.out.println("All courses are:-");
		for(int i =0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
		}
		
		driver.findElement(By.xpath("//a[contains(text(),'Contact')]")).click();
		driver.findElement(By.id("wpforms-8-field_0")).sendKeys("Ritika");
		driver.findElement(By.id("wpforms-8-field_1")).sendKeys("rits@xyz.com");
		driver.findElement(By.id("wpforms-8-field_3")).sendKeys("Chemistry");
		driver.findElement(By.id("wpforms-8-field_2")).sendKeys("Hello Ritika Message");
		driver.findElement(By.id("wpforms-submit-8")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'All Courses')]")).click();
		driver.findElement(By.xpath("//h3[contains(text(),'Social Media Marketing')]/../p[contains(@class,'ld_course_grid_button')]/a")).click();
		driver.findElement(By.xpath("//div[contains(.,'Developing Strategy') and (@class='ld-item-title')]")).click();
		
		driver.findElement(By.xpath("//h1[contains(text(),'Developing Strategy')]")).isDisplayed();
		
	}

}
