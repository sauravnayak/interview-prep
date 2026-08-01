package com.interview.prep.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AutocompletePage {

    private final WebDriver driver;
    private final Wait wait;


    AutocompletePage(WebDriver driver){
        this.driver=driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="country")
    private WebElement countrySearchField;

    @FindBy(xpath = "//*[@id='country']/following-sibling::div/div")
    private List<WebElement> autoCompleteSuggest;

    @FindBy(xpath = "//button[@onclick='displayResult()']")
    private WebElement submitButton;

    private final By getResultText=By.id("result");


    public List<WebElement> getAutoCompleteSuggest(){
        wait.until(ExpectedConditions.visibilityOf(autoCompleteSuggest.getFirst()));

        return autoCompleteSuggest;
    }

    public void typeKeyWord(String keyword){
        wait.until(ExpectedConditions.elementToBeClickable(countrySearchField));
        countrySearchField.clear();
        countrySearchField.sendKeys(keyword);
    }

    public void clickSubmit(){
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
    }

    public String getTextDisplayed(){
        String result=driver.findElement(getResultText).getText();
        return  result.replace("You selected: ","").trim();
    }

}
