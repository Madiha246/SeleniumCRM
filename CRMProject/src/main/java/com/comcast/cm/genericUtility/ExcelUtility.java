package com.comcast.cm.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
	FileInputStream fis;
	FileOutputStream fos;
	
	public String readExcelFile(String sheet, int row, int cell) throws IOException {
		fis=new FileInputStream("D:\\Selenium-ms\\CRMProject\\src\\test\\resources\\testData11.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		return wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		
	}
	
	public void writeDataInExistingCell(String sheet, int row,int cell, String value) throws  IOException {
		fis=new FileInputStream("D:\\Selenium-ms\\CRMProject\\src\\test\\resources\\testData11.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(value);
		fos=new FileOutputStream("D:\\Selenium-ms\\CRMProject\\src\\test\\resources\\testData11.xlsx");
		wb.write(fos);
	}
	
	
	public void WriteDataInNewCell(String sheet, int row,int cell, String value) throws IOException {
		fis=new FileInputStream("D:\\Selenium-ms\\CRMProject\\src\\test\\resources\\testData11.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).createCell(cell).setCellValue(value);
		fos=new FileOutputStream("D:\\Selenium-ms\\CRMProject\\src\\test\\resources\\testData11.xlsx");
		wb.write(fos);
		
	}
	
	
	
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
		fis=new FileInputStream("D:\\Selenium-ms\\CRMProject\\src\\test\\resources\\testData11.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int lastcount=wb.getSheet(sheet).getLastRowNum();
		return lastcount;
	}
}
