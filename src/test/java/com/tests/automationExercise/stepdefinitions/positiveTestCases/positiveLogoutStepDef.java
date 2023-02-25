package com.tests.automationExercise.stepdefinitions.positiveTestCases;

import com.tests.automationExercise.pages.automationMainPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class positiveLogoutStepDef {
    WebDriver driver = DriverHelper.getDriver();

    automationMainPage mainPage = new automationMainPage(driver);

    @Then("User Logs out and verify user is at the signup-login page {string}")
    public void user_logs_out_and_verify_user_is_at_the_signup_login_page(String expectedURL) {
        mainPage.logoutButton();

        Assert.assertEquals(expectedURL, ConfigReader.readProperty("signupPage"));
    }

}
