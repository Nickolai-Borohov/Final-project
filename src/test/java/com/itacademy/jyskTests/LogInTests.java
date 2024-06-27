package com.itacademy.jyskTests;

import com.itacademy.jyskPages.BasePage;
import com.itacademy.jyskPages.LogIn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogInTests extends BaseTest {
    String myEmail="nickolaiborohov@gmail.com";
    String myPassword="Qwerty123!";
    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@class='btn-primary w-100 w3-btn btn btn-default']")
    private WebElement logInButton;
    @FindBy(xpath = "(//*[@class='validation-failed alert alert-danger'])[1]")
    private WebElement actualEmailErrorMessage;
    @FindBy(xpath = "(//*[@class='validation-failed alert alert-danger'])[2]")
    private WebElement actualPasswordErrorMessage;
    private static final Logger LOGGER= LogManager.getLogger(LogInTests.class);
    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{
                {"test@gmai", "Please enter a valid e-mail.", "Field is required."}
        };
    }
    @Test(dataProvider = "data-provider")
    public void invalidLogInData(String email, String expectedEmailNotification,String expectedPasswordNotification) throws InterruptedException {
        PageFactory.initElements(driver,this);
        BasePage basePage = new BasePage(driver);
        basePage.openJyskWebsite();
        LogIn logIn = new LogIn(driver);
        logIn.openLogInForm();
        emailField.sendKeys(email);
        logInButton.click();
        assert actualEmailErrorMessage.getText().equals(expectedEmailNotification): "Что-то не так с имейлом" ;
        assert actualPasswordErrorMessage.getText().equals(expectedPasswordNotification): "Что-то не так с парооляем";

    }
    @Test
    public void logIn() throws InterruptedException {
        PageFactory.initElements(driver,this);
        BasePage basePage = new BasePage(driver);
        basePage.openJyskWebsite();
        LogIn logIn = new LogIn(driver);
        logIn.openLogInForm();
        emailField.sendKeys(myEmail);
        passwordField.sendKeys(myPassword);
        if (logInButton.isDisplayed()){
            logInButton.click();
            LOGGER.info("You have successfully logged in to your account");
        }
        Thread.sleep(3000);


    }
// nickolaiborohov@gmail.com
//    Qwerty123!
}
