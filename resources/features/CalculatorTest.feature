@tag
Feature: As a calculator user I should be able to perform square root of numbers

 @DesktopAutomation
 Scenario Outline: Validate Calculator to perform Square Root
    Given I open Windows Calculator Application
    When  I enter number "65575"
    And click on square root button
    Then the calculate result should be correct
    Examples: 
      | number  |
      | 65575   |
