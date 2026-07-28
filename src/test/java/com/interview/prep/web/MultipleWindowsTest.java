package com.interview.prep.web;

import com.interview.prep.base.BaseTest;
import com.interview.prep.utility.CustomListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Set;

import static com.interview.prep.web.DriverFactory.getDriver;

@Listeners(CustomListeners.class)
public class MultipleWindowsTest extends BaseTest {


    @Test
    public void newWindowTest() {
        navigateTo("/windows");
        MultipleWindowsPage mwpage = new MultipleWindowsPage(getDriver());
        //Getting current handle and storing it so that I can switch it whenver required
        String parentWindow = getDriver().getWindowHandle();

        //Opening a new window
        mwpage.clickNewWindowLink();

        //Making use of Page class method to switch to parent window
        mwpage.switchToWindow(parentWindow);

        //Opening another window
        mwpage.clickNewWindowLink();

        //Getting all available window to switch to it .
        Set<String> windowHandles = getDriver().getWindowHandles();
        for (String w : windowHandles) {
            if (!w.equals(parentWindow)) {
                mwpage.switchToWindow(w);
                break;
            }
        }

        Assert.assertEquals(mwpage.getHeadingLabel(), "Example of a new window page for Automation Testing Practice");
        getDriver().close();
        mwpage.switchToWindow(parentWindow);
    }
}
