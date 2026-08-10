package com.interview.prep.web;

import com.interview.prep.base.BaseTest;
import com.interview.prep.utility.CustomListeners;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Date;

import static com.interview.prep.web.DriverFactory.getDriver;

@Listeners(CustomListeners.class)
public class FormTests extends BaseTest {

    @Test
    public void testFormDefault() {
        navigateTo("/form-validation");
        FormPage formPage = new FormPage(getDriver());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(formPage.getContactName(), "dodo", "The Expected Value is wrong");
        softAssert.assertEquals(formPage.getContactNumber(), "012-3456789", "The Expected Value is wrong");
        softAssert.assertEquals(formPage.getDate(), "");
        softAssert.assertEquals(formPage.getPaymentSelected(), "Choose...");
        softAssert.assertAll();
    }

    @Test
    public void testFormSuccess() {
        navigateTo("/form-validation");
        FormPage formPage = new FormPage(getDriver());
        SoftAssert softAssert = new SoftAssert();

        formPage.fillContactName("Example");
        formPage.fillContactNumber("012-3456789");
        Date date = new Date();
        formPage.fillDate(date);
        formPage.fillPayment(FormPage.Paymentmethod.card);
        formPage.clickRegister();
        String url = getDriver().getCurrentUrl();
        softAssert.assertEquals(url, "https://practice.expandtesting.com/form-confirmation");
    }

    @Test
    public void testFormFailure() {
        navigateTo("/form-validation");
        FormPage formPage = new FormPage(getDriver());
        SoftAssert softAssert = new SoftAssert();
        formPage.fillContactName("");
        formPage.clickRegister();
        //Assertions
        softAssert.assertEquals(getDriver().getCurrentUrl(), "https://practice.expandtesting.com/form-validation");
        softAssert.assertEquals(formPage.getContactNameError().trim(), "Please enter your Contact name.");
        softAssert.assertEquals(formPage.getContactNumberError().trim(), "Please provide your Contact number.");
        softAssert.assertEquals(formPage.getDateError().trim(), "Please provide valid Date.");
        softAssert.assertEquals(formPage.getPaymentError().trim(), "Please select the Paymeny Method.");
        softAssert.assertAll();
    }
}
