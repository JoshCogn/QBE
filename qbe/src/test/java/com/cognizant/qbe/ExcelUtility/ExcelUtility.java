package com.cognizant.qbe.ExcelUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;
import org.testng.SkipException;

public class ExcelUtility {

	// change this later
	static String testDataExcelFileName = "QBETests.xlsx";

	// Main Directory of the project
	public static final String currentDir = System.getProperty("user.dir");

	// Location of Test data excel file
	public static String testDataExcelPath = null;

	// Excel WorkBook
	private static XSSFWorkbook excelWBook;

	// Excel Sheet
	private static XSSFSheet excelWSheet;

	// Excel cell
	private static XSSFCell cell;

	// Excel row
	private static XSSFRow row;

	// Row Number
	public static int rowNumber;

	// Column Number
	public static int columnNumber;
	
	//dictionary for column names and numbers
	public static Hashtable<String, Integer> dict = new Hashtable<String, Integer>();

	// Setter and Getters of row and columns
	public static void setRowNumber(int pRowNumber) {
		rowNumber = pRowNumber;
	}

	public static int getRowNumber() {
		return rowNumber;
	}

	public static void setColumnNumber(int pColumnNumber) {
		columnNumber = pColumnNumber;
	}

	public static int getColumnNumber() {
		return columnNumber;
	}

	// This method has two parameters: "Test data excel file name" and "Excel sheet
	// name"
	// It creates FileInputStream and set excel file and excel sheet to excelWBook
	// and excelWSheet variables.
	public static void setExcelFileSheet(String sheetName) {
		// MAC or Windows Selection for excel path
		if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
			testDataExcelPath = currentDir + "//src//test//java//resources//";
		} else if (Platform.getCurrent().toString().contains("WIN")) {
			testDataExcelPath = currentDir + "\\src\\test\\java\\resources\\";
		}
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
			excelWBook = new XSSFWorkbook(ExcelFile);
			excelWSheet = excelWBook.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// This method reads the test data from the Excel cell.
	// We are passing row number and column number as parameters.
	public static String getCellData(int RowNum, int ColNum) {
		try {
			cell = excelWSheet.getRow(RowNum).getCell(ColNum);
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// This method takes row number as a parameter and returns the data of given row
	// number.
	public static XSSFRow getRowData(int RowNum) {
		try {
			row = excelWSheet.getRow(RowNum);
			return row;
		} catch (Exception e) {
			e.printStackTrace();
			return row;
		}
	}

	// This method gets excel file, row and column number and set a value to the
	// that cell.
	public static void setCellData(String value, int RowNum, int ColNum) {
		try {
			row = excelWSheet.getRow(RowNum);
			cell = row.getCell(ColNum);
			if (cell == null) {
				cell = row.createCell(ColNum);
				cell.setCellValue(value);
			} else {
				cell.setCellValue(value);
			}
			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + testDataExcelFileName);
			excelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setCellData(int value, int RowNum, int ColNum) {
		try {
			row = excelWSheet.getRow(RowNum);
			cell = row.getCell(ColNum);
			if (cell == null) {
				cell = row.createCell(ColNum);
				cell.setCellValue(value);
			} else {
				cell.setCellValue(value);
			}
			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + testDataExcelFileName);
			excelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int getRowNumberOfLabel(String label, int colNum) {
		try {
			int numOfRows = excelWSheet.getPhysicalNumberOfRows();
			for (int i = 0; i < numOfRows; i++) {
				String cellData = getCellData(i, colNum);
				if (cellData.equalsIgnoreCase(label)) {
					//System.out.println(label + " at " + i);
					return i;
				}
			}
			System.out.println("Could not find row: " + label);
			return 2;
		} catch (Exception e) {
			e.printStackTrace();
			return 2;
		}

	}
	
	
	public static int getColumnNumberOfLabel(String columnLabel, int rowNum) {
		try {
			row = ExcelUtility.getRowData(rowNum);
			int noOfColumns = row.getLastCellNum();
			//System.out.println("search from " + startFromRow + " to " + noOfColumns);
			for (int i = 0; i < noOfColumns; i++) {
				// System.out.println(ExcelUtil.getCellData(0, i));
				if (ExcelUtility.getCellData(rowNum , i).equalsIgnoreCase(columnLabel)) {
					return i;
				}
			}
			System.err.println("Could not find column " + columnLabel);
			return 2;
		} catch (Exception e) {
			e.printStackTrace();
			
			return 2;
		}
	}
	
	public static void initialiseColumnDictionary() {
		try {
			row = ExcelUtility.getRowData(0);
			String label;
			int noOfColumns = row.getLastCellNum();
			System.out.println("numOfCols: " + noOfColumns);
			for (int i = 0; i < noOfColumns; i++) {
				// System.out.println(ExcelUtil.getCellData(0, i));
				label = ExcelUtility.getCellData(0, i);
				dict.put(label, i);
			}
			System.out.println(dict);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Could not fill column label dictionary");
		}
	}

	public static String getDataOfColumnLabel(String label) {
		//System.out.println("label: " + label + ", col num: " + dict.get(label));
		return getCellData(rowNumber,dict.get(label));	
	}

	public static void setTestCaseStatus(String string) {
		//System.out.println("Setting col: "+ dict.get("Status") + " as " + string);
		setCellData(string, rowNumber, dict.get("Status"));
	}

	public static void clearStatus() {
		//HARD CODED
		int statusColumn = dict.get("Status");
		for (int i = 1; i < 5; i++) {
			//System.out.println("clear row:" + i);
			setCellData("", i, statusColumn);
		}
	}
	
	


}
