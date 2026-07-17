package com.interview.prep;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;




public class CustomListeners implements ITestListener {

    private static final Logger log = LogManager.getLogger(CustomListeners.class);

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
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("⚠️ SKIPPED: " + result.getMethod().getMethodName()+"()");
    }
}
