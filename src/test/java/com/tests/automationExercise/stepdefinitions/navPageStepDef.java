package com.tests.automationExercise.stepdefinitions;

import com.tests.automationExercise.pages.automationMainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class navPageStepDef {
    WebDriver driver = DriverHelper.getDriver();
    automationMainPage mainPage = new automationMainPage(driver);

    @When("User is at home page")
    public void user_is_at_home_page() {
        Assert.assertEquals(ConfigReader.readProperty("urlAE"), driver.getCurrentUrl());
        mainPage.TestCases();
    }
    @Then("User clicks on test case and verify its loaded successfully")
    public void user_clicks_on_test_case_and_verify_its_loaded_successfully() {
        Assert.assertEquals(ConfigReader.readProperty("testURL"), driver.getCurrentUrl());
    }

}
