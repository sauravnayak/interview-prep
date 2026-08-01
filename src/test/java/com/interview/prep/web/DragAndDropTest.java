package com.interview.prep.web;

import com.interview.prep.base.BaseTest;
import com.interview.prep.utility.CustomListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.interview.prep.web.DriverFactory.getDriver;

@Listeners(CustomListeners.class)
public class DragAndDropTest extends BaseTest {

    @Test
    public void draganddropTestByOldActions(){
        navigateTo("/drag-and-drop");
        DragAndDropPage dragAndDropPage= new DragAndDropPage(getDriver());

        dragAndDropPage.dragAintoB();
        Assert.assertEquals(dragAndDropPage.getColumnB_Header(),"A");

    }

    @Test
    public void draganddropTestByNewActions(){
        navigateTo("/drag-and-drop");
        DragAndDropPage dragAndDropPage= new DragAndDropPage(getDriver());

        dragAndDropPage.dragBintoA();
        Assert.assertEquals(dragAndDropPage.getColumnA_Header(),"B");

    }
}
