package com.useraccessmanagementsystem.model;

public class Software {

	private Integer id;
	private String name;
	private String description;
	private  String access_levels;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	@Override
	public String toString() {
		return "Software [id=" + id + ", name=" + name + ", description=" + description + ", access_levels="
				+ access_levels + "]";
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAccess_levels() {
		return access_levels;
	}
	public void setAccess_levels(String access_levels) {
		this.access_levels = access_levels;
	}
	
}
