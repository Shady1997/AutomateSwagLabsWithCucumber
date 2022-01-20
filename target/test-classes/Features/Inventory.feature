#this automation script created by shady ahmed
@SmokeScenario
Feature: Feature to select all products in inventory page

  @SmokeTest
  Scenario: check all products in page
    Given user choose all products in inventory page
    When click backet image
    Then user navigate to next page to review selected products
