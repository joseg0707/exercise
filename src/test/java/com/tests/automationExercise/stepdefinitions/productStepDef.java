package com.tests.automationExercise.stepdefinitions;

import com.tests.automationExercise.pages.automationMainPage;
import com.tests.automationExercise.pages.productPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class productStepDef {
    WebDriver driver = DriverHelper.getDriver();
    automationMainPage mainPage = new automationMainPage(driver);

    productPage productPage = new productPage(driver);
    @When("User is at the home page clicks on products button")
    public void user_is_at_the_home_page_clicks_on_products_button() {
        mainPage.productsButton();
    }
    @When("Verify user is navigated to {string} page successfully and products list is visible")
    public void verify_user_is_navigated_to_page_successfully_and_products_list_is_visible(String description) {
        Assert.assertEquals(description, productPage.description());
    }
    @When("Click on View Product of first product")
    public void click_on_view_product_of_first_product() throws InterruptedException {
        productPage.viewProduct();
    }
    @Then("Verify that detail detail is visible: {string}, {string}, {string}, {string}, {string}, {string}")
    public void verify_that_detail_detail_is_visible(String type, String category, String price, String availability, String condition, String brand) {
        Assert.assertEquals(type, ConfigReader.readProperty("productName"));
        Assert.assertEquals(category, ConfigReader.readProperty("category"));
        Assert.assertEquals(price, ConfigReader.readProperty("price"));
        Assert.assertEquals(availability, ConfigReader.readProperty("availability"));
        Assert.assertEquals(condition, ConfigReader.readProperty("condition"));
        Assert.assertEquals(brand, ConfigReader.readProperty("brand"));
    }
}
