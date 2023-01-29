package com.tests.automationExercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.sql.Driver;

import static utils.DriverHelper.driver;

public class signupPage {

    public signupPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[contains(text(),'Enter Account Information')]")
    WebElement AccountInfoText;
    @FindBy(css = "#id_gender1")
    WebElement title;

    @FindBy(css = "#password")
    WebElement password;

    @FindBy(css = "#days")
    WebElement day;

    @FindBy(css = "#months")
    WebElement month;

    @FindBy(css = "#years")
    WebElement year;

    @FindBy(css = "#newsletter")
    WebElement newsletter;

    @FindBy(css = "#optin")
    WebElement offers;

    ///////////////////////

    @FindBy(css = "#first_name")
    WebElement firstName;

    @FindBy(css = "#last_name")
    WebElement lastName;

    @FindBy(css = "#address1")
    WebElement address;

    @FindBy(css = "#country")
    WebElement countries;

    @FindBy(css = "#state")
    WebElement state;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "#zipcode")
    WebElement zip;

    @FindBy(css = "#mobile_number")
    WebElement phoneNumber;

    @FindBy(xpath = "//button[.='Create Account']")
    WebElement createButton;

    @FindBy(xpath = "//b[.='Account Created!']")
    WebElement createdText;

    @FindBy(xpath = "//a[.='Continue']")
    WebElement continueButton;
    public String accountInfoText(){
        return BrowserUtils.getText(AccountInfoText);
    }

    public void accountInformation(String password,String days,String months,String years,String firstName, String lastName, String address,
                                    String country, String state, String city, String zip, String phoneNumber){
        title.click();
        this.password.sendKeys(password);
        BrowserUtils.selectBy(day, days, "value");
        BrowserUtils.selectBy(month, months, "value");
        BrowserUtils.selectBy(year, years, "value");
        newsletter.click();
        offers.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.address.sendKeys(address);
        BrowserUtils.selectBy(countries, country, "value");
        this.state.sendKeys(state);
        this.city.sendKeys(city);
        this.zip.sendKeys(zip);
        this.phoneNumber.sendKeys(phoneNumber);
        createButton.click();
    }

    public String createdText(){
        return BrowserUtils.getText(createdText);
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
