package com.ibm.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("about-link")).isDisplayed();
		driver.findElement(By.className("ui inverted huge green button")).isDisplayed();
		driver.findElement(By.linkText("About Us")).isDisplayed();
		driver.findElement(By.cssSelector("#about-link")).isDisplayed();
		System.out.println(driver.findElement(By.cssSelector("#about-link")).getText());
		driver.close();

	}

}
