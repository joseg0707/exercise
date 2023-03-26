package com.tests.automationExercise.pages;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.DriverHelper;

import static utils.DriverHelper.driver;

public class contactUsFormPage {
    WebDriver driver = DriverHelper.getDriver();
    public contactUsFormPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[.='Get In Touch']")
    WebElement inTouchText;

    @FindBy(xpath = "//input[@data-qa='name']")
    WebElement name;

    @FindBy(xpath = "//input[@data-qa='email']")
    WebElement email;

    @FindBy(xpath = "//input[@data-qa='subject']")
    WebElement Subject;

    @FindBy(xpath = "//textarea[@data-qa='message']")
    WebElement message;

    @FindBy(xpath = "//input[@name='upload_file']")
    WebElement uploadFile;

    @FindBy(xpath = "//input[@name='submit']")
    WebElement submit;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    WebElement formCompletedText;

    @FindBy(xpath = "//a[@class='btn btn-success']")
    WebElement homePage;

    @FindBy(id = "dismiss-button")
    WebElement dismissIframe;


    public String getText(){
        return BrowserUtils.getText(inTouchText);
    }

    public void userInfo(String name, String email, String Subject, String message){
        this.name.sendKeys(name);
        this.email.sendKeys(email);
        this.Subject.sendKeys(Subject);
        this.message.sendKeys(message);
    }

    public void uploadFile(String fileName){
        this.uploadFile.sendKeys(fileName);
    }

    public void submitForm() throws InterruptedException {
        submit.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String successText(){
        return BrowserUtils.getText(formCompletedText);
    }

    public void homePageButton() throws InterruptedException {
        homePage.click();
        Thread.sleep(3000);
        if(driver.getCurrentUrl().trim().contains("#google_vignette")){
            driver.switchTo().frame("aswift_1");
            driver.switchTo().frame("ad_iframe");
            dismissIframe.click();
        }
    }


}
