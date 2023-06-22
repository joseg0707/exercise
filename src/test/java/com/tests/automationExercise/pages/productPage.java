package com.tests.automationExercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.DriverHelper;



public class productPage {

    WebDriver driver = DriverHelper.getDriver();

    public productPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@class='title text-center']")
    WebElement productText;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    WebElement blueTop;


    public String description(){
        return BrowserUtils.getText(productText);
    }

    public void viewProduct() throws InterruptedException {

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.moveToElement(blueTop);
        actions.perform();

        blueTop.click();

        Thread.sleep(3000);


        if(driver.getCurrentUrl().trim().contains("#google_vignette")){
            driver.navigate().refresh();
            blueTop.click();
        }
    }

}
