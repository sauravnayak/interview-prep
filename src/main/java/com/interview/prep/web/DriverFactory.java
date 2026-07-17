package com.interview.prep.web;

import org.openqa.selenium.WebDriver;

/**
 * Simple driver factory (FW-07 Factory pattern).
 * Selenium 4.6+ ships Selenium Manager, so no manual driver binary is needed.
 */
public final class DriverFactory {

    private static final ThreadLocal<WebDriver> driver= new ThreadLocal<>();

    private DriverFactory() {
    }
    public static WebDriver getDriver(){
        return  driver.get();
    }
    public static void setDriver(WebDriver driverInstance){
        driver.set(driverInstance);
    }

    public  static void quit(){
        if(getDriver()!=null){
            getDriver().quit();
            driver.remove();
        }
    }

}
