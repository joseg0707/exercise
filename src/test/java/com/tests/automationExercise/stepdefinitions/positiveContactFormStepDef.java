package com.tests.automationExercise.stepdefinitions;

import com.tests.automationExercise.pages.automationMainPage;
import com.tests.automationExercise.pages.contactUsFormPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.sql.Driver;

public class positiveContactFormStepDef {
    WebDriver driver = DriverHelper.getDriver();
    automationMainPage mainPage = new automationMainPage(driver);
    contactUsFormPage contactUs = new contactUsFormPage(driver);

    @When("user is at the homepage and click on Contact Us button")
    public void user_is_at_the_homepage_and_click_on_contact_us_button() {
       mainPage.contactUs();
    }
    @Then("At the contact page Verify {string} is visible")
    public void at_the_contact_page_verify_is_visible(String expected) {
        Assert.assertEquals(expected, contactUs.getText());
    }
    @Then("Complete the form  by entering name, email, subject, message and upload a file")
    public void complete_the_form_by_entering_and_upload_a_file() {
        contactUs.userInfo(ConfigReader.readProperty("name"), ConfigReader.readProperty("email"),
                ConfigReader.readProperty("subject"), ConfigReader.readProperty("message"));

        contactUs.uploadFile(ConfigReader.readProperty("file"));
    }
    @Then("Submits the form and clicks the Ok Button to continue")
    public void submits_the_form_and_clicks_the_ok_button_to_continue() throws InterruptedException {
        contactUs.submitForm();
    }
    @When("form has been completed and submitted verify {string} is visible")
    public void form_has_been_completed_and_submitted_verify_is_visible(String expectedText) {
        Assert.assertEquals(expectedText, contactUs.successText());
    }
    @Then("User clicks Home Button and verify User is navigated to the homepage")
    public void user_clicks_home_button_and_verify_user_is_navigated_to_the_homepage() throws InterruptedException {
        contactUs.homePageButton();
        Assert.assertEquals(ConfigReader.readProperty("urlAE"), driver.getCurrentUrl());
    }

}
