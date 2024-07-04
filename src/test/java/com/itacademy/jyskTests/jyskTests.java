package com.itacademy.jyskTests;

import com.itacademy.jyskPages.BasePage;
import com.itacademy.jyskPages.CartPage;
import com.itacademy.jyskPages.jyskMainPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class jyskTests extends BaseTest{
    private static final Logger LOGGER= LogManager.getLogger(jyskTests.class);
    @Test (testName = "Pridumai Imena Testam ))")
    public void searchProductAndAddToTheCart() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        jyskMainPage jyskMainPage = new jyskMainPage(driver);
        CartPage cartPage = new CartPage(driver);
        basePage.openJyskWebsite();
        jyskMainPage.searchProduct();
        Thread.sleep(4000);
        jyskMainPage.openTDP();
        cartPage.openCartPage();
        Thread.sleep(3000);
        jyskMainPage.cliclOnWebsiteLogo();
    }
    @Test
    public void searchProductsWithFilters() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        jyskMainPage jyskMainPage = new jyskMainPage(driver);
        basePage.openJyskWebsite();
        jyskMainPage.applyFilters();
    }
//    @Test
//    public void compareProducts() throws InterruptedException {
//        BasePage basePage = new BasePage(driver);
//        jyskMainPage jyskMainPage = new jyskMainPage(driver);
//        CartPage cartPage = new CartPage(driver);
//        basePage.openJyskWebsite();
//        Assert.fail("failed test specialno");
//    }

    @Test
    public void searchProductViaBurgerMenu() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        jyskMainPage jyskMainPage = new jyskMainPage(driver);
        CartPage cartPage = new CartPage(driver);
        basePage.openJyskWebsite();
        jyskMainPage.searchProductViaBurger();
    }

}
