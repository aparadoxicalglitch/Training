package com.firstcry.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {
    private static final String TEST_DATA_PATH = "src/resources/testdata/TestData.xlsx";
    
    public static Map<String, String> getStoreData() throws IOException {
        Map<String, String> data = new HashMap<>();
        
        FileInputStream fis = new FileInputStream(new File(TEST_DATA_PATH));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        Sheet sheet = workbook.getSheet("FindStore");
        Row row = sheet.getRow(1);
        
        data.put("storeType", row.getCell(0).getStringCellValue());
        data.put("state", row.getCell(1).getStringCellValue());
        data.put("city", row.getCell(2).getStringCellValue());
        
        workbook.close();
        fis.close();
        
        return data;
    }
    
    public static Map<String, String> getPincodeData() throws IOException {
        Map<String, String> data = new HashMap<>();
        
        FileInputStream fis = new FileInputStream(new File(TEST_DATA_PATH));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        Sheet sheet = workbook.getSheet("FindPreschool");
        Row row = sheet.getRow(1);
        
        // Convert numeric cells to string directly
        data.put("validPincode", String.valueOf((int)row.getCell(0).getNumericCellValue()));
        data.put("invalidPincode", String.valueOf((int)row.getCell(1).getNumericCellValue()));
        
        workbook.close();
        fis.close();
        
        return data;
    }
}