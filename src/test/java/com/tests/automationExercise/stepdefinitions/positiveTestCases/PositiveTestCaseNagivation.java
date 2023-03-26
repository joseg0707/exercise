package com.tests.automationExercise.stepdefinitions.positiveTestCases;

import com.tests.automationExercise.pages.automationMainPage;
import com.tests.automationExercise.pages.testCasesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class PositiveTestCaseNagivation {
    WebDriver driver = DriverHelper.getDriver();

    automationMainPage mainPage = new automationMainPage(driver);
    testCasesPage testCases = new testCasesPage(driver);

    @When("User is at the home page")
    public void user_is_at_the_home_page() {
        Assert.assertEquals(ConfigReader.readProperty("url"), driver.getCurrentUrl());
    }
    @Then("User click the test cases section")
    public void user_click_the_test_cases_section() {
        mainPage.TestCases();
    }
    @When("User is on the test cases page verify Test Cases is visible {string}")
    public void user_is_on_the_test_cases_page_verify_test_cases_is_visible(String expectedText) {
        Assert.assertEquals(expectedText, testCases.testCasesText());
    }
    @Then("Verify user is at the Test Cases Page")
    public void verify_user_is_at_the_test_cases_page() {
        Assert.assertEquals(ConfigReader.readProperty("TestCasesURL"), driver.getCurrentUrl());
    }

}
