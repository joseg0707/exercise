package com.tests.automationExercise.pages;

import io.cucumber.java.bs.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.util.List;


public class productPage {

    WebDriver driver = DriverHelper.getDriver();

    public productPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@class='title text-center']")
    WebElement productText;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    WebElement blueTop;

    @FindBy(xpath = "//a[@href='/product_details/5']")
    WebElement winterTopViewProduct;

    @FindBy(xpath = "//div[@class= 'overlay-content']//p")
    List<WebElement> topSearch;

    @FindBy(xpath = "//input[@name = 'search']")
    WebElement searchBar;

    @FindBy(id = "submit_search")
    WebElement submitSearch;

    @FindBy(xpath = "//h2[.='Searched Products']")
    WebElement searchedText;


    public String description(){
        return BrowserUtils.getText(productText);
    }

    public void viewProduct() throws InterruptedException {

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.scrollToElement(winterTopViewProduct).perform();

        blueTop.click();

        Thread.sleep(3000);


        if(driver.getCurrentUrl().trim().contains("#google_vignette")){
            driver.navigate().refresh();
            blueTop.click();
        }
    }

    public void search(String itemSearch){
        this.searchBar.sendKeys(itemSearch);
        this.submitSearch.click();
    }

    public String searchedTextField(){
        return BrowserUtils.getText(searchedText);
    }

    public String itemName(){
        return BrowserUtils.getText((WebElement) topSearch);
    }


}
