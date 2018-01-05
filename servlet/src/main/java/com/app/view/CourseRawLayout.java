package com.app.view;

import java.util.Collection;

import com.app.model.Student;

public class CourseRawLayout extends CourseLayout {

	@Override
	String buildHeader(String name, String description, String location, int seatsLeft) {
		StringBuilder builder = new StringBuilder();
		builder.append("Course name: " + name);
		builder.append(System.lineSeparator());
		builder.append("Description: " + description);
		builder.append(System.lineSeparator());
		builder.append("Location: " + location);
		builder.append(System.lineSeparator());
		builder.append("Seats left: " + Integer.toString(seatsLeft));
		builder.append(System.lineSeparator());
		return builder.toString();
	}

	@Override
	String buildStudentList(Collection<Student> students) {
		StringBuilder builder = new StringBuilder();
		builder.append("Student list:");
		builder.append(System.lineSeparator());
		for (Student student : students) {
			builder.append("- " + student.getName() + " " + student.getSurname());
			builder.append(System.lineSeparator());
		}
		return builder.toString();
	}

}
