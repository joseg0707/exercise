package com.tests.automationExercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.logging.XMLFormatter;

public class loginPage {

    public loginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[.='New User Signup!']")
    WebElement signupText;

    @FindBy(xpath = "//h2[.='Login to your account']")
    WebElement loginText;

    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement name;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement signupEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signupButton;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement loginEmail;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement loginPassword;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement loginButton;

    @FindBy(xpath = "//p[.='Your email or password is incorrect!']")
    WebElement loginErrorText;

    @FindBy(xpath = "//p[.='Email Address already exist!']")
    WebElement signupErrorText;



    public String signupText(){
        return BrowserUtils.getText(signupText);
    }

    public void newUser(String name, String email){
        this.name.sendKeys(name);
        this.signupEmail.sendKeys(email);
        signupButton.click();
    }

    public String loginText(){
        return BrowserUtils.getText(loginText);
    }

    public void loginExistingUser(String email, String password){
        this.loginEmail.sendKeys(email);
        this.loginPassword.sendKeys(password);
        loginButton.click();
    }

    public String errorLoginText(){
        return BrowserUtils.getText(loginErrorText);
    }

    public String errorSignupText(){
        return BrowserUtils.getText(signupErrorText);
    }
}
