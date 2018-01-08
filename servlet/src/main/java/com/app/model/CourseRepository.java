package com.app.model;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

	private static CourseRepository instance = null;

	private List<Course> courses;

	private CourseRepository() {
		courses = new ArrayList<>();
	}

	public static CourseRepository getInstance() {
		if (instance == null) {
			instance = new CourseRepository();
		}
		return instance;
	}

	public boolean addNewCourse(Course course) {
		return courses.add(course);
	}

	public List<Course> getCourses() {
		return courses;
	}

}
