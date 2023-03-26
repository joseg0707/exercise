@regression
@Reregression

  Feature: Send a contact form successfully
    Scenario: User is able to submit a contact us form for any issues
      Given User Navigate to url verify that home page is visible successfully 'https://automationexercise.com/'
      When user is at the homepage and click on Contact Us button
      Then At the contact page Verify 'GET IN TOUCH' is visible
      And Complete the form  by entering name, email, subject, message and upload a file
      Then Submits the form and clicks the Ok Button to continue
      When form has been completed and submitted verify 'Success! Your details have been submitted successfully.' is visible
      Then User clicks Home Button and verify User is navigated to the homepage


