package com.interview.prep.web;

import com.interview.prep.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static com.interview.prep.web.DriverFactory.getDriver;

public class FileUploadTests extends BaseTest {

    @Test
    public void testUploadSuccess(){
    navigateTo("/upload");
    String fileName1="test2.pdf";
    FileUploadPage fileUploadPage = new FileUploadPage(getDriver());
    String path = new File("src/test/resources/"+fileName1).getAbsolutePath();
    fileUploadPage.uploadFile(path);
    fileUploadPage.clickUpload();
    Assert.assertTrue(fileUploadPage.getUploadedMessage().contains(fileName1));

    }

    @Test
    public void testNoFileUpload() {
        navigateTo("/upload");
        String fileName1="test2.pdf";
        FileUploadPage fileUploadPage = new FileUploadPage(getDriver());
        fileUploadPage.clickUpload();
        Assert.assertTrue(fileUploadPage.getNoFileUploadedMessage().contains("Please select a file."));
    }

    @Test
    public void testFileUploadFailure() throws InterruptedException {
        navigateTo("/upload");
        String fileName1="Test.pdf";
        FileUploadPage fileUploadPage = new FileUploadPage(getDriver());
        String path = new File("src/test/resources/"+fileName1).getAbsolutePath();
        fileUploadPage.uploadFile(path);
        fileUploadPage.clickUpload();
        Assert.assertTrue(fileUploadPage.getErrorMessage()
                .contains("File too large, please select a file less than 500KB"));

    }


}
