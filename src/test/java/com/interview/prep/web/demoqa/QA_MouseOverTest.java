package com.interview.prep.web.demoqa;

import com.interview.prep.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.interview.prep.web.DriverFactory.getDriver;

public class QA_MouseOverTest extends BaseTest {

    @Test
    public void buttonHoverTest(){
        navigateTo("/tool-tips");
        QA_TooltipPage page = new QA_TooltipPage(getDriver());
        String tooltip=page.getButtonToolTip();
        Assert.assertEquals(tooltip,"You hovered over the Button");
    }
}
