package com.tests.automationExercise.stepdefinitions;

import com.tests.automationExercise.pages.loginPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.sql.Driver;

public class negativeLoginStepDef {
    WebDriver driver = DriverHelper.getDriver();
    loginPage loginPage = new loginPage(driver);


    @Then("Enter incorrect email and password")
    public void enter_incorrect_email_and_password() {
        loginPage.loginExistingUser(ConfigReader.readProperty("incorrectEmail"), ConfigReader.readProperty("password"));
    }
    @Then("Verify error {string} is visible")
    public void verify_error_is_visible(String expectedText) {
        Assert.assertEquals(expectedText, loginPage.errorLoginText());
    }

}
