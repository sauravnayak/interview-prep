package com.interview.prep.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Formatter;

public class FormPage {

    private final WebDriver driver;
    private final Wait wait;

    FormPage(WebDriver driver){
        this.driver=driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "validationCustom01")
    private WebElement contactNameField;

    @FindBy(xpath = "//input[@type='tel']")
    private WebElement contactNumberField;

    @FindBy(xpath = "//input[@type='date']")
    private WebElement datePicker;

    @FindBy(id="validationCustom04")
    private WebElement paymenthMethod;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement registerButton;

    public void fillContactName(String name){
        wait.until(ExpectedConditions.visibilityOf(contactNameField));
        contactNameField.clear();
        contactNameField.sendKeys(name);
    }

    public String getContactName(){
        wait.until(ExpectedConditions.visibilityOf(contactNameField));
        return contactNameField.getAttribute("value");
    }

    public void fillContactNumber(String number){
        wait.until(ExpectedConditions.visibilityOf(contactNumberField));
        if ((number.length()>9)){
            number=number.substring(0,9);
        }
        contactNumberField.clear();
        contactNumberField.sendKeys(number);
    }

    public String getContactNumber(){
        wait.until(ExpectedConditions.visibilityOf(contactNumberField));
        return contactNumberField.getAttribute("placeholder");
    }

    public void fillDate(Date date){
        wait.until(ExpectedConditions.visibilityOf(datePicker));
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate= formatter.format(date);
        datePicker.clear();
        datePicker.sendKeys(formattedDate);
    }

    public String getDate(){
        wait.until(ExpectedConditions.visibilityOf(datePicker));
        return datePicker.getAttribute("value");
    }

    public void fillPayment(Paymentmethod method){
        wait.until(ExpectedConditions.visibilityOf(paymenthMethod));
        Select select = new Select(paymenthMethod);
        if(method.equals(Paymentmethod.cash_on_delivery)){
            select.selectByIndex(1);
        }
        else if(method.equals(Paymentmethod.card))
            select.selectByIndex(2);
    }

    public String getPaymentSelected(){
        wait.until(ExpectedConditions.visibilityOf(paymenthMethod));
        Select select = new Select(paymenthMethod);
        return select.getFirstSelectedOption().getText();
    }

    public void clickRegister(){
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        registerButton.click();
    }

    public enum Paymentmethod{
        cash_on_delivery,
        card
    }

    public String getContactNumberError(){
        return contactNumberField.findElement
                (By.xpath("following-sibling::div[@class='invalid-feedback']")).getText();
    }

    public String getContactNameError(){
        return contactNameField.findElement
                (By.xpath("following-sibling::div[@class='invalid-feedback']")).getText();
    }

    public String getDateError(){
        return datePicker.findElement
                (By.xpath("following-sibling::div[@class='invalid-feedback']")).getText();
    }
    public String getPaymentError(){
        return paymenthMethod.findElement
                (By.xpath("following-sibling::div[@class='invalid-feedback']")).getText();
    }


}
