@regression

Feature: Testing negative and positive register/login functionality
  Scenario: Register User
    Given User Navigate to url verify that home page is visible successfully 'https://automationexercise.com/'
    And User Click on Signup and Login button
    When User is on Sign-up page Verify 'New User Signup!' is visible
    And Enter 'Jose' and 'joseg@gmail.com' address and Click Signup button
    Then Verify that 'ENTER ACCOUNT INFORMATION' is visible
    And Fill details: title, 'jose1234', DOB '5' '5' '2001', 'Jose', 'Gonzalez', '123 Street Ave', 'United States', 'IL', 'Des Plaines', '41243', '2121231234' and Click Create Account button
    When User creates an account Verify that 'ACCOUNT CREATED!' is visible and Click Continue button
    Then Verify if username Logged in as 'Jose' is visible
    And Click Delete Account button
    Then Verify that 'ACCOUNT DELETED!' is visible and click Continue button


