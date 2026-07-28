package com.interview.prep.utility;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    public static Object[] [] getExcelData(String path, String sheetName){
        Object [] [] data =null;
        try {
            FileInputStream fis = new FileInputStream(path);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int totalrows=sheet.getPhysicalNumberOfRows();
            int totalcol= sheet.getRow(0).getPhysicalNumberOfCells();


            data = new Object[totalrows-1][totalcol];

            DataFormatter formatter= new DataFormatter();

            for(int i=1;i<totalrows;i++){
                var row =sheet.getRow(i);
                for(int j=0;j<totalcol;j++){
                    var cell =row.getCell(j);
                    data[i-1][j] =formatter.formatCellValue(cell);
                }

            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;

    }
}
