package com.interview.prep.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MultipleWindowsPage {

    private final WebDriver driver;
    private final Wait wait;

    MultipleWindowsPage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(@href,\"new\")]")
    private WebElement newWindowLink;

    @FindBy(tagName = "h1")
    private WebElement headingLabel;


    public void clickNewWindowLink(){
        wait.until(ExpectedConditions.elementToBeClickable(newWindowLink));
        newWindowLink.click();
    }

    public String getHeadingLabel() {
        return headingLabel.getText();
    }

    public void switchToWindow(String handle){
        driver.switchTo().window(handle);
    }
}
