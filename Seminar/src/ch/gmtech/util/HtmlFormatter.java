package ch.gmtech.util;

import java.util.Collection;

import ch.gmtech.Student;

public class HtmlFormatter extends Formatter {

	@Override
	String formatHeader(String name, String description, String location, int seatsLeft) {
		StringBuilder builder = new StringBuilder();
		builder.append("<html>"); builder.append(System.lineSeparator());
		builder.append("<head>"); builder.append(System.lineSeparator());
		builder.append("\t<title>" + name + "<title>"); builder.append(System.lineSeparator());
		builder.append("</head>"); builder.append(System.lineSeparator());
		builder.append("<body>"); builder.append(System.lineSeparator());
		builder.append("\t<div>" + name + "</div>"); builder.append(System.lineSeparator());
		builder.append("\t<ul>"); builder.append(System.lineSeparator());
		builder.append("\t\t<li>"+description+"</li>"); builder.append(System.lineSeparator());
		builder.append("\t\t<li>"+location+"</li>"); builder.append(System.lineSeparator());
		builder.append("\t\t<li>"+Integer.toString(seatsLeft)+"</li>"); builder.append(System.lineSeparator());
		builder.append("\t</ul>"); builder.append(System.lineSeparator());
		return builder.toString();
	}

	@Override
	String formatStudentList(Collection<Student> students) {
		StringBuilder builder = new StringBuilder();
		builder.append(System.lineSeparator());
		builder.append("\t<div>partecipanti:</div>"); builder.append(System.lineSeparator());
		builder.append("\t<ul>"); builder.append(System.lineSeparator());
		for (Student student : students) {
			builder.append("\t\t<li>"+student.getInfo()+"</li>"); builder.append(System.lineSeparator());
		}
		builder.append("\t</ul>"); builder.append(System.lineSeparator());
		builder.append("</body>"); builder.append(System.lineSeparator());
		builder.append("</html>");
		return builder.toString();
	}

}
