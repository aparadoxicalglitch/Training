@combined @regression
Feature: FirstCry Flow with Invalid and Valid Inputs (Data-Driven from Excel)

  Background:
    Given User launches the FirstCry application
    And User enters mobile number "7004481495" and logs in

  Scenario: Full flow using Excel data for dropdown and pincode validations

    When User navigates to Store Locator page
    And User clicks on Search button without selecting dropdowns
    Then Error message "Please Select Store Type" should be displayed

    And User selects store type, state and city from Excel
    And User clicks on Search button
    Then Store name should be displayed

    When User navigates to Preschool Locator page
    And User enters "invalidPincode" pincode from Excel
    Then Error message "Ooopss…" should be displayed

    And User refreshes the Preschool Locator page
    And User enters "validPincode" pincode from Excel
    Then Preschool information should be displayed
