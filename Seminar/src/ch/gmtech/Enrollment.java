package ch.gmtech;

public class Enrollment {

	private Student student;
	
	public Enrollment(Student student) {
		this.student = student;
	}
	
	public String getInfo() {
		return student.getInfo();
	}
	
}
