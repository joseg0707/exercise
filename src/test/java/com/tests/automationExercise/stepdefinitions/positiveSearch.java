package com.tests.automationExercise.stepdefinitions;

import com.tests.automationExercise.pages.productPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class positiveSearch {

    WebDriver driver = DriverHelper.getDriver();
    productPage productPage = new productPage(driver);
    @Then("Searches for {string} and confirms {string}")
    public void searches_for_and_confirms(String item, String expectedText) {
        productPage.search(item);

        Assert.assertEquals(expectedText, productPage.searchedTextField());
    }

    @Then("Verify all the products related to search are visible")
    public void verify_all_the_products_related_to_search_are_visible() {
        System.out.println(productPage.itemName());

    }

}
