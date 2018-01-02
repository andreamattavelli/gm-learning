package ch.gmtech;

import java.util.Arrays;
import java.util.List;

public class SeminarDetails {

	public static void main(String args[]) {
		Course course = new Course("Sw Eng", "12312561", "Sw Engineering class");
		List<Enrollment> enrollment = Arrays.asList(
				new Enrollment(new Student("Pippo", "Pluto")),
				new Enrollment(new Student("Asd", "Qwert")));
		Seminar seminar = new Seminar(course, "Room 918", enrollment);

		SeminarName seminarName = seminar.getName();
		System.out.println(seminarName.toString());
		System.out.println(seminar.getDescription());
		System.out.println(seminar.getLocation());
		System.out.println(seminar.getSeatsLeft());
		System.out.println(seminar.getStudentList());
	}

}
