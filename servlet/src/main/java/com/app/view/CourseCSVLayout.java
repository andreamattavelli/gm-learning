package com.app.view;

import java.util.Collection;

import com.app.model.Student;

public class CourseCSVLayout extends CourseLayout {

	@Override
	String buildHeader(String name, String description, String location, int seatsLeft) {
		StringBuilder builder = new StringBuilder();
		builder.append(name+";"+description+";"+location+";"+Integer.toString(seatsLeft));
		builder.append(System.lineSeparator());
		return builder.toString();
	}

	@Override
	String buildStudentList(Collection<Student> students) {
		StringBuilder builder = new StringBuilder();
		for (Student student : students) {
			builder.append(student.getName()+";"+student.getSurname());
			builder.append(System.lineSeparator());
		}
		return builder.toString();
	}

}
