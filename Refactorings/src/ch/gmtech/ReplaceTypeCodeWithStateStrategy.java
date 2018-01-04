package ch.gmtech;

public class ReplaceTypeCodeWithStateStrategy {

//	class Employee {
//		static final int ENGINEER = 0;
//		static final int SALESMAN = 1;
//		static final int MANAGER = 2;
//
//		private int _type;
//		private int _monthlySalary;
//		private int _commission;
//		private int _bonus;
//		
//		Employee(int type) {
//			_type = type;
//		}
//		
//		int payAmount() {
//			switch (_type) {
//			case ENGINEER:
//				return _monthlySalary;
//			case SALESMAN:
//				return _monthlySalary + _commission;
//			case MANAGER:
//				return _monthlySalary + _bonus;
//			default:
//				throw new RuntimeException("Incorrect Employee");
//			}
//		}
//	}

	class Employee {

		private EmployeeType _type;
		private int _monthlySalary;
		private int _commission;
		private int _bonus;
		
		Employee(int type) {
			setType(type);
		}

		int getType() {
			return _type.getTypeCode();
		}

		void setType(int arg) {
			
		}
		
		int payAmount() {
			switch (getType()) {
			case EmployeeType.ENGINEER:
				return _monthlySalary;
			case EmployeeType.SALESMAN:
				return _monthlySalary + _commission;
			case EmployeeType.MANAGER:
				return _monthlySalary + _bonus;
			default:
				throw new RuntimeException("Incorrect Employee");
			}
		}
	}
	
	abstract static class EmployeeType {
		static final int ENGINEER = 0;
		static final int SALESMAN = 1;
		static final int MANAGER = 2;

		abstract int getTypeCode();
		
		static EmployeeType newType(int code) {
			switch (code) {
			case ENGINEER:
				return new Engineer();
			case SALESMAN:
				return new Salesman();
			case MANAGER:
				return new Manager();

			default:
			throw new IllegalArgumentException("Incorrect Employee Code");
			}
		}
	}
	
	static class Engineer extends EmployeeType {
		int getTypeCode() {
			return EmployeeType.ENGINEER;
		}
	}

	static class Manager extends EmployeeType {
		int getTypeCode() {
			return EmployeeType.MANAGER;
		}
	}

	static class Salesman extends EmployeeType {
		int getTypeCode() {
			return EmployeeType.SALESMAN;
		}
	}
	
}
