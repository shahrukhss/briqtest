Feature: Login Action

  Scenario Outline: get crane details for the city
    Given user wants crane details for "<cityName>"
    And user clicks on view on the map button
    Then close the browser

Examples:
    | cityName |
    | seattle  |