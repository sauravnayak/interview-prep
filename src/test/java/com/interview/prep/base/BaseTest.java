package com.interview.prep.base;

import com.interview.prep.web.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.log4testng.Logger;

import static com.interview.prep.web.DriverFactory.getDriver;

public class BaseTest {

    private static final String BASE_URL="https://practice.expandtesting.com";
    WebDriver driverInstance;
    String browser="chrome";
    protected final Logger log = Logger.getLogger(BaseTest.class);

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
    @BeforeMethod
    public void setUp(){
       driverInstance= create("chrome",false);
        DriverFactory.setDriver(driverInstance);
        log.info("Starting browser..."+ browser);
        getDriver().manage().window().maximize();
        log.info("Maximizing the Browser Window");
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        log.info("Closing the browser");
        DriverFactory.quit();
    }

    public void navigateTo(String path) {
        log.info("Launching Browser with  URL = "+ BASE_URL+path);
        getDriver().get(BASE_URL + path);
    }
}
