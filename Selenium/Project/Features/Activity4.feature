Feature: Verify the website Job Board System

@activity4
  Scenario:  Read the second heading of the website and verify the text
    Given User is on Job Board System home page
    When Verify second heading of the website
    And Verify second heading matches matchstring exactly
    Then Close the browser for activity4
    