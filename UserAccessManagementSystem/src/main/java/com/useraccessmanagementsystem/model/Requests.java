package com.useraccessmanagementsystem.model;

public class Requests {

	private Integer id;
	private Integer user_id;
	private Integer software_id;
	private String access_type; //Read Write Admin
	private String reason;
	private String status; //Pending Approved Rejected
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getSoftware_id() {
		return software_id;
	}
	public void setSoftware_id(Integer software_id) {
		this.software_id = software_id;
	}
	public String getAccess_type() {
		return access_type;
	}
	public void setAccess_type(String access_type) {
		this.access_type = access_type;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Requests [id=" + id + ", user_id=" + user_id + ", software_id=" + software_id + ", access_type="
				+ access_type + ", reason=" + reason + ", status=" + status + "]";
	}
	
}
