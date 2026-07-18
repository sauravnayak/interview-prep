package com.interview.prep.web;

import com.interview.prep.base.BaseTest;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.interview.prep.web.DriverFactory.getDriver;

public class DropDownTest extends BaseTest {

    DropDownPage dropDownPage;

    @Test
    public void dropDownTest() throws InterruptedException {
        navigateTo("/dropdown");
        dropDownPage= new DropDownPage(getDriver());

        //Selecting by value for Option Selector
        Select optionSelect= new Select(dropDownPage.getOptionDropDown());
        optionSelect.selectByValue("2");
        Assert.assertEquals(optionSelect.getFirstSelectedOption()
                .getAttribute("value"),"2",
                "The different option was selected unfortunately");

        // Selecting by index for Element Selector
        Select elementSelect = new Select(dropDownPage.getElementsDropDown());
        elementSelect.selectByIndex(2);
        Assert.assertEquals(elementSelect.getFirstSelectedOption()
                .getAttribute("value"),"50",
                "The different value was selected unfortunately");

        // Selecting by index for Country Selector
        Select countrySelect = new Select(dropDownPage.getCountryDropDown());
        countrySelect.selectByVisibleText("India");
        Assert.assertEquals(countrySelect.getFirstSelectedOption().
                getAttribute("value"), "IN",
                "India was not selected");


    }
}
