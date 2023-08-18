package com.ui.pojo;

public class GlobalDetailsPojo {
	private String oem;
	private String jobNumber;
	private String imei;
	private String product;
	private String model;
	private String warrantyStatus;
	private String actionStatus;
	public GlobalDetailsPojo(String oem, String jobNumber, String imei, String product, String model,
			String warrantyStatus, String actionStatus) {
		super();
		this.oem = oem;
		this.jobNumber = jobNumber;
		this.imei = imei;
		this.product = product;
		this.model = model;
		this.warrantyStatus = warrantyStatus;
		this.actionStatus = actionStatus;
	}
	public String getOem() {
		return oem;
	}
	public String getJobNumber() {
		return jobNumber;
	}
	public String getImei() {
		return imei;
	}
	public String getProduct() {
		return product;
	}
	public String getModel() {
		return model;
	}
	public String getWarrantyStatus() {
		return warrantyStatus;
	}
	public String getActionStatus() {
		return actionStatus;
	}
	@Override
	public String toString() {
		return "GlobalDetailsPojo [oem=" + oem + ", jobNumber=" + jobNumber + ", imei=" + imei + ", product=" + product
				+ ", model=" + model + ", warrantyStatus=" + warrantyStatus + ", actionStatus=" + actionStatus + "]";
	}
	
}
