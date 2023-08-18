package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.CreateJobInputDetailsPojo;
import com.utils.BrowserUtility;
import com.utils.TestUtility;

public class CreateJobPage extends BrowserUtility{

	public CreateJobPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final By IMEI_TEXTBOX_LOCATOR = By.xpath("//input[@formcontrolname=\"imeiNo1\"]");
	private static final By DATE_INPUT_LOCATOR = By.xpath("//input[@data-placeholder=\"dd/mm/yyyy\"]");
	private static final By REMARKS_TEXTBOX_LOCATOR = By.xpath("//input[@data-placeholder=\"Remarks\"]");
	private static final By FIRST_NAME_TEXTBOX_LOCATOR = By.xpath("//input[@data-placeholder=\"First Name\"]");
	private static final By LAST_NAME_TEXTBOX_LOCATOR = By.xpath("//input[@data-placeholder=\"Last Name\"]");
	private static final By CONTACT_NO_TEXTBOX_LOCATOR = By.xpath("//input[@data-placeholder=\"Contact No.\"]");
	private static final By EMAIL_ID_TEXTBOX_LOCATOR = By.xpath("//input[@data-placeholder=\"Email Id.\"]");
	private static final By FLATORSOCIETY_NO_TEXTBOX_LOCATOR = By.xpath("//input[@data-placeholder=\"Flat/Society No.\"]");
	private static final By APARTMENT_NAME_TEXTBOX_LOCATOR = By.xpath("//input[@data-placeholder=\"Apartment Name\"]");
	private static final By STREET_NAME_TEXTBOX_LOCATOR = By.xpath("//input[@data-placeholder=\"Street Name.\"]");
	private static final By AREA_NAME_TEXTBOX_LOCATOR = By.xpath("//input[@data-placeholder=\"Area\"]");
	private static final By LANDMARK_TEXTBOX_LOCATOR = By.xpath("//input[@data-placeholder=\"Choose a Landmark\"]");
	private static final By PINCODE_TEXTBOX_LOCATOR = By.xpath("//input[@data-placeholder=\"Pincode\"]");
	private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//span[contains(text(),\"Submit\")]/..");
	private static final By OEM_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder=\"Select OEM\"]/../..");
	private static final By PRODUCT_NAME_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder=\"Select Product name\"]/../..");
	private static final By MODEL_NAME_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder=\"Select Model name\"]/../..");
	private static final By WARRANTY_STATUS_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder=\"Select Warranty Status\"]/../..");
	private static final By STATE_DROPDOWN_LOCATOR = By.xpath("//input[@data-placeholder=\"Select State\"]");
	private static final By PROBLEMS_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder=\"Select Problem\"]/../..");
	private static final By TOSTER_MESSAGE_LOCATOR = By.xpath("//span[contains(text(),'Job created successfully')]");
	
	public String createJobOnUI(CreateJobInputDetailsPojo c) {
		selectFromDropdown(OEM_DROPDOWN_LOCATOR, c.getOemName());
		selectFromDropdown(PRODUCT_NAME_DROPDOWN_LOCATOR, c.getProductName());
		selectFromDropdown(MODEL_NAME_DROPDOWN_LOCATOR, c.getModelName());
		enterTextInto(IMEI_TEXTBOX_LOCATOR, c.getImei());
		enterTextInto(DATE_INPUT_LOCATOR, c.getDateOfPurchase());
		selectFromDropdown(WARRANTY_STATUS_DROPDOWN_LOCATOR, c.getWarrantyStatus());
		selectFromDropdown(PROBLEMS_DROPDOWN_LOCATOR, c.getProblems());
		enterTextInto(REMARKS_TEXTBOX_LOCATOR, c.getRemarks());
		enterTextInto(FIRST_NAME_TEXTBOX_LOCATOR, c.getFirstName());
		enterTextInto(LAST_NAME_TEXTBOX_LOCATOR, c.getLastName());
		enterTextInto(CONTACT_NO_TEXTBOX_LOCATOR, c.getContactNo());
		enterTextInto(EMAIL_ID_TEXTBOX_LOCATOR, c.getEmailId());
		enterTextInto(FLATORSOCIETY_NO_TEXTBOX_LOCATOR, c.getFlatNo());
		enterTextInto(APARTMENT_NAME_TEXTBOX_LOCATOR, c.getApartmentName());
		enterTextInto(LANDMARK_TEXTBOX_LOCATOR, c.getLandmark());
		enterTextInto(STREET_NAME_TEXTBOX_LOCATOR, c.getStreetName());
		enterTextInto(AREA_NAME_TEXTBOX_LOCATOR, c.getArea());
		enterTextInto(PINCODE_TEXTBOX_LOCATOR, c.getPincode());
		selectFromDropdown(STATE_DROPDOWN_LOCATOR, c.getState());
		clickOn(SUBMIT_BUTTON_LOCATOR);
		String tostermessage = getVisibleText(TOSTER_MESSAGE_LOCATOR);
		String jobNo = TestUtility.extractJobNumber(tostermessage);
		System.out.println(jobNo);
		return jobNo;
	}

}
