Feature: Verify the website Job Board System
@activity5
  Scenario:  Navigate to the “Jobs” page on the site
    Given User is on Job Board System home page
    When Find a navigation bar and click on Jobs
    And Verify title of the Jobs page
    Then Close the browser for activity5
    