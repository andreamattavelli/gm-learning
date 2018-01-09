package com.app.model;

import java.util.ArrayList;
import java.util.Collection;

public class Course {

	private String name;
	private String id;
	private String location;
	private String seats;
	private String initDate;
	private String description;

	private Collection<Student> students;
	
	public Course(String name, String id, String location, String seats, String startDate, String description) {
		this.name = name;
		this.id = id;
		this.location = location;
		this.seats = seats;
		this.initDate = startDate;
		this.description = description;
		this.students = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
	
	public String getSeats() {
		return seats;
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
