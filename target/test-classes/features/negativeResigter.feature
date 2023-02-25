@regression
Feature: Register User with existing email
  Scenario: User tries to make an account with an existing email
    When User Click on Signup and Login button
    Then User is on Sign-up page Verify 'New User Signup!' is visible
    And User tries to signup using an existing email
    Then Verify the error message 'Email Address already exist!' is visible