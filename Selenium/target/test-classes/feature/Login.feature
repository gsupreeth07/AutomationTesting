Feature: feature to validate login functionality

  Scenario: Check the login with valid credentials
    Given user is on login page
    When user enter username and password
    And click on login button
    Then user is navigate to homepage

  Scenario: Check the login with invalid credentials
    Given user is on login page
    When user enter inavalid username and valid password
    And click on login button
    Then user get a warning message

  Scenario: Check the login with invalid credentials
    Given user is on login page
    When user enter valid username and invalid password
    And click on login button
    Then user get a warning message

  Scenario: Check the login with withblank fields
    Given user is on login page
    When user not enter username and possword
    And click on login button
    Then user get a warning message
