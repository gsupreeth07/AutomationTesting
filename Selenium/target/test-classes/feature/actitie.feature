Feature: feature to validate login functionality of application

  Scenario Outline:  Check the login functionality with valid credentials
    Given admin is on login page
    When user enter <username> and <password>
    And click on login 
    Then user is navigate to actitime page
    Examples:
|username|password|
|admin|manager|
    

  Scenario Outline: Check the login functionality with invalid credentials
    Given admin is on login page
    When user enter <invalid username> and <valid password>
    And click on login 
    Then user get a warning messages
    
     Examples:
|invalid username|valid password|
|admi|password|

  Scenario Outline: Check the login functionality with invalid credentials
    Given admin is on login page
    When user enter <valid username> and <invalid password>
    And click on login 
    Then user get a warning messages
    
     Examples:
|valid username|invalid password|
|admin|passwor|

  Scenario: Check the login functionality with withblank fields
    Given admin is on login page
    When user not enter username and password
    And click on login 
    Then user get a warning messages
    
