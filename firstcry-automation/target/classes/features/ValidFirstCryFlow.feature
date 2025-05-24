@valid @regression
Feature: Valid FirstCry Automation Flow

  Background:
    Given User launches the FirstCry application
    And User enters mobile number "7004481495" and logs in

  Scenario: Navigate from Store Locator to Preschool Locator with valid inputs
    When User navigates to Store Locator page
    And User selects store type "FirstCry", state "Maharashtra" and city "Pune Kharadi"
    And User clicks on Search button
    Then Store name should be displayed
    When User navigates to Preschool Locator page
    And User enters pincode "411014"
    Then Preschool information should be displayed
