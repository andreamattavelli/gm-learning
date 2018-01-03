package ch.gmtech;

public class Student {

	private String name;
	private String surname;
	
	public Student(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public String getFullName() {
		return name + " " + surname;
	}

	public String getInfo() {
		return getFullName();
	}
}
