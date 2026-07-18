package com.interview.prep.web;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object Model example (SEL-04 / FW-03).
 * Encapsulates the login screen's locators and actions so tests read as behaviour.
 */
public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "submit-login")
    private WebElement loginButton;

    @FindBy(css = "#flash > b")
    private WebElement messageLabel;

    @FindBy(css="[class *=\"icon-signout\"]")
    private WebElement logoutButton;

    @FindBy(partialLinkText = "here")
    private WebElement herePartialLink;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String pass) {
        removeAdsFromDOM();
        hereLinkDisplayed();
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(user);
        password.sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    protected void removeAdsFromDOM() {
        try {
            // Run clean JS script to find and destroy common Google Ad containers instantly
            ((JavascriptExecutor) driver).executeScript(
                    "document.querySelectorAll('ins.adsbygoogle, iframe[id^=\"aswift\"], iframe[id^=\"google_ads\"]').forEach(el => el.remove());"
            );
        } catch (Exception e) {
            System.out.println("Failed to clear background ad nodes: " + e.getMessage());
        }
    }

    public String getLoginMessage(){
        wait.until(ExpectedConditions.visibilityOf(messageLabel));
        return  messageLabel.getText().trim();
    }

    public boolean isLogoutDisplayed(){
        return  logoutButton.isDisplayed();
    }

    public boolean isSecureURL(){
        return  driver.getCurrentUrl().contains("/secure");
    }

    public boolean hereLinkDisplayed(){
        return  herePartialLink.isDisplayed();
    }

}
