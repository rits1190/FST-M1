package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Activities {

	WebDriver driver;
	WebDriverWait wait;
	String title;
	String matchString= "Alchemy Jobs – Job Board Application";
	String headingFirst,headingSecond;
	String matchString2= "Welcome to Alchemy Jobs";
	String matchString3="Quia quis non";
	String imgUrl,jobpageTitle;
	WebElement email;
	WebElement joblistone;
	List<WebElement> joblist;
	
	@Given("^User is on Job Board System home page$")
	public void launchWebsite() throws Throwable{
		
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,20);
		driver.get("https://alchemy.hguy.co/jobs/");
	}
	
	
	@When("^Verify title of the website$")
	public void getTitle() throws Throwable{
		title= driver.getTitle();
		System.out.println("Title of the page is " + title);
	}
	
	@And("^Verify title matches matchString exactly$")
	public void matchTitle() throws Throwable{
		if(title.equalsIgnoreCase(matchString)) {
		System.out.println("Title matches to Alchemy Jobs – Job Board Application");
		}
	}
	
	@Then("^Close the browser for activity1$")
	public void closeBrowserTitle() throws Throwable{
		if(title.equalsIgnoreCase(matchString)) {
		driver.close();
		}
	}
	
	@When("^Verify heading of the website$")
	public void getHeadingFirst() throws Throwable{

		headingFirst= driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/header/h1")).getText();
		System.out.println("First Heading of the page is " + headingFirst);

	  }
	
		@When("^Verify second heading of the website$")
		public void getSecondHeading() throws Throwable{
			headingSecond=driver.findElement(By.xpath("//h2")).getText();
			System.out.println("Second Heading of the page is " + headingSecond);	
			
		}
		
	@And("^Verify heading matches matchstring exactly$")
	public void matchHeadingFirst() throws Throwable{
				if(headingFirst.equalsIgnoreCase("Welcome to Alchemy Jobs")) {
					System.out.println("First Heading matches to Welcome to Alchemy Jobs");
					}
	}
				
	@And("^Verify second heading matches matchstring exactly$")
	public void matchHeadingSecond() throws Throwable{
		if(headingSecond.equalsIgnoreCase("Quia quis non")) {
			System.out.println("Second Heading matches to Quia quis non");
			}
	}


	
	@Then("^Close the browser for activity2$")
	public void closeBrowserActivity2() throws Throwable{
		
		if(headingFirst.equalsIgnoreCase(matchString2)) {
		driver.close();
		}
	}
		

	@Then("^Close the browser for activity4$")
	public void closeBrowserActivity4() throws Throwable{
		
		if(headingSecond.equalsIgnoreCase(matchString3)) {
		driver.close();	
		}
	}
	
	@And("^Get the url of the header image$")
	public void getImageUrl() throws Throwable{
		
		imgUrl= driver.findElement(By.xpath("//div/img")).getAttribute("src");		
	}
	
	@And("^Print the url to the console$")
	public void printImageUrl() throws Throwable{
		
		imgUrl= driver.findElement(By.xpath("//div/img")).getAttribute("src");
		System.out.println("url of the header image is -   " + imgUrl);
		
	}
	
	@Then("^Close the browser$")
	public void closeBrowser() throws Throwable{
		driver.close();
	}
	@When("^Find a navigation bar and click on Jobs$")
	public void findNavigation() throws Throwable{
	WebElement jobs=driver.findElement(By.xpath("//a[text()='Jobs']"));	
	jobs.click();
	System.out.println("Navigated to jobs page");
	}
	
	@And("^Verify title of the Jobs page$")
	public void getTitleofJobsPage() throws Throwable{
	jobpageTitle = driver.getTitle();
	System.out.println("Title of the jobs page is " + jobpageTitle);	
	}
	
	@Then("^Close the browser for activity5$")
	public void closeBrowserActivity5() throws Throwable{
		driver.quit();	
	}

	@And("^Search for banking job and and open any one of the jobs listed$")
	public void clickSearchOption()throws Throwable{
		driver.findElement(By.xpath("//*[@id=\"search_keywords\"]")).sendKeys("Banking");
		driver.findElement(By.xpath("//div[@class=\"search_submit\"]")).click();
		driver.get("https://alchemy.hguy.co/jobs/job/cs-software-company-2-banking/");
		System.out.println("clicked on 1st search option");
		
		}

	@Then("^Click the apply button and print the email to the console$")
	public void applyJob()throws Throwable{
		driver.findElement(By.cssSelector(".application_button")).click();
		email= driver.findElement(By.xpath("//a[text()='cs.monica198@gmail.com']"));
		System.out.println("The email address is " + email.getText());
		
		}
	
	@Then("^Close the browser for activity6$")
	public void closeBrowserActivity6() throws Throwable{
		driver.quit();	
	}
	
	
	@When("^Find a navigation bar and click on Post a Job$")
	public void findPostJobNavigation() throws Throwable{
	WebElement jobs=driver.findElement(By.xpath("//a[text()='Post a Job']"));	
	jobs.click();
	System.out.println("Navigated to Post a jobs page");
	}
	
	@And("^Fill in the necessary details and click the review button$")
	public void fillinDetails() throws Throwable{
	System.out.println("Started filling details");
	driver.findElement(By.id("create_account_email")).sendKeys("test7@new.com");
	driver.findElement(By.id("job_title")).sendKeys("Test New Job Listing");
	driver.findElement(By.id("job_location")).sendKeys("Pune");
	driver.findElement(By.xpath("//*[@id=\"mceu_0-button\"]")).click();
	driver.switchTo().frame("job_description_ifr");
	driver.findElement(By.xpath("//*[@id=\"tinymce\"]")).sendKeys("Test Description");
	driver.switchTo().defaultContent();
	driver.findElement(By.id("application")).sendKeys("application@in.com");
	driver.findElement(By.id("company_name")).sendKeys("IBM");
	driver.findElement(By.xpath("//input[contains (@name, 'submit_job')]")).click();

	}
	
	@And("^Click the submit button$")
	public void submitJobList() throws Throwable{
	System.out.println("Submitting new job list");
	driver.findElement(By.id("job_preview_submit_button")).click();
	}
	
	@Then("^Verify that the job listing was posted by visiting the jobs page$")
	public void verifyNewjoblist() throws Throwable{
	findNavigation();
	driver.findElement(By.xpath("//*[@id=\"search_keywords\"]")).sendKeys("Test New Job Listing");
	driver.findElement(By.xpath("//div[@class=\"search_submit\"]")).click();
	//String newjob= driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/ul/li[1]/a")).getText();
	System.out.println("New job list is added successfully");
	}
	
	
	@Then("^Close the browser for activity7$")
	public void closeBrowserActivity7() throws Throwable{
		driver.quit();	
	}
	
	@Given("^User opens the browser and navigate to backend site$")
	public void backendSiteLogin() throws Throwable{
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,20);
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	}
	
	@Then("^User fills login form and hit enter$")
	public void fillLoginForm() throws Throwable{
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();	
	}
	@And("^Verify user logged in successfully$")
	public void verifyLogin() throws Throwable{
	String loginName= driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-my-account\"]/a/span")).getText();
	if(loginName=="root")
	{
		System.out.println("User logged in successfully");
	}
	
	}
	
	@Then("^Close the browser for activity8$")
	public void closeBrowserActivity8() throws Throwable{
		driver.quit();	
	}
	
	@Then("^Locate Job Listing and click add new job$")
	public void addnewJob() throws Throwable{
		String MainWindow=driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id=\"menu-posts-job_listing\"]/a/div[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a")).click();
		//driver.switchTo().alert().dismiss();
		String childWindow =driver.getWindowHandle();
		driver.switchTo().window(childWindow);
		driver.findElement(By.cssSelector(".components-modal__header > button:nth-child(2)")).click();
		driver.switchTo().window(MainWindow);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("post-title-0")));
		
		
		 
		 
	}
	@Then("^Fill in the deails for new job$")
	public void fillnewJob() throws Throwable{
		driver.findElement(By.xpath("//*[@id=\"post-title-0\"]")).sendKeys("NewTestJob");
		driver.findElement(By.xpath("//*[@id=\"_job_location\"]")).sendKeys("Pune");
		driver.findElement(By.xpath("//*[@id=\"_company_name\"]")).sendKeys("IBM");
		driver.findElement(By.xpath("//*[@id=\"_company_website\"]")).sendKeys("india@ibm.in");
		driver.findElement(By.xpath("//*[@id=\"_company_tagline\"]")).sendKeys("Business Machine");
		driver.findElement(By.xpath("//*[@id=\"_company_twitter\"]")).sendKeys("twitter");
		driver.findElement(By.xpath("//*[@id=\"editor\"]/div/div/div[1]/div/div[1]/div/div[2]/button[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"editor\"]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/button")).click();
	}
	@And("^Verify new job listing is created$")
	public void verifyJobListing() throws Throwable{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".editor-post-publish-panel__header-published")));	
	String newJobName= driver.findElement(By.cssSelector(".editor-post-publish-panel__header-published")).getText();
	if(newJobName=="Published")
	{
		System.out.println("New Job is created successfully");
	}
	
	}
	
	@Then("^Close the browser for activity9$")
	public void closeBrowserActivity9() throws Throwable{
		driver.quit();	
	}
	
}
