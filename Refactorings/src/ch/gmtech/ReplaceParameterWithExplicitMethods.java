package ch.gmtech;

import ch.gmtech.ReplaceTypeCodeWithStateStrategy.EmployeeType;

public class ReplaceParameterWithExplicitMethods {

//	static class Employee {
//		static final int ENGINEER = 0;
//		static final int SALESMAN = 1;
//		static final int MANAGER = 2;
//
//		static Employee create(int type) {
//			switch (type) {
//			case ENGINEER:
//				return new Engineer();
//			case SALESMAN:
//				return new Salesman();
//			case MANAGER:
//				return new Manager();
//			default:
//				throw new IllegalArgumentException("Incorrect type code value");
//			}
//		}
//	}
//	
//	static class Engineer extends Employee {
//		int getTypeCode() {
//			return EmployeeType.ENGINEER;
//		}
//	}
//
//	static class Manager extends Employee {
//		int getTypeCode() {
//			return EmployeeType.MANAGER;
//		}
//	}
//
//	static class Salesman extends Employee {
//		int getTypeCode() {
//			return EmployeeType.SALESMAN;
//		}
//	}

	static class Employee {
		static final int ENGINEER = 0;
		static final int SALESMAN = 1;
		static final int MANAGER = 2;

		static Employee createEngineer() {
			return new Engineer();
		}

		static Employee createSalesman() {
			return new Salesman();
		}

		static Employee createManager() {
			return new Manager();
		}
	}
	
	static class Engineer extends Employee {
		int getTypeCode() {
			return EmployeeType.ENGINEER;
		}
	}

	static class Manager extends Employee {
		int getTypeCode() {
			return EmployeeType.MANAGER;
		}
	}

	static class Salesman extends Employee {
		int getTypeCode() {
			return EmployeeType.SALESMAN;
		}
	}
	
}
