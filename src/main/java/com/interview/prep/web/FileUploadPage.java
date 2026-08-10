package com.interview.prep.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FileUploadPage {
    private final WebDriver driver;
    private final Wait wait;

    FileUploadPage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="fileInput")
    private WebElement fileUploadField;

    @FindBy(id="fileSubmit")
    private  WebElement uploadButton;

    @FindBy(css = "#uploaded-files >p")
    private WebElement successMsg;

    @FindBy(css = "#flash b")
    private WebElement errorMessage;

    public void uploadFile(String path){
        wait.until(ExpectedConditions.visibilityOf(fileUploadField));
        fileUploadField.sendKeys(path);
    }

    public void clickUpload(){
        wait.until(ExpectedConditions.elementToBeClickable(uploadButton));
        uploadButton.click();
    }

    public String getUploadedMessage(){
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        return successMsg.getText();
    }

    public String getNoFileUploadedMessage(){
        wait.until(ExpectedConditions.visibilityOf(fileUploadField));
        return fileUploadField.getAttribute("validationMessage");
    }

    public String getErrorMessage(){
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }
}
