Feature: Google translate
  Tests that Google translate can translate a sentence correctly

  @Translation_Test
  Scenario Outline: Translating "Hello" in foreign languages returns Hello in English
    Given I am on the Google homepage
    When I enter the term "<searchTerm>" and search
    And I enter the term "<termToTranslate>" into the translation
    Then The term "Hello" appears as the translated term
    Examples:
    |searchTerm                   |termToTranslate|
    |Translate french to english  |Bonjour        |
    |Translate italian to english |Ciao           |
    |Translate german to english  |Hallo          |
    |Translate polish to english  |halo           |