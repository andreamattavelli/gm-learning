package ch.gmtech;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class SeminarTest {

	@Test
	void test() {
		List<Student> student = Arrays.asList(
				new Student("Pippo", "Pluto"),
				new Student("Asd", "Qwert"));
		Seminar seminar = new Seminar(new Course("Sw Eng", "12312561", "Sw Engineering class", "12/09/2017"), "Room 918", student);

		assertEquals("Sw Eng 12312561", seminar.getName());
		assertEquals("Sw Engineering class", seminar.getDescription());
		assertEquals("Room 918", seminar.getLocation());
		assertEquals(0, seminar.getSeatsLeft());
		assertEquals(2, seminar.getStudentList().size());
		assertAll("studentlist", 
				() -> assertTrue(seminar.getStudentList().toString().contains("Pippo Pluto")),
				() -> assertTrue(seminar.getStudentList().toString().contains("Asd Qwert")));
	}

}
