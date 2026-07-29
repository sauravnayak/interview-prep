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
import java.util.stream.Collectors;

public class DynamicTablePage {

    private final WebDriver driver;
    private final Wait wait;


    DynamicTablePage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(css =".table.table-striped")
    private WebElement tableElement;

    @FindBy(xpath="//table/thead/tr/th")
    List<WebElement> tableHeaders;

    @FindBy(xpath = "//table/tbody/tr")
    List<WebElement> tableRows;

    public int getTotalRows(){
        return tableRows.size();
    }

    public int getTotalCol(){
        return tableHeaders.size();
    }
    public List<String> getTableHeaders(){
        wait.until(ExpectedConditions.visibilityOf(tableElement));
        return tableHeaders.stream()
                .map(p-> p.getText().trim())
                .collect(Collectors.toList());
    }


    public String getCellValues(int row,int col){
        wait.until(ExpectedConditions.visibilityOf(tableElement));
        row++;
        col++;
        String cellxpath = String.format("//table/tbody/tr[%d]/td[%d]",row,col);
        WebElement ele = driver.findElement(By.xpath(cellxpath));
        return ele.getText().trim();
    }


}
