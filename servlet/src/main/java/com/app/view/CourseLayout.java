package com.app.view;

import java.util.Collection;

import com.app.model.Seminar;
import com.app.model.Student;

public abstract class CourseLayout {

	public String build(Seminar seminar) {
		StringBuilder builder = new StringBuilder();
		builder.append(buildHeader(seminar.getName(), seminar.getDescription(), seminar.getLocation(), seminar.getSeatsLeft()));
		builder.append(buildStudentList(seminar.getStudentList()));
		return builder.toString();
	}
	
	abstract String buildHeader(String name, String description, String location, int seatsLeft);
	
	abstract String buildStudentList(Collection<Student> students);
	
}
