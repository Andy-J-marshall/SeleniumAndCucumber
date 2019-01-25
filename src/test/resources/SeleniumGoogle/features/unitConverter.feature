Feature: Unit converter
  Tests the unit conversion functionality

  @Conversion_Test
  Scenario: Converting feet to miles returns the correct value
    Given I am on the Google homepage
    When I enter the term "unit converter" and search
    And I convert "1000" feet to miles
    Then The value "0.189394" should appear in the conversion

  @Conversion_Test
  Scenario: Converting pounds to kilograms returns the correct value
    Given I am on the Google homepage
    When I enter the term "unit converter" and search
    And I convert "10" pounds to kilograms
    Then The value "4.53592" should appear in the conversion