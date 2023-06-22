package com.tests.automationExercise.stepdefinitions;

import com.tests.automationExercise.pages.loginPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class negativeRegisterStepDef {
    WebDriver driver = DriverHelper.getDriver();
    loginPage loginPage = new loginPage(driver);
    @Then("User tries to signup using an existing email")
    public void user_tries_to_signup_using_an_existing_email() {
       loginPage.newUser(ConfigReader.readProperty("name"), ConfigReader.readProperty("existedEmail"));
    }
    @Then("Verify the error message {string} is visible")
    public void verify_the_error_message_is_visible(String expectedText) {
        Assert.assertEquals(expectedText, loginPage.errorSignupText());
    }

}
