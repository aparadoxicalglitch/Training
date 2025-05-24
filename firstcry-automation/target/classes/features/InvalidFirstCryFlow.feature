@invalid @regression
Feature: Invalid FirstCry Input Handling

  Background:
    Given User launches the FirstCry application
    And User enters mobile number "7004481495" and logs in

  Scenario: Navigate through Store Locator and Preschool Locator with invalid inputs
    When User navigates to Store Locator page
    And User clicks on Search button without selecting dropdowns
    Then Error message "Please Select Store Type" should be displayed
    When User navigates to Preschool Locator page
    And User enters pincode "633456"
    Then Error message "Ooopss…" should be displayed