package com.itacademy.jyskPages;

import com.itacademy.utils.Waiters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
    String postcode ="SK7 6DD";
@FindBy(id = "id='top-basket-amount'")
private WebElement cartButtonInHeader;
@FindBy(xpath = "//*[@class='form-control form-text required']")
private WebElement postcodeField;
@FindBy(xpath = "//*[@data-test='saveZipButton']")
private WebElement savePostcodeButton;
@FindBy(xpath = "//*[text()=\" Continue shopping\"]")
private WebElement ContinueShoppingButton;
@FindBy(xpath = "//*[text()=\"Add to basket\"]")
private WebElement addToBasketButton;
@FindBy (xpath = "//*[@class=\"btn cta primary\"]")
private WebElement navigateToTheCheckoutButtonInSideMenu;
    private static final Logger LOGGER = LogManager.getLogger(CartPage.class);
    public void openCartPage() {
        addToBasketButton.click();
        postcodeField.sendKeys(postcode);
        savePostcodeButton.click();
        Waiters.wait(3000);
        ContinueShoppingButton.click();
        LOGGER.info("Product was successfuly added to the cart");
    }

    public CartPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
}
