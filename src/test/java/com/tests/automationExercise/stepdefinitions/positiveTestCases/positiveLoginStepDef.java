package com.tests.automationExercise.stepdefinitions.positiveTestCases;

import com.tests.automationExercise.pages.automationMainPage;
import com.tests.automationExercise.pages.deletedPage;
import com.tests.automationExercise.pages.loginPage;
import com.tests.automationExercise.pages.signupPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class positiveLoginStepDef {

    WebDriver driver = DriverHelper.getDriver();

    automationMainPage mainPage = new automationMainPage(driver);
    loginPage loginPage = new loginPage(driver);
    signupPage signupPage = new signupPage(driver);
    deletedPage deletedPage = new deletedPage(driver);

    @When("User is on the site create an account and logout")
    public void user_is_on_the_site_create_an_account_and_logout() throws InterruptedException {
        mainPage.SignUpButton();
        loginPage.newUser(ConfigReader.readProperty("name"), ConfigReader.readProperty("email"));
        signupPage.accountInformation(ConfigReader.readProperty("password"), ConfigReader.readProperty("day")
                , ConfigReader.readProperty("month"),ConfigReader.readProperty("year")
                ,ConfigReader.readProperty("name"),ConfigReader.readProperty("lastName")
                ,ConfigReader.readProperty("Street"), ConfigReader.readProperty("country")
                ,ConfigReader.readProperty("state"),ConfigReader.readProperty("city")
                ,ConfigReader.readProperty("zip"),ConfigReader.readProperty("phoneNumber"));
        signupPage.continueButton();
    }
    @Then("Click on Signup - Login button")
    public void click_on_signup_login_button() {
        mainPage.logoutButton();
    }
    @Then("Verify {string} is visible")
    public void verify_is_visible(String actualText) {
        Assert.assertEquals(loginPage.loginText(), actualText);
    }
    @Then("Enter correct email address and password")
    public void enter_correct_email_address_and_password() {
        loginPage.loginExistingUser(ConfigReader.readProperty("email"), ConfigReader.readProperty("password"));
    }

    @When("User log in Verify that Logged in as {string} is visible")
    public void user_log_in_verify_that_is_visible(String expectedText) {
        Assert.assertEquals(expectedText, mainPage.loggedInAs());
    }
    @Then("User Click Delete Account button")
    public void click_button() throws InterruptedException {
        mainPage.deleteButton();
    }
    @Then("User Verify that {string} is visible")
    public void user_verify_that_is_visible(String expectedText) {
        Assert.assertEquals(expectedText, deletedPage.deletedAccountText());
    }
}
