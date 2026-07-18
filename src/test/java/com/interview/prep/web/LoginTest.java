package com.interview.prep.web;

import com.interview.prep.CustomListeners;
import com.interview.prep.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.interview.prep.web.DriverFactory.getDriver;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {


    @Test()
    public void successFulLoginTest() {
        String path ="/login", username="practice", password="SuperSecretPassword!";
        String successmessage="You logged into a secure area!";
        LoginPage loginPage = new LoginPage(getDriver());

        navigateTo(path);
        log.info("Login into application with {} and password {}", username, "**********");
        loginPage.login(username, password);
        log.info("Login successful");
        Assert.assertEquals(loginPage.getLoginMessage(),successmessage);
        Assert.assertTrue(loginPage.isLogoutDisplayed());
        Assert.assertTrue(loginPage.isSecureURL());

    }

    @Test()
    public void usernameFailureLoginTest() {
        String path ="/login", username="wrongj", password="SuperSecretPassword!";
        String userNameError="Your username is invalid!";
        LoginPage loginPage = new LoginPage(getDriver());
        navigateTo(path);
        log.info("Login into application with {} and password {}", username, "*********");
        loginPage.login(username, password);
        Assert.assertEquals(loginPage.getLoginMessage(),userNameError);
        Assert.assertFalse(loginPage.isSecureURL());
        log.info("UserName Error Message Validated");

    }
    @Test()
    public void passwordFailureLoginTest() {
        String path ="/login", username="practice", password="wrongPassword!";
        String pwdError="Your password is invalid!";
        LoginPage loginPage = new LoginPage(getDriver());
        navigateTo(path);
        log.info("Login into application with {} and password {}", username, "***********");
        loginPage.login(username, password);
        Assert.assertEquals(loginPage.getLoginMessage(),pwdError);
        Assert.assertFalse(loginPage.isSecureURL());
        log.info("password Error Message Validated");

    }
}
