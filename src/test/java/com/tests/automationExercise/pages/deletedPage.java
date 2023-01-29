package com.tests.automationExercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.util.concurrent.BrokenBarrierException;

import static utils.DriverHelper.driver;

public class deletedPage {

    WebDriver driver = DriverHelper.getDriver();
    public deletedPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b")
    WebElement deletedAccountText;

    @FindBy(xpath = "//a[.='Continue']")
    WebElement continueButton;

    public String deletedAccountText(){
        return BrowserUtils.getText(deletedAccountText);
    }

    public void continueButton() throws InterruptedException {
        continueButton.click();

        Thread.sleep(3000);


        if(driver.getCurrentUrl().trim().contains("#google_vignette")){
            driver.navigate().refresh();
            continueButton.click();
        }

    }

}
