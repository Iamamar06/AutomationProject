package com.readCSV;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcelFile {
	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\testData\\testdata.xlsx");
		XSSFSheet sheet = workbook.getSheet("login");
		XSSFRow rowHeader = sheet.getRow(0);
		int lastRowIndex = sheet.getLastRowNum();
		int totalColumns = rowHeader.getLastCellNum();
		XSSFRow row;
		XSSFCell cell;
		String[][] excelArray= new String[lastRowIndex][totalColumns];
		for (int rowIndex = 1; rowIndex <= lastRowIndex; rowIndex++) {
			row = sheet.getRow(rowIndex);
			for (int cellIndex = 0; cellIndex < totalColumns; cellIndex++) {
				cell = row.getCell(cellIndex);
				excelArray[rowIndex-1][cellIndex] = cell.toString();
			}
		}
		System.out.println(Arrays.deepToString(excelArray));
	}
}
