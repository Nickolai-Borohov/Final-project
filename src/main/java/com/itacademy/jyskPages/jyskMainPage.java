package com.itacademy.jyskPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class jyskMainPage extends BasePage {
    String searchProduct="Sofa \n";
    String needProductViaSearch = "Sofabed PARADIS light grey";
    final String needParentCategory= "Bedroom" ;
    String needSubCategoriesOnSelectedCategoty = "Bedside Tables";
    String needProductViaBurger ="Bedside table HEMDRUP 1 drawer oak color/black";
    @FindBy(xpath = "//*[@class='search-input form-control']")
    private WebElement searchField;
    @FindBy(xpath = "//*[@class='logo-wrapper']")
    private WebElement logo;
    @FindBy(xpath = "(//*[@class=\"close-x\"])[2]")
    private WebElement closeSpamWindowButton;
    @FindBy(xpath = "(//*[text()=\"All filters\"])[2]")
    private WebElement allFiltersButton;
    @FindBy(xpath = "(//*[text()=\"Price\"])[2]")
    private WebElement priceFilterInRightSideMenu;
    @FindBy(xpath = "(//*[@class=\"range-slider__form-input form-control\"])[2]")
    private WebElement maxPriceFilter;
    @FindBy (xpath = "//*[@class=\"w3-btn w3-btn--medium\"]")
    private WebElement showResultsButton;
    @FindBy (xpath = "//*[@class=\"svg-w3-menu v-2\"]")
    private WebElement burgerMenu;
    @FindBy (xpath = "//*[@class='list-unstyled text-dark'] //*[text()='"+needParentCategory+"']")
    private WebElement needMainCategoryInBurger;
    @FindBy(xpath = "//*[text()=\"Show all\"]")
    private WebElement showAllButton;
    @FindBy (xpath = "//*[@class=\"category-header-text mt-0 mb-0\"]")
    private WebElement titleOnTheSelectedCategotyPage;
    private static final Logger LOGGER = LogManager.getLogger(jyskMainPage.class);
    public void cliclOnWebsiteLogo(){
        logo.click();
    }
    public void searchProduct() throws InterruptedException {
        Thread.sleep(2000);
        closeSpamWindowButton.click();
        searchField.sendKeys(searchProduct);
    }

    public void openTDP() throws InterruptedException {
        driver.findElement(By.xpath("(//*[@class='close-x'])[1]")).click();
        List<WebElement> productsOnSRP = driver.findElements(By.xpath("//*[@class='product-teaser-body'] //*[@class='product-teaser-title__name']"));
        WebElement titleOnSRP=driver.findElement(By.xpath("//*[@class='tabbed-search__heading mt-0']"));
        LOGGER.info(titleOnSRP.getText()+" Was found");
        for (WebElement element: productsOnSRP){
            String productsOnSRPNames= element.getText();
            LOGGER.info(productsOnSRPNames);
            if (productsOnSRPNames.equals(needProductViaSearch)){
                JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
                javascriptExecutor.executeScript("arguments[0].click();",element);
                LOGGER.info(needProductViaSearch+" Was successfully found");
                break;
            }
        }
        Thread.sleep(5000);
    }
    public void applyFilters() throws InterruptedException {
        searchProduct();
        allFiltersButton.click();
        priceFilterInRightSideMenu.click();
        maxPriceFilter.clear();
        maxPriceFilter.sendKeys("225");
        showResultsButton.click();
        openTDP();
        Thread.sleep(2000);
    }

    public void searchProductViaBurger() throws InterruptedException {
        burgerMenu.click();
        needMainCategoryInBurger.click();
        showAllButton.click();
        Thread.sleep(8000);
        List<WebElement> subCategoriesOnSelectedCategoty = driver.findElements(By.xpath("//*[@class=\"category-menu__item-title mt-0\"]"));
        for (WebElement element:subCategoriesOnSelectedCategoty){
            String subCategoriesOnSelectedCategotyName = element.getText();
            if (subCategoriesOnSelectedCategotyName.equals(needSubCategoriesOnSelectedCategoty))
            {
                closeSpamWindowButton.click();
                JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
                javascriptExecutor.executeScript("arguments[0].click();",element);
                break;
            }
        }
        Thread.sleep(7000);
        assert needSubCategoriesOnSelectedCategoty.equals(titleOnTheSelectedCategotyPage.getText()): "Something went wrong";
        Thread.sleep(10000);
        List<WebElement> productsOnSelectedCategory = driver.findElements(By.xpath("//*[@class=\"product-teaser-body\"] //*[@class=\"product-teaser-title__name\"]"));
        List<String> productsOnSelectedCategoryTest = productsOnSelectedCategory.stream().map(x->x.getText()).toList();
        LOGGER.info(productsOnSelectedCategoryTest);
        for (WebElement element: productsOnSelectedCategory){
            String productsOnSelectedCategoryName = element.getText();
            LOGGER.info(productsOnSelectedCategoryName);
            if (productsOnSelectedCategoryName.equals(needProductViaBurger)){
                JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
                javascriptExecutor.executeScript("arguments[0].click();",element);
                LOGGER.info(needProductViaBurger+" Was successfully found");
                break;
            }
        }
        Thread.sleep(5000);

    }

    public jyskMainPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
}