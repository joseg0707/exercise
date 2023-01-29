Feature: Negative login with incorrect credentials 
  Scenario: Incorrect credentials
    When User Click on Signup and Login button
    And Verify 'Login to your account' is visible
    Then Enter incorrect email and password
    And Verify error 'Your email or password is incorrect!' is visible
