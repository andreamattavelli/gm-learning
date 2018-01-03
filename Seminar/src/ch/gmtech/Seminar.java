package ch.gmtech;

import java.util.ArrayList;
import java.util.List;

public class Seminar {

	private Course course;
	private String location;

	private List<Student> students;
	
	public Seminar(Course course, String location, List<Student> students) {
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

	public List<String> getStudentList() {
		List<String> studentStrings = new ArrayList<>();
		
		for (Student student : students) {
			studentStrings.add(student.getInfo());
		}
		
		return studentStrings;
	}

}
