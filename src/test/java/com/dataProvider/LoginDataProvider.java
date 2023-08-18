package com.dataProvider;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.utils.TestUtility;

public class LoginDataProvider {
	/*
	 * dataprovider only supports -
	 *-1D array 
	 *-2d array
	 *-Iterator 
	 */
	
	@DataProvider(name = "Login data on CSV file")
	public Iterator<String[]> logindata() {
		return TestUtility.readCSVfile("loginData.csv");
	}
	
	@DataProvider(name="Login data on Excel file")
	public String[][] excelLoginData() {
		return TestUtility.readExcelSheet("testdata.xlsx", "login");
	}
}
