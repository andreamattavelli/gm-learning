package ch.gmtech;

public class ReplaceConditionalWithPolymorphism {

//	class Employee {
//		int payAmount() {
//			switch (getType()) {
//			case EmployeeType.ENGINEER:
//				return _monthlySalary;
//			case EmployeeType.SALESMAN:
//				return _monthlySalary + _commission;
//			case EmployeeType.MANAGER:
//				return _monthlySalary + _bonus;
//			default:
//				throw new RuntimeException("Incorrect Employee");
//			}
//		}
//
//		int getType() {
//			return _type.getTypeCode();
//		}
//
//		private EmployeeType _type;
//		private int _monthlySalary;
//		private int _commission;
//		private int _bonus;
//	}
//
//	abstract class EmployeeType {
//		abstract int getTypeCode();
//	}
//
//	class Engineer extends EmployeeType {
//		int getTypeCode() {
//			return Employee.ENGINEER;
//		}
//	}
	
	class Employee {

		int payAmount() {
			return _type.payAmount(this);
		}
		
		public int get_monthlySalary() {
			return _monthlySalary;
		}
		public int get_commission() {
			return _commission;
		}
		public int get_bonus() {
			return _bonus;
		}
		
		private EmployeeType _type;
		private int _monthlySalary;
		private int _commission;
		private int _bonus;
	}

	abstract class EmployeeType {
		static final int ENGINEER = 0;
		static final int SALESMAN = 1;
		static final int MANAGER = 2;

		abstract int getTypeCode();
		
		abstract int payAmount(Employee employee);
	}

	class Engineer extends EmployeeType {
		int getTypeCode() {
			return EmployeeType.ENGINEER;
		}

		int payAmount(Employee employee) {
			return employee.get_monthlySalary();
		}
	}

	class Salesman extends EmployeeType {
		int getTypeCode() {
			return EmployeeType.SALESMAN;
		}

		int payAmount(Employee employee) {
			return employee.get_monthlySalary() + employee.get_commission();
		}
	}
	
	class Manager extends EmployeeType {
		int getTypeCode() {
			return EmployeeType.MANAGER;
		}

		int payAmount(Employee employee) {
			return employee.get_monthlySalary() + employee.get_bonus();
		}
	}
}
