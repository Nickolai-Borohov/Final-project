package com.itacademy.jyskPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn extends BasePage {
    @FindBy(xpath = "//*[@class='svg-w3-profile v-2']")
    private WebElement logInButton;
    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "password")
    private WebElement passwordField;
    public void openLogInForm(){
        logInButton.click();
    }

    public LogIn (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
}
