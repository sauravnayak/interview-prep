package com.interview.prep.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropDownPage {

    private final WebDriver driver;
    private final Wait wait;

    DropDownPage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "dropdown")
    private WebElement optionDropDown;

    @FindBy(id = "elementsPerPageSelect")
    private WebElement elementsDropDown;

    @FindBy(id="country")
    private WebElement countryDropDown;


    public WebElement getOptionDropDown(){
        return optionDropDown;
    }

    public WebElement getElementsDropDown(){
        return elementsDropDown;
    }

    public WebElement getCountryDropDown(){
        wait.until(ExpectedConditions.visibilityOf(countryDropDown));
        return countryDropDown;
    }
}
