@regression
Feature: Verify Test Cases Page
  Scenario: User is able to navigate to test cases
    When User is at the home page
    Then User click the test cases section
    When User is on the test cases page verify Test Cases is visible "TEST CASES"
    Then Verify user is at the Test Cases Page
