package com.interview.prep.web;

import com.interview.prep.base.BaseTest;
import com.interview.prep.utility.CustomListeners;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static com.interview.prep.web.DriverFactory.getDriver;

@Listeners(CustomListeners.class)
public class DynamicTableTest extends BaseTest {


    @Test
    public void testTable(){
        navigateTo("/dynamic-table");
        DynamicTablePage tablePage = new DynamicTablePage(getDriver());
        for(int i=0;i< tablePage.getTotalRows();i++){
            StringBuilder sb= new StringBuilder();
            //b=false;
            for (int j=0;j< tablePage.getTotalCol();j++){
                sb.append(tablePage.getCellValues(i,j)+"|");
            }
            String rowValue = sb.toString().trim();
            log.info(rowValue);
        }

    }
}
