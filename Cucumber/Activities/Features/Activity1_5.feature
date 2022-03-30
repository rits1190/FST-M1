
@activity1_5
Feature: Login Test

  @tag1
  Scenario Outline: Testing Login with Example
    Given User is on Login page
    When User enters "<Usernames>" and "<Passwords>"
    Then Read the page title and confirmation message
    And Close the browser for activity5


Examples:
    | Usernames | Passwords |
    | admin     | password  |
    | adminUser | Password  |
