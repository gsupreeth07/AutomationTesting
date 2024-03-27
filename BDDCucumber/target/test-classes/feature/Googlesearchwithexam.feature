Feature: googleserch with exampl

  Scenario Outline:  Search
    Given user is on Google page
    When user enter <texttosearch> in searchBox
    And click on Search button
    Then user Navigate to results page
    And user print all the hyperlinks

    Examples: 
      | texttosearch |
      | IBM          |
      | wipro        |
      | oracle       |
      | hp           |
      | capgemini    |
