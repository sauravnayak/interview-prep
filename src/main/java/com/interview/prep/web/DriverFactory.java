package com.interview.prep.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Simple driver factory (FW-07 Factory pattern).
 * Selenium 4.6+ ships Selenium Manager, so no manual driver binary is needed.
 */
public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver create(String browser, boolean headless) {
        if ("chrome".equalsIgnoreCase(browser)) {
            ChromeOptions options = new ChromeOptions();
            if (headless) {
                options.addArguments("--headless=new");
            }
            return new ChromeDriver(options);
        }
        throw new IllegalArgumentException("Unsupported browser: " + browser);
    }
}
