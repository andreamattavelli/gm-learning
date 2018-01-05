package com.app.model;

public class Course {

	private String name;
	private String number;
	private String description;
	private String initDate;
	
	public Course(String name, String number, String description, String initDate) {
		this.name = name;
		this.number = number;
		this.description = description;
		this.initDate = initDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInitDate() {
		return initDate;
	}

	public void setInitDate(String initDate) {
		this.initDate = initDate;
	}
	
}
