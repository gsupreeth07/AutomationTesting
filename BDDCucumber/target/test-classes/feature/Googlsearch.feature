Feature: Google Search

  Scenario: Search for DigiSoft
    Given user is on Google Homepage
    When  enter a "IBM" in searchBox
    And user print all the hyperlinks in google homepage
