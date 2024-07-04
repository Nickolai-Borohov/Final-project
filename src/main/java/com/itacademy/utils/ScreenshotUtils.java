package com.itacademy.utils;

import com.itacademy.jyskPages.BasePage;
import com.itacademy.jyskPages.jyskMainPage;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenshotUtils extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(ScreenshotUtils.class);
    public static void takeScreenshot() {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        File screenshot = new File(date.getTime() + ".png");
        try {
            FileUtils.copyFile(file, screenshot);
        } catch (IOException e) {
            LOGGER.info("Screenshot wasn't saved");
        }
    }
    public ScreenshotUtils(WebDriver driver) {
        super(driver);
    }
}
