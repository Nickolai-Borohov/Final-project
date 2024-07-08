package com.itacademy.jyskTests;

import com.itacademy.jyskPages.BasePage;
import com.itacademy.jyskPages.CartPage;
import com.itacademy.jyskPages.SearchProductsPage;
import com.itacademy.utils.ScreenshotUtils;
import com.itacademy.utils.Waiters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JyskTests extends BaseTest{
    private static final Logger LOGGER= LogManager.getLogger(JyskTests.class);
    @Test (testName = " Search product and add to the cart ))")
    public void searchProductAndAddToTheCart() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        SearchProductsPage jyskMainPage = new SearchProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        basePage.openJyskWebsite();
        jyskMainPage.searchProduct();
        Waiters.wait(4000);
        jyskMainPage.openTDP();
        cartPage.openCartPage();
        Waiters.wait(3000);  // можно убрать throws InterruptedException когда мы вот это используем поменяй везде
        jyskMainPage.cliclOnWebsiteLogo();
    }
    @Test
    public void searchProductsWithFilters() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        SearchProductsPage jyskMainPage = new SearchProductsPage(driver);
        basePage.openJyskWebsite();
        jyskMainPage.applyFilters();
    }
//    @Test
//    public void compareProducts() throws InterruptedException {
//        BasePage basePage = new BasePage(driver);
//        basePage.openJyskWebsite();
//        Assert.fail("failed test special");
//        CartPage cartPage = new CartPage(driver);
//        cartPage.openCartPage();
//        ScreenshotUtils screenshotUtils = new ScreenshotUtils(driver);
//        screenshotUtils.takeScreenshot();}

    @Test
    public void searchProductViaBurgerMenu() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        SearchProductsPage jyskMainPage = new SearchProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        basePage.openJyskWebsite();
        jyskMainPage.searchProductViaBurger();
    }

}
