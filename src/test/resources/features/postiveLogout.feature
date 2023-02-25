@regression
Feature: Successfully creating an account and logging out
  Scenario: Logout feature
    When User is on the site create an account and logout
    Then Click on Signup - Login button
    And Verify 'Login to your account' is visible
    Then Enter correct email address and password
    And User log in Verify that Logged in as 'Jose' is visible
    Then User Logs out and verify user is at the signup-login page 'https://automationexercise.com/login'