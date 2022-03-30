Feature: Verify the website Job Board System

@activity3
  Scenario:  Print the url of the header image to the console
    Given User is on Job Board System home page
    And Get the url of the header image
    And Print the url to the console
    Then Close the browser