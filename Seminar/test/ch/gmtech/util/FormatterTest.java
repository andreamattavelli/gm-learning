package ch.gmtech.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import ch.gmtech.Course;
import ch.gmtech.Seminar;
import ch.gmtech.Student;

public class FormatterTest {

	@Test
	void testCsv() {
		List<Student> student = Arrays.asList(
				new Student("Pippo", "Pluto"),
				new Student("Asd", "Qwert"));
		Seminar seminar = new Seminar(new Course("Sw Eng", "12312561", "Sw Engineering class"), "Room 918", student);

		Formatter formatter = new CsvFormatter();
		
		String expected = "Sw Eng 12312561;Sw Engineering class;Room 918;0\n" + 
				"Pippo;Pluto\n" + 
				"Asd;Qwert\n";
		String actual = formatter.format(seminar);
		assertEquals(expected, actual);
	}
	
	@Test
	void testHtml() {
		List<Student> student = Arrays.asList(
				new Student("Pippo", "Pluto"),
				new Student("Asd", "Qwert"));
		Seminar seminar = new Seminar(new Course("Sw Eng", "12312561", "Sw Engineering class"), "Room 918", student);

		Formatter formatter = new HtmlFormatter();

		String expected = "<html>\n" + 
				"<head>\n" + 
				"	<title>Sw Eng 12312561<title>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"	<div>Sw Eng 12312561</div>\n" + 
				"	<ul>\n" + 
				"		<li>Sw Engineering class</li>\n" + 
				"		<li>Room 918</li>\n" + 
				"		<li>0</li>\n" + 
				"	</ul>\n" + 
				"\n" + 
				"	<div>partecipanti:</div>\n" + 
				"	<ul>\n" + 
				"		<li>Pippo Pluto</li>\n" + 
				"		<li>Asd Qwert</li>\n" + 
				"	</ul>\n" + 
				"</body>\n" + 
				"</html>";
		String actual = formatter.format(seminar);
		assertEquals(expected, actual);
	}
	
}
