package com.interview.prep.web.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QA_TooltipPage {
    private final WebDriver driver;
    private final Wait wait;
    private Actions action;

    QA_TooltipPage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
        this.action=new Actions(driver);
    }

    @FindBy(id="toolTipButton")
    private WebElement toolTipButton;

    @FindBy(id="toolTipTextField")
    private WebElement toolTipEditField;

    @FindBy(linkText = "Contrary")
    private WebElement contraryLink;

    @FindBy(partialLinkText = "10.32")
    private WebElement dynamicLink;

    private final  By tooltipText= By.className("tooltip-inner");

    private String getTooltipAfterHover(WebElement element) {
        // 1. Move to the target element
        action.moveToElement(element).perform();

        // 2. Wait using the fresh By selector rather than a PageFactory proxy
        WebElement visibleTooltip = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(tooltipText));

        // 3. Return the text content safely
        return visibleTooltip.getText().trim();
    }

    public String getButtonToolTip(){

        return getTooltipAfterHover(toolTipButton);
    }

    public String getTextFieldToolTip(){
        return getTooltipAfterHover(toolTipEditField);
    }

    public String getContraryToolTip(){
        return getTooltipAfterHover(contraryLink);
    }
    public String getDynamicLinkToolTip(){
        return getTooltipAfterHover(dynamicLink);
    }


}
