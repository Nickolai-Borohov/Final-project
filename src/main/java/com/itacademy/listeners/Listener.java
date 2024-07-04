package com.itacademy.listeners;

import com.itacademy.jyskPages.jyskMainPage;
import com.itacademy.utils.ScreenshotUtils;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    private static final Logger LOGGER = LogManager.getLogger(Listener.class);
    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("=================================================");
        LOGGER.info("Test "+ result.getMethod().getMethodName()+ " Was starter");
        LOGGER.info("=================================================");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("=================================================");
        LOGGER.info("Test "+ result.getMethod().getMethodName()+ " Passed successfully");
        LOGGER.info("=================================================");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.info("=================================================");
        LOGGER.info("Test "+ result.getMethod().getMethodName()+ " Something went wrong feild test");
        LOGGER.info("=================================================");
        ScreenshotUtils.takeScreenshot();
    }
}
