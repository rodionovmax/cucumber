Feature: LoginFeature
  This feature deals this login functionality of the application

  Scenario: Login with correct username and password
    Given I navigate to login page of the application
    And I enter following for login
      | username | password      |
      | admin    | adminpassword |
    And I click login button
    Then I should see the userform page

  Scenario: Login with correct username and password to fail
    Given I navigate to login page of the application
    And I enter following for login
      | username | password      |
      | admin    | adminpassword |
    And I click login button
    Then I should see the userform page wrongly