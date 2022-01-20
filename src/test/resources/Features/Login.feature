#this automation script created by shady ahmed
@SmokeScnario
Feature: Feature to test login functionality to swag labs web application

  @SmokeTest
  Scenario: Check if login is successfully with valid Credientials
    Given user is in login page
    When user add valid username and password
    And click login button
    Then user navigate to home page

  Scenario Outline: Check Login is successfully with invalid Credientials
    Given user is in login page
    When user enter <username> and <password>
    And click login button
    Then user will not navigate to home page

    Examples: 
      | username | password |
      | shady    | Passw0rd |
      | test     | Password |
