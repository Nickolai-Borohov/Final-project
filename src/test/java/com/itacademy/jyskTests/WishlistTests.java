package com.itacademy.jyskTests;

import com.codeborne.selenide.ElementsCollection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class WishlistTests {

    String searchTextforAddToTheWishlist="Sofa \n";
    private static String addProduct = "Sofabed PARADIS light grey";
    private static final Logger LOGGER= LogManager.getLogger(WishlistTests.class);
    @Test
    public void addProductToTheWishlist() throws InterruptedException {
        open("https://jysk.co.uk/");
        Thread.sleep(3000);
        $(By.xpath("(//*[@class='coi-banner__accept'])[1]")).click();
        WebElement searchField = $(By.xpath("//*[@class='search-input form-control']"));
        searchField.sendKeys(searchTextforAddToTheWishlist);
        Thread.sleep(2000);
        $(By.xpath("(//*[@class='close-x'])[2]")).click();
        ElementsCollection productsOnSRP= $$(By.xpath("//*[@class='product-teaser']"));
        LOGGER.info(productsOnSRP.size());
        for (WebElement element: productsOnSRP){
            WebElement pathToProductName= element.findElement(By.xpath(".//*[@class='product-teaser-title__name']"));//$(By.xpath("//*[@class='product-teaser-title__name']"));
            String productName = pathToProductName.getText();
            LOGGER.info(productName);
            if (productName.equals(addProduct)){
                element.findElement(By.xpath(".//*[@class='btn btn-link add-to-wishlist product-teaser-favorite']")).click();
                LOGGER.info("Product has been successfully added to the wishlist");
                break;
            }
        }
        Thread.sleep(5000);
    }

}
