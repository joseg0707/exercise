package com.tests.automationExercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class testCasesPage {

    public testCasesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
