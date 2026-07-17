package com.interview.prep.web;

import com.interview.prep.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.interview.prep.web.DriverFactory.getDriver;

public class LoginTest extends BaseTest {

    @Test()
    public void successFulLoginTest() {
        String path ="/login", username="practice", password="SuperSecretPassword!";
        String message="You logged into a secure area!";
        navigateTo(path);
        LoginPage loginPage = new LoginPage(getDriver());
        log.info("Login into application with "+ username+ " and password "+password);
        loginPage.login(username, password);
        log.info("Login successful");
        Assert.assertEquals(loginPage.getLoginMessage(),message);

    }
}
