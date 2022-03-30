Feature: Verify the website Job Board System

@activity9
  Scenario:  visit the site’s backend and login
    Given User opens the browser and navigate to backend site
    Then User fills login form and hit enter
    And Verify user logged in successfully
    Then Locate Job Listing and click add new job
    Then Fill in the deails for new job
    And Verify new job listing is created
    Then Close the browser for activity9