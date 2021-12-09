@activity5
Feature: Data driven test with Example

Scenario Outline: Testing with Data from Scenario
    Given User on Login page
    When User credential "<Usernames>" and "<Passwords>"
    Then Read the title of the page and confirmation message
    And teardown steps
    
Examples:
    | Usernames | Passwords |
    | admin     | password  |
    | adminUser | Password  |