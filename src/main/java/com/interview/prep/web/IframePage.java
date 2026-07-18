package com.interview.prep.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IframePage {

    private final WebDriver driver;
    private Wait wait;

    IframePage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "btn-subscribe")
    private WebElement subscribeButton;

    @FindBy(id = "email-subscribe")
    private WebElement subscibeFrame;

    private By subscribeFrame= By.id("email-subscribe");


    public void clickSubscribe(){
        wait.until(ExpectedConditions.presenceOfElementLocated(subscribeFrame));
        new Actions(driver)
                .scrollToElement(subscibeFrame)
                .perform();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(subscibeFrame));
        wait.until(ExpectedConditions.elementToBeClickable(subscribeButton));
        subscribeButton.click();
        driver.switchTo().defaultContent();
    }
}
