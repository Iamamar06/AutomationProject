package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.DashboardPage;
import com.ui.pages.LoginPage;
import com.ui.pojo.GlobalDetailsPojo;
import com.utils.Browsers;

public class DashboardTest {
	LoginPage loginPage;
	DashboardPage dp;
	
	@BeforeMethod(description = "Setup for the test")
	public void setup() {
		loginPage = new LoginPage(Browsers.EDGE);
		loginPage.maximizeBrowserWindow();
		dp = loginPage.doLoginWith("iamfd", "password");
	}

	@Test(description = "verify user is able to search from job details form dashborad using job number", groups = { "sanity", "smoke" })
	public void verifyUserLogin() {
		GlobalDetailsPojo details= dp.searchJobByJobIdOrIMEINumber("null").getJobDetails();
		Assert.assertEquals(details.getJobNumber(), null);
	}

	@AfterMethod(description = "tearDown")
	public void tearDown() {
		dp.terminateBrowserSession();
	}
}
