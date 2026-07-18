package com.interview.prep.web;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.NoSuchElementException;

public class SlowPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = ".alert.alert-info strong")
    private WebElement messageLabel;

    SlowPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    private final By spinner = By.cssSelector("[role='status']");


    public By getSpinnerLocator() {
        return spinner;
    }

    public WebElement getMesaage() {
        Wait<WebDriver> fluentwait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("The Message does not displayed");

        return fluentwait.until(ExpectedConditions.visibilityOf(messageLabel));
    }


}
