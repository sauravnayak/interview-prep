package com.interview.prep.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final int max_attempt=2;
    private static final Logger log = LoggerFactory.getLogger(CustomListeners.class);
    private int counter=0;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(counter<max_attempt){
            log.info("Retrying");
            counter++;
            return true;
        }
        return false;
    }
}
