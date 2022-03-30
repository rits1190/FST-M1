Feature: Verify the website Job Board System

@activity1
  Scenario: Read the title of the website and verify the text
    Given User is on Job Board System home page
    When Verify title of the website
    And Verify title matches matchString exactly
    Then Close the browser for activity1