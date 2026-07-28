package com.interview.prep.web.demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QA_WindowsPage {
    private final WebDriver driver;
    private final Wait wait;


    QA_WindowsPage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="windowButton")
    private WebElement newWindowButton;

    @FindBy(id="messageWindowButton")
    private WebElement newMessageWindowButton;

    @FindBy(id="sampleHeading")
    private WebElement newWindowHeading;

    @FindBy(tagName="body")
    private WebElement newMessage;


    public void clickNewWindow(){
        wait.until(ExpectedConditions.elementToBeClickable(newWindowButton));
        newWindowButton.click();
    }

    public void clickNewMessageWindow(){
        wait.until(ExpectedConditions.elementToBeClickable(newMessageWindowButton));
        newMessageWindowButton.click();
    }

    public void switchToWindow(String handle){
        driver.switchTo().window(handle);
    }
    public String getHeading(){
        wait.until(ExpectedConditions.visibilityOf(newWindowHeading));
        return newWindowHeading.getText();
    }

    public String getMessage(){
        //wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        return newMessage.getAttribute("innerText").trim();
    }

}
