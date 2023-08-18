package com.api.pojo;

public class Problems {
	private int id;
	private String remark;
	public Problems(int id, String remark) {
		super();
		this.id = id;
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Problems [id=" + id + ", remark=" + remark + "]";
	}
	
}
