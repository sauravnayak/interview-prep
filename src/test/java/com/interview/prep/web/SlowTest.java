package com.interview.prep.web;

import com.interview.prep.CustomListeners;
import com.interview.prep.base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.time.Duration;

import static com.interview.prep.web.DriverFactory.getDriver;

@Listeners(CustomListeners.class)
public class SlowTest extends BaseTest {

    SlowPage page;

    @Test
    public void slowTest() {
        navigateTo("/slow");
        page = new SlowPage(getDriver());
        By spinnerlocator = page.getSpinnerLocator();

        //Explicit Wait Example
        log.info("Waiting for spinner to be displayed");
        WebDriverWait waitforAppearance = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        WebElement spinnerDisplayed = waitforAppearance.until(ExpectedConditions.visibilityOfElementLocated(spinnerlocator));
        Assert.assertTrue(spinnerDisplayed.isDisplayed());
        log.info("Waiting for spinner to be gone");
        WebDriverWait spinnerInvisibleWait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        Assert.assertTrue(spinnerInvisibleWait.until(ExpectedConditions.invisibilityOfElementLocated(spinnerlocator)));

        //FluentWait Example
        log.info("Waiting for message to be displayed");
        WebElement element = page.getMesaage();
        Assert.assertEquals(element.getText(), "The slow task has finished. " +
                "Thanks for waiting!");
    }
}
