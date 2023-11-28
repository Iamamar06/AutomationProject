package com.ui.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.DashboardPage;
import com.ui.pages.LoginPage;
import com.utils.TestUtility;


public class FirstScript {


	public static void main(String[] args) {
		WebDriver wb = new ChromeDriver();
		LoginPage loginPage= new LoginPage(wb);
		//DashboardPage FDDB= new DashboardPage(wb);
		loginPage.maximizeBrowserWindow();
		loginPage.clickOnViewpasswordButton();
		DashboardPage dp = loginPage.doLoginWith("iamfd", "password");
		//boolean status = dp.openJobsCretedTodayTable().searchByJob("JOB_26543");
		//System.out.println(status);
		String createdJobNO = dp.gotoCreateJobPage().createJobOnUI(TestUtility.enterCreateJobinputfields());
		boolean status = dp.gotoDashboardPage().openJobsCretedTodayTable().searchByJob(createdJobNO);
		//GlobalList gl = dp.searchJobByJobIdOrIMEINumber("JOB_25255");
		System.out.println(status);
		dp.pauseFor(10);
		//System.out.println(gl.getJobDetails());
		
		dp.terminateBrowserSession();
	}
}
