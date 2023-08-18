package com.db.pojo;

public class TR_Customer_POJO {
	private int id;
	private String first_name;
	private String last_name;
	private String mobile_number;
	private String mobile_number_alt;
	private String email_id;
	private String email_id_alt;
	private int tr_customer_address_id;
	private int is_active;
	private String created_at;
	private String modified_at;
	public TR_Customer_POJO(int id, String first_name, String last_name, String mobile_number, String mobile_number_alt,
			String email_id, String email_id_alt, int tr_customer_address_id, int is_active, String created_at,
			String modified_at) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile_number = mobile_number;
		this.mobile_number_alt = mobile_number_alt;
		this.email_id = email_id;
		this.email_id_alt = email_id_alt;
		this.tr_customer_address_id = tr_customer_address_id;
		this.is_active = is_active;
		this.created_at = created_at;
		this.modified_at = modified_at;
	}
	public int getId() {
		return id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public String getMobile_number_alt() {
		return mobile_number_alt;
	}
	public String getEmail_id() {
		return email_id;
	}
	public String getEmail_id_alt() {
		return email_id_alt;
	}
	public int getTr_customer_address_id() {
		return tr_customer_address_id;
	}
	public int getIs_active() {
		return is_active;
	}
	public String getCreated_at() {
		return created_at;
	}
	public String getModified_at() {
		return modified_at;
	}
	@Override
	public String toString() {
		return "TR_Customer_POJO [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", mobile_number=" + mobile_number + ", mobile_number_alt=" + mobile_number_alt + ", email_id="
				+ email_id + ", email_id_alt=" + email_id_alt + ", tr_customer_address_id=" + tr_customer_address_id
				+ ", is_active=" + is_active + ", created_at=" + created_at + ", modified_at=" + modified_at + "]";
	}
	
	
}
