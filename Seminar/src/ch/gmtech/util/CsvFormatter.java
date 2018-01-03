package ch.gmtech.util;

import java.util.Collection;

import ch.gmtech.Student;

public class CsvFormatter extends Formatter {

	@Override
	String formatHeader(String name, String description, String location, int seatsLeft) {
		StringBuilder builder = new StringBuilder();
		builder.append(name+";"+description+";"+location+";"+Integer.toString(seatsLeft)); builder.append(System.lineSeparator());
		return builder.toString();
	}

	@Override
	String formatStudentList(Collection<Student> students) {
		StringBuilder builder = new StringBuilder();
		for (Student student : students) {
			builder.append(student.getName()+";"+student.getSurname()); builder.append(System.lineSeparator());
		}
		return builder.toString();
	}

}
