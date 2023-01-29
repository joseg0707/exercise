@regression

Feature: Login User with correct email and password
  Scenario: Positive Login with correct credentials
      When User is on the site create an account and logout
      Then Click on Signup - Login button
      And Verify 'Login to your account' is visible
      Then Enter correct email address and password
      When User log in Verify that Logged in as 'Jose' is visible
      Then User Click Delete Account button
      And User Verify that 'ACCOUNT DELETED!' is visible