package ch.gmtech.util;

import java.util.Collection;

import ch.gmtech.Seminar;
import ch.gmtech.Student;

public abstract class Formatter {
	
	public String format(Seminar seminar) {
		StringBuilder builder = new StringBuilder();
		builder.append(formatHeader(seminar.getName(), seminar.getDescription(), seminar.getLocation(), seminar.getSeatsLeft()));
		builder.append(formatStudentList(seminar.getStudentList()));
		return builder.toString();
	}

	abstract String formatHeader(String name, String description, String location, int seatsLeft);
	
	abstract String formatStudentList(Collection<Student> students);

}
