Feature: Verify the website Job Board System

@activity6
  Scenario:  Search for a job and apply for it
    Given User is on Job Board System home page
    When Find a navigation bar and click on Jobs
    And Search for banking job and and open any one of the jobs listed
    Then Click the apply button and print the email to the console
    Then Close the browser for activity6
    