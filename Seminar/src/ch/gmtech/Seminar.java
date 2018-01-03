package ch.gmtech;

import java.util.Collection;

public class Seminar {

	private Course course;
	private String location;

	private Collection<Student> students;
	
	public Seminar(Course course, String location, Collection<Student> students) {
		this.course = course;
		this.location = location;
		this.students = students;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return course.getName() + " " + course.getNumber();
	}

	public String getDescription() {
		return course.getDescription();
	}

	public int getSeatsLeft() {
		return 0;
	}

	public Collection<Student> getStudentList() {
		return students;
	}

}
