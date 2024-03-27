package org.Selenium.utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	
	File excelFile = null;
	Workbook wb = null;
	Sheet sh = null;
	Row row = null;
	String value = null;
	
	
	public Workbook getWorkBook()
	{
		 excelFile = new File("data/TestData.xls");
		 try {
			wb  = WorkbookFactory.create(excelFile);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return wb;
		
	}
	
	public Sheet getMySheet(String name)
	{
		wb = getWorkBook();
		sh = wb.getSheet(name);
		return sh;
	}
	
	public int rowCount(String name)
	{
		sh = getMySheet(name);
		return sh.getLastRowNum() + 1;
		
				
	}
	
	public Row getMyRow(String name, int rowNum)
	{
		sh = getMySheet(name);
		row = sh.getRow(rowNum);
		return row;
	}
	
	public String getMyCellValue(String name, int rownum, int columnnum)
	{
		row = getMyRow(name, rownum);
		value = row.getCell(columnnum).toString();
		return value;
	}
	

}
 