Feature: Unit converter
  Tests the unit conversion functionality

  @Conversion_Test
  Scenario: Converting kilometres to miles returns the correct value
    Given I am on the Google homepage
    When I enter the term "unit converter" and search
    And I convert "10" kilometres to miles
    Then The value "6.21371" should appear in the conversion

  @Conversion_Test
  Scenario: Converting pounds to kilograms returns the correct value
    Given I am on the Google homepage
    When I enter the term "unit converter" and search
    And I convert "10" pounds to kilograms
    Then The value "4.53592" should appear in the conversion