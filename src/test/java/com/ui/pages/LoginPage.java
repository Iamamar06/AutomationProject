package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.BrowserUtility;
import com.utils.Browsers;

public final class LoginPage extends BrowserUtility {
	public LoginPage(WebDriver wb) {
		super(wb);
		goToWebsite("http://phoenix.testautomationacademy.in/sign-in");
	}
	
	public LoginPage(Browsers browser) {
		super(browser);
		goToWebsite("http://phoenix.testautomationacademy.in/sign-in");
	}
	// page object design pattern contains instance variables(Locators),
	// methods(functionality), constructor
	//return type of functions in this pattern will return something it cant be void

	private static final By USERNAMEINPUTLOCATOR = By.id("username");
	private static final By PASSWORDINPUTLOCATOR = By.id("password");
	private static final By SIGNINBUTTONLOCATOR = By.xpath("//span[contains(text(), \"Sign in\")]/../..");
	private static final By PASSWORDVIEWBUTTONLOCATOR= By.xpath("//input[@id=\"password\"]/../../div[2]/button");
//	private static final By USERMENULOCATOR = By.xpath("//input[@placeholder=\"Search for a Job or IMEI\"]/../../../../../../../user/button");
//	private static final By SIGNOUTBUTTONLOCATOR = By.xpath("//span[contains(text(),\"Sign out\")]/..");

	
	public DashboardPage doLoginWith(String username, String password) {
		enterTextInto(USERNAMEINPUTLOCATOR, "iamfd");
		enterTextInto(PASSWORDINPUTLOCATOR, "password");
		clickOn(SIGNINBUTTONLOCATOR);
		return new DashboardPage(getDriver());
	}

//	public void doLogout() {
//		clickOn(USERMENULOCATOR);
//		clickOn(SIGNOUTBUTTONLOCATOR);
//	}
	
	public LoginPage clickOnViewpasswordButton() {
		clickOn(PASSWORDVIEWBUTTONLOCATOR);
		return new LoginPage(getDriver());
	}

}
