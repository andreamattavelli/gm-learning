package ch.gmtech;

import ch.gmtech.HideDelegate.Department;
import ch.gmtech.HideDelegate.Person;

public class RemoveMiddleMan {

//	class Person {
//		Department _department;
//
//		public Department getDepartment() {
//			return _department;
//		}
//
//		public void setDepartment(Department arg) {
//			_department = arg;
//		}
//
//		public Person getManager() {
//			return _department.getManager();
//		}
//	}
//
//	class Department {
//		private String _chargeCode;
//		private Person _manager;
//
//		public Department(Person manager) {
//			_manager = manager;
//		}
//
//		public Person getManager() {
//			return _manager;
//		}
//	}
//
//	public void toRefactor() {
//		Person john = null;
//		Person manager = john.getManager();
//	}
	
	class Person {
		Department _department;

		public Department getDepartment() {
			return _department;
		}

		public void setDepartment(Department arg) {
			_department = arg;
		}
	}

	class Department {
		private String _chargeCode;
		private Person _manager;

		public Department(Person manager) {
			_manager = manager;
		}

		public Person getManager() {
			return _manager;
		}
	}

	public void toRefactor() {
		Person john = null;
		Person manager = john.getDepartment().getManager();
	}
	
}
