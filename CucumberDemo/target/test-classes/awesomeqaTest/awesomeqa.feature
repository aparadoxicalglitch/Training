@tag
Feature: Login feature of awesomeqa application
  I want to login in awesomeqa application using valid credentials.

  @tag1
  Scenario: Login in awesomeqa using valid credentials
    Given I am in login page of awesomeqa applicaton
    When I enter the username
    When I enter the password
    And I click on login button
    Then I am in my account details page
    
    @tag2
    Scenario: Login in awesomeqa using invalid credentials
    Given I am in login page of awesomeqa application
    When I enter invalid username
    When I enter invalid password
    And I click on loginn button
    Then Error message is displayed