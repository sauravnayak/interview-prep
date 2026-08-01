package com.interview.prep.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DragAndDropPage {

    private final WebDriver driver;
    private final Wait wait;
    private Actions action;

    DragAndDropPage(WebDriver driver){
        this.driver=driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
        action=  new Actions(driver);
    }

    @FindBy(id="column-a")
    private WebElement columnA;

    @FindBy(id="column-b")
    private WebElement columnB;

    @FindBy(css="#column-a >header")
    private WebElement headerA;

    @FindBy(css="#column-b >header")
    private WebElement headerB;

    public String getColumnA_Header(){
       return headerA.getText().trim();
    }

    public String getColumnB_Header(){
        return headerB.getText().trim();
    }

    public void dragAintoB(){
        action.clickAndHold(columnA)
                .moveToElement(columnB)
                .release()
                .perform();

    }

    public void dragBintoA(){
        action.dragAndDrop(columnB,columnA).perform();
    }


}
