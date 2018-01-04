package ch.gmtech;

public class ReplaceTypeCodeWithSubclass {

//	class Employee {
//		private int _type;
//		static final int ENGINEER = 0;
//		static final int SALESMAN = 1;
//		static final int MANAGER = 2;
//
//		Employee(int type) {
//			_type = type;
//		}
//	}

	abstract class Employee {
		static final int ENGINEER = 0;
		static final int SALESMAN = 1;
		static final int MANAGER = 2;

		Employee create(int type) {
			switch (type) {
			case ENGINEER:
				return new Engineer();
			case SALESMAN:
				return new Salesman();
			case MANAGER:
				return new Manager();
			default:
				throw new IllegalArgumentException("Incorrect type code value");
			}
		}

		abstract int getType();

		public Employee() {
		}
	}

	class Engineer extends Employee {
		int getType() {
			return Employee.ENGINEER;
		}
	}

	class Salesman extends Employee {
		int getType() {
			return Employee.SALESMAN;
		}
	}

	class Manager extends Employee {
		int getType() {
			return Employee.MANAGER;
		}
	}
	
}
