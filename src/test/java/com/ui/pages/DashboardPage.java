package com.ui.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.GlobalDetailsPojo;
import com.utils.BrowserUtility;
import com.utils.Browsers;
import com.utils.TestUtility;

public class DashboardPage extends BrowserUtility {
	public DashboardPage(WebDriver wb) {
		super(wb);
		// TODO Auto-generated constructor stub
	}
	
	public DashboardPage(Browsers browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}

	private final static By PENDING_FOR_DELIVERY_JOBS_BUTTON_LOCATOR = By
			.xpath("//div[contains(text(),\"Pending for delivery\")]/../div/button");
	private final static By CREATED_JOB_TODAY_BUTTON_LOCATOR = By
			.xpath("//div[contains(text(),\"Created today\")]/../div/button");
	private final static By PENDING_FOR_FST_ASSIGNMENT_BUTTON_LOCATOR = By
			.xpath("//div[contains(text(),\"Pending for FST assignment\")]/../div/button");
	private final static By SEARCHJOBFIELDLOCATOR = By.id("mat-input-2");
	private final static By USERMENULOCATOR = By
			.xpath("//input[@data-placeholder=\"Search for a Job or IMEI\" ]/../../../../../../../user/button");
	private final static By SIGNOUTBUTTONLOCATOR = By.xpath("//span[contains(text(),\"Sign out\")]/..");
	private final static By CREATE_JOB_PAGE_LINK_LOCATOR = By.xpath("//span[contains(text(),\"Create Job\")]/../../..");
	private final static By READYFORDELIVERYPAGELINKLOCATOR = By
			.xpath("//span[contains(text(),\"Ready for delivery\")]/../../..");
	private final static By DASHBOARDPAGELINKLOCATOR = By.xpath("//span[contains(text(),\"Dashboard\")]/../../..");
	private final static By DOWNLOADDELIVERYNOTEPAGELINKLOCATOR = By
			.xpath("//span[contains(text(),\"Download  Delivery Note\")]/../../..");
	private final static By INWARDCCJOBSPAGELINKLOCATOR = By
			.xpath("//span[contains(text(),\"Inward CC Jobs\")]/../../..");
	private final static By JOBS_TABLE_LOCATOR = By.xpath("//mat-table/mat-row");

	// private final static By
	public DashboardPage opemPendingForDeliveryJobsTable() {
		clickOn(PENDING_FOR_DELIVERY_JOBS_BUTTON_LOCATOR);
		return new DashboardPage(getDriver());
	}

	public DashboardPage openJobsCretedTodayTable() {
		clickOn(CREATED_JOB_TODAY_BUTTON_LOCATOR);
		return new DashboardPage(getDriver());
	}

	public DashboardPage checkPendingForFSTAssignmentJobs() {
		clickOn(PENDING_FOR_FST_ASSIGNMENT_BUTTON_LOCATOR);
		return new DashboardPage(getDriver());
	}

	public boolean searchByJob(String jobNumber) {
		pauseFor(1);
		ArrayList<GlobalDetailsPojo> dataList= getTableData(JOBS_TABLE_LOCATOR, By.xpath(".//mat-cell"));
		List<GlobalDetailsPojo> resultsList = TestUtility.searchDataInList(dataList, jobNumber);	
		System.out.println(resultsList);
		if (resultsList.size() > 0) {
			return true;
		}
		else return false;
	}

	public CreateJobPage gotoCreateJobPage() {
		clickOn(CREATE_JOB_PAGE_LINK_LOCATOR);
		return new CreateJobPage(getDriver());
	}

	public void gotoReadyForDeliveryPage() {
		clickOn(READYFORDELIVERYPAGELINKLOCATOR);
	}

	public void gotoDownloadDeviveryNotePage() {
		clickOn(DOWNLOADDELIVERYNOTEPAGELINKLOCATOR);
	}

	public void gotoInwardCCJobsPage() {
		clickOn(INWARDCCJOBSPAGELINKLOCATOR);
	}

	public DashboardPage gotoDashboardPage() {
		clickOn(DASHBOARDPAGELINKLOCATOR);
		return new DashboardPage(getDriver());
	}

	public GlobalList searchJobByJobIdOrIMEINumber(String enterJobIdOrIMEINo) {
		clearText(SEARCHJOBFIELDLOCATOR);
		enterTextInto(SEARCHJOBFIELDLOCATOR, enterJobIdOrIMEINo);
		enterKeyInto(SEARCHJOBFIELDLOCATOR, Keys.ENTER);
		return new GlobalList(getDriver());
	}

	public void doLogout() {
		clickOn(USERMENULOCATOR);
		clickOn(SIGNOUTBUTTONLOCATOR);
	}

}
