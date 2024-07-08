package com.itacademy.jyskPages;
import com.itacademy.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    protected static WebDriver driver;
    @FindBy(xpath = "(//*[@class='coi-banner__accept'])[1]")
    private WebElement acceptCookieButton;
    public void openJyskWebsite() {
        driver.get("https://jysk.co.uk/");
        Waiters.wait(2000);
        acceptCookieButton.click();
    }


}
