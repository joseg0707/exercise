@regression
Feature: Navigate page to page
  Scenario: User navigates from home page to test cases page
    When User is at home page
    Then User clicks on test case and verify its loaded successfully