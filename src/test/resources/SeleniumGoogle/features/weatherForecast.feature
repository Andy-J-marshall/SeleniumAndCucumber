Feature: Weather forecast
  Tests the weather forecast functionality

  @Forecast_Test
  Scenario: Searching for the weather in MK should return the required information
    Given I am on the Google homepage
    When I enter the term "Weather Milton Keynes" and search
    Then the weather forecast for my location should appear