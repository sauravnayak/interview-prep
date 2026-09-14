package com.interview.prep.utility;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static com.interview.prep.web.DriverFactory.getDriver;

public class Example implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String timestamp = new SimpleDateFormat("ddMMyyyyy").format(new Date());
        File input = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String fileName = result.getTestName() + "_" + timestamp + ".png";
        String directoryPath = "./screesnhots";
        File dest = new File(directoryPath + fileName);
        try {
            FileUtils.copyFile(input, dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void getValueFromDB(String url, String uname, String pwd) {

        try {
            Class.forName("com.mysql.sj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, uname, pwd);
            Statement statement = connection.createStatement();
            String query = "SELECT * from USERDB WHERE id=6";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int userId = resultSet.getInt("uID");
                String name = resultSet.getString("uName");
                String pass = resultSet.getString("pwd");

            }
        }
        catch ( Exception e){
            e.printStackTrace();
        }




    }


    public Object [] [] getDataFromexcel(String sheetName , String path){

        try {
            Object [] [] data ;
            FileInputStream fis = new FileInputStream(path);

            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int coulumn = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object [rowCount][coulumn];

            for (int i=1;i<rowCount;i++){

                Row row = sheet.getRow(i);
                DataFormatter formatter = new DataFormatter();

                for (int j= 0;j<coulumn;j++){
                    Cell cell = row.getCell(j);
                    data [i][j]= formatter.formatCellValue(cell);
                }
            }
            return  data;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyBrokenLink(String link ) throws IOException {

        List<WebElement> links = getDriver().findElements(By.tagName("a"));
        String linked = links.get(0).getAttribute("href");
        if(linked.startsWith("javascript")|| linked.isEmpty()){

        }
        URL url = new URL(link);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("HEAD");
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.connect();

        int status = httpURLConnection.getResponseCode();
        if(status>=400){
            System.out.println("The Status is Broken");
        }
        else {
            System.out.println("The Link is working");
        }
        WebElement fjjfb= getDriver().findElement(By.id("ddd"));
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .pollingEvery(Duration.ofMillis(500))
                .withTimeout(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(fjjfb));
        ele.getShadowRoot();

    }
}


