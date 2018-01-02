package ch.gmtech;

import java.util.ArrayList;
import java.util.List;

public class Seminar {

	private String name;
	private String number;
	private String description;
	private String location;

	private List<Enrollment> enrollments;
	
	public Seminar(String name, String number, String description, String location, List<Enrollment> enrollments) {
		this.name = name;
		this.number = number;
		this.description = description;
		this.location = location;
		this.enrollments = enrollments;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name + " " + number;
	}

	public String getDescription() {
		return description;
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
