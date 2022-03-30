Feature: Verify the website Job Board System

@activity8
  Scenario:  visit the site’s backend and login
    Given User opens the browser and navigate to backend site
    Then User fills login form and hit enter
    And Verify user logged in successfully
    Then Close the browser for activity8