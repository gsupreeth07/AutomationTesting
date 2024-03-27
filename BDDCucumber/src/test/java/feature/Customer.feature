@s1
Feature: customer

  Scenario Outline: creating customer
    Given user is on application login page
    When login with valid credentials
    And user clicks on login button
    Then user click on task
    And click on add new
    And click on new customer
    Then user enter <customername> and <customerdescription>
    And click on create customer

    Examples: 
      | customername | customerdescription |
      | customer01    | customer01_des       |
      | customer02    | customer02_des       |
      | customer03    | customer03_des       |
      | customer04    | customer04_des       |
