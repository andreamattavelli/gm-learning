package com.app.model;

import java.util.ArrayList;
import java.util.Collection;

public class Course {

	private String name;
	private String number;
	private String description;
	private String initDate;
	private String location;

	private Collection<Student> students;
	
	public Course(String name, String number, String description, String initDate, String location) {
		this.name = name;
		this.number = number;
		this.description = description;
		this.initDate = initDate;
		this.location = location;
		this.students = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public String getDescription() {
		return description;
	}

	public String getInitDate() {
		return initDate;
	}

	public String getLocation() {
		return location;
	}

	public Collection<Student> getStudents() {
		return students;
	}
	
	public boolean registerStudent(Student student) {
		return students.add(student);
	}
	
}
