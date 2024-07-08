package com.itacademy.jyskTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.itacademy.listeners.Listener;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import static com.itacademy.utils.ScreenshotUtils.takeScreenshot;

@Listeners(Listener.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void baseSettingsForTests(){
        System.setProperty("webdriver.chrome.driver","D://Selenium/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );

    }

    @AfterMethod
    public void baseAfterTestMethod(ITestResult result) {
        if (result.getStatus()==ITestResult.FAILURE){
//            String methodName = result.getMethod().getMethodName();
//            takeScreenshot();
//            File screenshotFile = new File("src/main/resources/screenshots");
//            Allure.addAttachment("Screenshot",new FileInputStream(screenshotFile));
        }
        driver.quit();
    }

}
