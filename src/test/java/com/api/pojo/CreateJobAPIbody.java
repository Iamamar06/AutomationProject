package com.api.pojo;

import java.util.ArrayList;

public class CreateJobAPIbody {
	private int mst_service_location_id;
	private int mst_platform_id;
	private int mst_warrenty_status_id;
	private int mst_oem_id;
	private Customer customer;
	private CustomerAddress customer_address;
	private CustomerProduct customer_product;
	private ArrayList<Problems> problems;
	public CreateJobAPIbody(int mst_service_location_id, int mst_platform_id, int mst_warrenty_status_id,
			int mst_oem_id, Customer customer, CustomerAddress customer_address, CustomerProduct customer_product,
			ArrayList<Problems> problems) {
		super();
		this.mst_service_location_id = mst_service_location_id;
		this.mst_platform_id = mst_platform_id;
		this.mst_warrenty_status_id = mst_warrenty_status_id;
		this.mst_oem_id = mst_oem_id;
		this.customer = customer;
		this.customer_address = customer_address;
		this.customer_product = customer_product;
		this.problems = problems;
	}
	@Override
	public String toString() {
		return "CreateJobAPIbody [mst_service_location_id=" + mst_service_location_id + ", mst_platform_id="
				+ mst_platform_id + ", mst_warrenty_status_id=" + mst_warrenty_status_id + ", mst_oem_id=" + mst_oem_id
				+ ", customer=" + customer + ", customer_address=" + customer_address + ", customer_product="
				+ customer_product + ", problems=" + problems + "]";
	}
	

}
