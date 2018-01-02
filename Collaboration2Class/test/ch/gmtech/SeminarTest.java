package ch.gmtech;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class SeminarTest {

	@Test
	void test() {
		Course course = new Course("Sw Eng", "12312561", "Sw Engineering class");
		List<Enrollment> enrollment = Arrays.asList(
				new Enrollment(new Student("Pippo", "Pluto")),
				new Enrollment(new Student("Asd", "Qwert")));
		Seminar seminar = new Seminar(course, "Room 918", enrollment);

		assertEquals("Sw Eng 12312561", seminar.getName());
		assertEquals("Sw Engineering class", seminar.getDescription());
		assertEquals("Room 918", seminar.getLocation());
		assertEquals(0, seminar.getSeatsLeft());
		assertEquals(2, seminar.getStudentList().size());
		assertAll("studentlist", 
				() -> assertEquals("Pippo Pluto", seminar.getStudentList().get(0)),
				() -> assertEquals("Asd Qwert", seminar.getStudentList().get(1)));
	}

}
