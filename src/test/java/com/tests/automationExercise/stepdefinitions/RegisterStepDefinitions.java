package com.tests.automationExercise.stepdefinitions;

import com.tests.automationExercise.pages.automationMainPage;
import com.tests.automationExercise.pages.deletedPage;
import com.tests.automationExercise.pages.loginPage;
import com.tests.automationExercise.pages.signupPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class RegisterStepDefinitions {
    WebDriver driver = DriverHelper.getDriver();

    automationMainPage mainPage = new automationMainPage(driver);
    loginPage loginPage = new loginPage(driver);
    signupPage signupPage = new signupPage(driver);
    deletedPage deletedPage= new deletedPage(driver);

    @Given("User Navigate to url verify that home page is visible successfully {string}")
    public void user_navigate_to_url(String url) {
        Assert.assertEquals(url,driver.getCurrentUrl().trim());
    }

    @And("User Click on Signup and Login button")
    public void userClickOnSignupAndLoginButton() {
        mainPage.SignUpButton();
    }
    @When("User is on Sign-up page Verify {string} is visible")
    public void user_is_on_sign_up_page_verify_is_visible(String expectedText) {
        Assert.assertEquals(expectedText, loginPage.signupText());
    }
    @When("Enter {string} and {string} address and Click Signup button")
    public void enter_name_and_email_address_and_click_signup_button(String name, String email) {
        loginPage.newUser(name,email);
    }
    @Then("Verify that {string} is visible")
    public void verify_that_is_visible(String expectedText) {
        Assert.assertEquals(expectedText, signupPage.accountInfoText());
    }
    @And("Fill details: title, {string}, DOB {string} {string} {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and Click Create Account button")
    public void fillDetailsTitlePasswordDOBDayMonthYearFirstNameLastNameAddressCountryStateCityZipcodeNumber(String password, String day, String month, String year,
      String firstName, String lastName, String address, String country, String state, String city, String zip, String phoneNumber ) {
        signupPage.accountInformation(password, day, month, year, firstName, lastName,
                address, country, state, city, zip, phoneNumber);
    }

    @When("User creates an account Verify that {string} is visible and Click Continue button")
    public void user_creates_an_account_verify_that_is_visible_and_click_button(String expectedText) throws InterruptedException {
        Assert.assertEquals(expectedText, signupPage.createdText());
        signupPage.continueButton();

    }

    @Then("Verify if username Logged in as {string} is visible")
    public void verifyIfUsernameLoggedInAsUsernameIsVisible(String expectedText) {
        Assert.assertEquals(expectedText, mainPage.loggedInAs());
    }
    @Then("Click Delete Account button")
    public void click_button() throws InterruptedException {
        mainPage.deleteButton();
    }
    @Then("Verify that {string} is visible and click Continue button")
    public void verify_that_is_visible_and_click_button(String expectedText) throws InterruptedException {
        Assert.assertEquals(expectedText, deletedPage.deletedAccountText());
        deletedPage.continueButton();
    }

}
