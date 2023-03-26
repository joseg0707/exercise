package com.tests.automationExercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import javax.sql.rowset.BaseRowSet;

import static utils.DriverHelper.driver;

public class automationMainPage {

    public automationMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/login']")
    WebElement signUpLoginButton;

    @FindBy(xpath = "//b")
    WebElement loggedInAs;

    @FindBy(xpath = "//a[@href='/delete_account']")
    WebElement deleteButton;

    @FindBy(xpath = "//a[@href='/logout']")
    WebElement logoutButton;

    @FindBy(xpath = "//a[@href='/contact_us']")
    WebElement contactUsButton;

    @FindBy(xpath = "//a[@href= '/test_cases']")
    WebElement testCasesButton;


    public void SignUpButton(){
        signUpLoginButton.click();
    }

    public String loggedInAs(){
        return BrowserUtils.getText(loggedInAs);
    }

    public void deleteButton() throws InterruptedException {

        deleteButton.click();
        Thread.sleep(3000);
        if(driver.getCurrentUrl().trim().contains("#google_vignette")){
            driver.navigate().refresh();
            deleteButton.click();
        }

    }

    public void logoutButton(){
        logoutButton.click();
    }

    public void contactUs(){
        contactUsButton.click();
    }

    public void TestCases(){
        testCasesButton.click();
        if(driver.getCurrentUrl().trim().contains("#google_vignette")){
            driver.navigate().refresh();
            testCasesButton.click();
        }
    }
}
