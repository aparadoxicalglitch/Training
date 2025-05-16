Feature: To test Login Functionality

  Scenario Outline: Login functionality check
    Given User is on login page
    When User enters <username> and <password>
    And Clicks on login button
    Then Login should be <result>

    Examples: 
      | username  | password    | result  |
      | student   | Password123 | success |
      | wrongUser | Password123 | failure |
