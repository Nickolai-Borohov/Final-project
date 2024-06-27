package com.itacademy.jyskPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    @FindBy(xpath = "(//*[@class='coi-banner__accept'])[1]")
    private WebElement acceptCookieButton;
    public void openJyskWebsite() throws InterruptedException {
        driver.get("https://jysk.co.uk/");
        Thread.sleep(3000);
        acceptCookieButton.click();
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
