@login
Feature: As a user, I should be able to login

  Scenario Outline: Verify login with valid credentials
    Given user on the login page
    When user use username "<username>" and passcode "<password>"
    And user click the login button
    Then verify the user should be at the dashboard page

    Examples:
      | username | password    |
      | user16   | Userpass123 |
      | user46   | Userpass123 |
      | user76   | Userpass123 |
      | user106  | Userpass123 |