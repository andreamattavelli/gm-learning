package ch.gmtech;

import java.util.ArrayList;
import java.util.List;

public class Seminar {

	private String location;

	private Course course;
	private List<Enrollment> enrollments;
	
	public Seminar(Course course, String location, List<Enrollment> enrollments) {
		this.course = course;
		this.location = location;
		this.enrollments = enrollments;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

	public SeminarName getName() {
		return new SeminarName(course.getName(), course.getNumber());
	}

	public String getDescription() {
		return course.getDescription();
	}

	public int getSeatsLeft() {
		return 0;
	}

	public List<String> getStudentList() {
		List<String> students = new ArrayList<>();
		
		for (Enrollment enrollment : enrollments) {
			students.add(enrollment.getInfo());
		}
		
		return students;
	}

}
