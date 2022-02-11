//author : sachin singh chauhan

package com.makemytrip.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility {
	
	private static Sheet sheet;
	private static Properties pConfig;
	private static XSSFWorkbook workbook;
	private static File file;
	//private static FileInputStream fisExcel;
	
	
	
	
	public static void initializePropertiesFile() throws IOException {
		
		File propertiesFile = new File("D:\\makemytrip_automation\\codebase\\makemytrip_automation_fw\\resources\\config.properties");
		
		FileInputStream fis = new FileInputStream(propertiesFile);
		
		pConfig = new Properties();
		pConfig.load(fis);
	
	}
	
	public static String readProperty(String key) {
		return pConfig.getProperty(key);
	}
	
	
	public static void initializeExcelFile() throws IOException {
		
		file = new File("D:\\makemytrip_automation\\codebase\\makemytrip_automation_fw\\resources\\MakemytripTestData.xlsx");
		
		FileInputStream fisExcel = new FileInputStream(file);
		
		workbook = new XSSFWorkbook(fisExcel);
		
		sheet = workbook.getSheet("MakemytripTestData");
		
	}
	
	//this method is strongly typed, method arguments are case sensitive.
	public static String readTestData_1(int testCaseNum) {
		int actualRowNum = testCaseNum;
		Cell cell = sheet.getRow(actualRowNum).getCell(2);
		String value = cell.getStringCellValue();
		String[] arr = value.split("=");
		return arr[1];
	}
	
	public static String readTestData_2(int testCaseNum) {
		int actualRowNum = testCaseNum;
		Cell cell = sheet.getRow(actualRowNum).getCell(3);
		String value = cell.getStringCellValue();
		String[] arr = value.split("=");
		return arr[1];
	}
	
	public static String readTestData_3(int testCaseNum) {
		int actualRowNum = testCaseNum;
		Cell cell = sheet.getRow(actualRowNum).getCell(4);
		String value = cell.getStringCellValue();
		String[] arr = value.split("=");
		return arr[1];
	}
	
	public static String readTestData_4(int testCaseNum) {
		int actualRowNum = testCaseNum;
		Cell cell = sheet.getRow(actualRowNum).getCell(5);
		String value = cell.getStringCellValue();
		String[] arr = value.split("=");
		return arr[1];
	}
	
	public static String readTestData_5(int testCaseNum) {
		int actualRowNum = testCaseNum;
		Cell cell = sheet.getRow(actualRowNum).getCell(6);
		String value = cell.getStringCellValue();
		String[] arr = value.split("=");
		return arr[1];
	}
	
	public static String readTestData_6(int testCaseNum) {
		int actualRowNum = testCaseNum;
		Cell cell = sheet.getRow(actualRowNum).getCell(7);
		String value = cell.getStringCellValue();
		String[] arr = value.split("=");
		return arr[1];
	}

	
	public static String readExpectedResult( int testCaseNum) {
		int actualRowNum = testCaseNum;
		Cell cell = sheet.getRow(actualRowNum).getCell(8);
		return cell.getStringCellValue();
	}
	
	public static void writeActualResult (String actualResult, int testCaseNum) throws IOException {
		int actualRowNum = testCaseNum;
		Cell cell = sheet.getRow(actualRowNum).createCell(9);
		cell.setCellValue(actualResult);
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		fos.close();	
	}
	
}
