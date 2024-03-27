Feature: customer

  Scenario Outline: creating customer
    Given user is on actitime login page
    When login with valid username and password credentials
    And user click on login
    Then user click on task page
    And click on add new in task page
    Then user create new <customer> and <customerdes>
      | customer     | customerdes    |
      | customer0121 | customer01_des |
      | customer0312 | customer02_des |
      | customer0431 | customer03_des |
      | customer0542 | customer04_des |
    And click on  customer button
