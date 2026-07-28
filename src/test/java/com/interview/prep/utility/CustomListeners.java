package com.interview.prep.utility;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.interview.prep.web.DriverFactory.getDriver;


public class CustomListeners implements ITestListener {

    private static final Logger log = LogManager.getLogger(CustomListeners.class);
    private static final String SCREENSHOT_DIR = "target/screenshots/";

    @Override
    public void onTestStart(ITestResult result){

        log.info("👉 Starting Test Method: " +result.getMethod().getMethodName()+"()");
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("✅ PASSED: " +result.getMethod().getMethodName()+"()");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("❌ FAILED: " + result.getMethod().getMethodName()+"()");
        if (result.getThrowable() != null) {
            log.error("Reason: ", result.getThrowable());
        }
        String timestamp =new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File src= ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        File directory = new File(System.getProperty("user.dir"), "target/screenshots");

        // 3. Force create the folder structure if it doesn't exist yet
        if (!directory.exists()) {
            directory.mkdirs();
        }
        File dest = new File(directory,result.getMethod().getMethodName()+timestamp+".png");

        try {
            FileUtils.copyFile(src,dest);
        } catch (IOException e) {
            System.out.println("Failed to capture page screenshot: " + e.getMessage());        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("⚠️ SKIPPED: " + result.getMethod().getMethodName()+"()");
    }
}
