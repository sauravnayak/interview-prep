package com.interview.prep.base;

import com.interview.prep.web.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

import static com.interview.prep.web.DriverFactory.getDriver;

public class BaseTestContainer {

    private static final String BASE_URL="https://practice.expandtesting.com";
    WebDriver driverInstance;
    String browser="chrome";
    protected final Logger log = LogManager.getLogger(getClass());

    public static WebDriver create(String browser, boolean headless) {
        WebDriver remoteDriver = null;
        try {
            URL gridurl = new URL("http://localhost:4545/");

            if ("chrome".equalsIgnoreCase(browser)) {
                ChromeOptions options = new ChromeOptions();
                if (headless) {
                    options.addArguments("--headless=new");
                }
                options.addArguments("--window-size=1920,1080");
                remoteDriver = new RemoteWebDriver(gridurl, options);

            } else if ("firefox".equalsIgnoreCase(browser)) {
                FirefoxOptions options = new FirefoxOptions();
                if (headless) {
                    options.addArguments("-headless");
                }
                remoteDriver = new RemoteWebDriver(gridurl, options);

            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Grid URL configuration", e);
        }
        return remoteDriver;

    }
    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser){
        // driverInstance= create("chrome",true);

        DriverFactory.setDriver(create(browser,true));
        log.info("------------------------------------------------------------------------------");
        log.info("Starting browser..."+ browser);
        getDriver().manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
        log.info("Maximizing the Browser Window");
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        log.info("Closing the browser");
        log.info("------------------------------------------------------------------------------");
        DriverFactory.quit();
    }

    public void navigateTo(String path) {
        log.info("Launching Browser with  URL = "+ BASE_URL+path);
        getDriver().get(BASE_URL + path);
    }
}
