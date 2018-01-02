package ch.gmtech;

public class SeminarName {

	private String name;
	private String number;
	
	public SeminarName(String name, String number) {
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}
	
	@Override
	public String toString() {
		return getName() + " " + getNumber();
	}

}
