@activity1
Feature: First Test

@SmokeTest
Scenario: Opening a webpage using Selenium
	Given User is on Google Home Page
	When User Types in Cheese and hits ENTER
	Then Show how many search results were shown
	And close the browser
	



