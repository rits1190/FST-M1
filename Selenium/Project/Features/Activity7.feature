Feature: Verify the website Job Board System

@activity7
  Scenario:  Create a new job listing
    Given User is on Job Board System home page
    When Find a navigation bar and click on Post a Job
    And Fill in the necessary details and click the review button
    Then Click the submit button
    Then Verify that the job listing was posted by visiting the jobs page
    Then Close the browser for activity7