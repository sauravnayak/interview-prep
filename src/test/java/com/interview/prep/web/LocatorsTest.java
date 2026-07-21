package com.interview.prep.web;

import com.interview.prep.utility.CustomListeners;
import com.interview.prep.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.interview.prep.web.DriverFactory.getDriver;

@Listeners(CustomListeners.class)
public class LocatorsTest extends BaseTest {


    LocatorsPage locatorsPage;

    @Test
    public void locatorsTest(){
        locatorsPage= new LocatorsPage(getDriver());
            navigateTo("/locators");
         for (WebElement el: locatorsPage.getAllElementsToVerify()){
             Assert.assertTrue(el.isDisplayed(),"the element"+el.toString()+"is not displayed");
         }
         log.info("All locators have been validated successfully");

    }
}
