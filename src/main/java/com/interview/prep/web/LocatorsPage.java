package com.interview.prep.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LocatorsPage {

    private final WebDriver driver;
    private Wait wait;

    LocatorsPage(WebDriver driver){
     this.driver=driver;
     wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    //Example to Find element using tagname[attribute='value'] xpath selector
    @FindBy(xpath = "//button[@aria-label='Add Item']")
    private WebElement addItemButton;

    //Example to Find element using getbyrole xpath selector
    @FindBy(css ="a[role='link']")
    private WebElement contactLink;

    //Example to Find element using Selenium  Partial Link text selector
    @FindBy(partialLinkText = "Cases")
    private WebElement testCasesLink;

    //Example to Find element using Selenium Link text selector
    @FindBy(linkText = "About")
    private WebElement aboutLink;

    //Example to Find element using css .classname selector
    @FindBy(css = ".alert-warning")
    private WebElement alertWarningLabel;

    //Example to Find element using css sibling selector elem+sibling
    @FindBy(css = "label[for='countrySelect']+select")
    private WebElement selectDropdown;

    //Example to Find element using css child selector .classname > tagname:nth-of-type(1)
    @FindBy(css = ".form-group >input:nth-of-type(1)")
    private WebElement emailField;

    //Example to Find element using Placeholder text
    @FindBy(css="input[placeholder='Search the site']")
    private WebElement siteSearchField;

    //Example to Find element using Placeholder text
    @FindBy(css="input[placeholder='Filter by tag']")
    private WebElement filterSearchField;

    //Example to Find element using css selector using
    // contains-> [attribute +='value']
    // starts-with-> [attribute ^='value']
    //ends-with-> [attribute &='value']
    @FindBy(css = "img[alt*='User avatar']")
    private WebElement imageAlt;

    //using xpath following-sibling from Refresh content to find settings-panel
    @FindBy(xpath = "//*[@title='Refresh content']/following-sibling::span")
    private WebElement settingsPanel;

    //using xpath following-sibling from settings-panel to find Refresh content
    @FindBy(xpath = "//*[@title='Settings panel']/preceding-sibling::button")
    private WebElement refreshContent;

    //using legacy css selector , contacting  legacy-css text-primary with a dot .
    @FindBy(css = ".legacy-css.text-primary")
    private WebElement legacyCSSElement;

    public List<WebElement> getAllElementsToVerify(){

        List<WebElement> elements = new ArrayList<>();
        elements.add(addItemButton);
        elements.add(contactLink);
        elements.add(testCasesLink);
        elements.add(aboutLink);
        elements.add(alertWarningLabel);
        elements.add(selectDropdown);
        elements.add(emailField);
        elements.add(siteSearchField);
        elements.add(filterSearchField);
        elements.add(imageAlt);
        elements.add(settingsPanel);
        elements.add(refreshContent);
        elements.add(legacyCSSElement);

        return elements;
    }



}
