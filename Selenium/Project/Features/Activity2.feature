Feature: Verify the website Job Board System

@activity2
  Scenario: Read the heading of the website and verify the text
    Given User is on Job Board System home page
    When Verify heading of the website
    And Verify heading matches matchstring exactly
    Then Close the browser for activity2