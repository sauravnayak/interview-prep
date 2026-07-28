package com.interview.prep.web.demoqa;

import com.interview.prep.base.BaseTest;
import com.interview.prep.utility.CustomListeners;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static com.interview.prep.web.DriverFactory.getDriver;

@Listeners(CustomListeners.class)
public class QA_WindowSwitchTest extends BaseTest {

    @Test
    public void testNewWindow(){
        navigateTo("/browser-windows");
        QA_WindowsPage page= new QA_WindowsPage(getDriver());
        String parentHandle=getDriver().getWindowHandle();
        page.clickNewWindow();

        Set<String> handles= getDriver().getWindowHandles();
        for(String s:handles){
            if(!s.equals(parentHandle)){
                getDriver().switchTo().window(s);
            }
        }
        String heading =page.getHeading();
        Assert.assertEquals(heading,"This is a sample page");
        page.switchToWindow(parentHandle);
        //Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.
    }

    @Test(enabled = false)
    public void testNewMessageWindow(){
        navigateTo("/browser-windows");
        QA_WindowsPage page= new QA_WindowsPage(getDriver());
        String parentHandle=getDriver().getWindowHandle();
        page.clickNewMessageWindow();

        Wait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> handles= getDriver().getWindowHandles();
        for(String s:handles){
            if(!s.equals(parentHandle)){
                getDriver().switchTo().window(s);
                break;
            }
        }
        JavascriptExecutor js =  (JavascriptExecutor) getDriver();
        String message = (String) js.executeScript("return document.body.innerText;");
        message = message.replace("\n", "").replace("\r", "").trim();
        Assert.assertEquals(message,"Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.");
        getDriver().close();
        page.switchToWindow(parentHandle);
    }
}
