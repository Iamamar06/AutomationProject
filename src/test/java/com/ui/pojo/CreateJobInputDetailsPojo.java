package com.ui.pojo;

public class CreateJobInputDetailsPojo {
	private String oemName;
	private String productName;
	private String modelName;
	private String imei;
	private String dateOfPurchase;
	private String warrantyStatus;
	private String problems;
	private String remarks;
	private String firstName;
	private String lastName;
	private String contactNo;
	private String emailId;
	private String flatNo;
	private String apartmentName;
	private String landmark;
	private String streetName;
	private String area;
	private String state;
	private String pincode;

	public CreateJobInputDetailsPojo(String oemName, String productName, String modelName, String imei,
			String dateOfPurchase, String warrantyStatus, String problems, String remarks, String firstName,
			String lastName, String contactNo, String emailId, String flatNo, String apartmentName, String landmark,
			String streetName, String area, String state, String pincode) {
		super();
		this.oemName = oemName;
		this.productName = productName;
		this.modelName = modelName;
		this.imei = imei;
		this.dateOfPurchase = dateOfPurchase;
		this.warrantyStatus = warrantyStatus;
		this.problems = problems;
		this.remarks = remarks;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.flatNo = flatNo;
		this.apartmentName = apartmentName;
		this.landmark = landmark;
		this.streetName = streetName;
		this.area = area;
		this.state = state;
		this.pincode = pincode;
	}

	public String getOemName() {
		return oemName;
	}

	public String getProductName() {
		return productName;
	}

	public String getModelName() {
		return modelName;
	}

	public String getImei() {
		return imei;
	}

	public String getDateOfPurchase() {
		return dateOfPurchase;
	}

	public String getWarrantyStatus() {
		return warrantyStatus;
	}

	public String getProblems() {
		return problems;
	}

	public String getRemarks() {
		return remarks;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public String getApartmentName() {
		return apartmentName;
	}

	public String getLandmark() {
		return landmark;
	}

	public String getStreetName() {
		return streetName;
	}

	public String getArea() {
		return area;
	}

	public String getState() {
		return state;
	}

	public String getPincode() {
		return pincode;
	}

	@Override
	public String toString() {
		return "CreateJobInputDetailsPojo [oemName=" + oemName + ", productName=" + productName + ", modelName="
				+ modelName + ", imei=" + imei + ", dateOfPurchase=" + dateOfPurchase + ", warrantyStatus="
				+ warrantyStatus + ", problems=" + problems + ", remarks=" + remarks + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", contactNo=" + contactNo + ", emailId=" + emailId + ", flatNo=" + flatNo
				+ ", apartmentName=" + apartmentName + ", landmark=" + landmark + ", streetName=" + streetName
				+ ", area=" + area + ", state=" + state + ", pincode=" + pincode + "]";
	}

}
