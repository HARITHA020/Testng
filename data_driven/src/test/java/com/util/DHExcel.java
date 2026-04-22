package com.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DHExcel {

	@DataProvider(name = "excelData", parallel = true)
	public Object[][] excelDataProvider() throws IOException {
		Object[][] arrObj = getExcelData("src\\test\\resources\\DHExcel.xlsx", "Sheet1");
		return arrObj;
	}

	private String[][] getExcelData(String FileName, String SheetName) throws IOException {
	    String[][] data = null;

	    FileInputStream file = null;
	    XSSFWorkbook workbook = null;

	    try {
	        file = new FileInputStream(FileName);
	        workbook = new XSSFWorkbook(file);

	        XSSFSheet sheet = workbook.getSheet(SheetName);
	        XSSFRow row = sheet.getRow(0);

	        int noOfRows = sheet.getPhysicalNumberOfRows();
	        int noOfCols = row.getLastCellNum();

	        data = new String[noOfRows - 1][noOfCols];

	        for (int i = 1; i < noOfRows; i++) {
	            for (int j = 0; j < noOfCols; j++) {
	                row = sheet.getRow(i);
	                Cell cell = row.getCell(j);
	                data[i - 1][j] = cell.getStringCellValue();
	            }
	        }

	    } catch (Exception e) {
	        System.out.println("The exception is " + e.getMessage());
	    } finally {
	        if (workbook != null) workbook.close();
	        if (file != null) file.close();
	    }

	    return data;
	}
	
	@DataProvider(name = "valid")
	public Object[][] excelDataProvider1() throws IOException {
		Object[][] arrObj = getExcelData("src\\test\\resources\\DHExcel.xlsx", "Sheet1");
		return new Object[][] {
			arrObj[0]
		};
	}

	@DataProvider(name = "invalid")
	public Object[][] excelDataProvider2() throws IOException {
		Object[][] arrObj = getExcelData("src\\test\\resources\\DHExcel.xlsx", "Sheet1");
		return new Object[][] {
			arrObj[1],
			arrObj[2]
		};
	}
}