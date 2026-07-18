package com.interview.prep.web;

import com.interview.prep.CustomListeners;
import com.interview.prep.base.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.interview.prep.web.DriverFactory.getDriver;

@Listeners(CustomListeners.class)
public class IFrameTest extends BaseTest {

    @Test
    public void subscribeFrameTest(){
        navigateTo("/iframe");
        IframePage iframePage = new IframePage(getDriver());
        iframePage.clickSubscribe();
    }
}
