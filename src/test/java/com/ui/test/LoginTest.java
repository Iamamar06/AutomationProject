package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.DashboardPage;
import com.ui.pages.LoginPage;
import com.utils.Browsers;

public class LoginTest {
	LoginPage loginPage;
	DashboardPage dp;

	@BeforeMethod(description = "Setup for the test")
	public void setup() {
		loginPage = new LoginPage(Browsers.EDGE);
		loginPage.maximizeBrowserWindow();
	}

	@Test(description = "test user login via UI", groups = { "sanity", "smoke" })
	public void verifyUserLogin() {
		dp = loginPage.doLoginWith("iamfd", "password");
		Assert.assertTrue(dp.getCurrentpageURL().contains("dashboard"));
	}

	@AfterMethod(description = "tearDown")
	public void tearDown() {
		dp.terminateBrowserSession();
	}
}
