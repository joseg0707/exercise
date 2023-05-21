package com.tests.automationExercise.stepdefinitions.positiveTestCases;

import com.tests.automationExercise.pages.automationMainPage;
import com.tests.automationExercise.pages.testCasesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class positiveTestCasesPage{
    WebDriver driver = DriverHelper.getDriver();

    automationMainPage automationMainPage = new automationMainPage(driver);

    @When("User is at the home page")
    public void userIsAtTheHomePage() {
        Assert.assertEquals(ConfigReader.readProperty("urlAE"), driver.getCurrentUrl());

    }

    @When("Click on test cases button")
    public void click_on_test_cases_button() {
        automationMainPage.TestCases();
    }

    @Then("User is at the test case page")
    public void user_is_at_the_test_case_page() {
        Assert.assertEquals("https://automationexercise.com/test_cases", driver.getCurrentUrl());
    }


}
