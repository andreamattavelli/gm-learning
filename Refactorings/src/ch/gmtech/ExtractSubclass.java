package ch.gmtech;

public class ExtractSubclass {

//	class JobItem {
//		public JobItem(int unitPrice, int quantity, boolean isLabor, Employee employee) {
//			_unitPrice = unitPrice;
//			_quantity = quantity;
//			_isLabor = isLabor;
//			_employee = employee;
//		}
//
//		public int getTotalPrice() {
//			return getUnitPrice() * _quantity;
//		}
//
//		public int getUnitPrice() {
//			return (_isLabor) ? _employee.getRate() : _unitPrice;
//		}
//
//		public int getQuantity() {
//			return _quantity;
//		}
//
//		public Employee getEmployee() {
//			return _employee;
//		}
//
//		private int _unitPrice;
//		private int _quantity;
//		private Employee _employee;
//		private boolean _isLabor;
//	}
//
//	class Employee {
//		public Employee(int rate) {
//			_rate = rate;
//		}
//
//		public int getRate() {
//			return _rate;
//		}
//
//		private int _rate;
//	}
	
	class JobItem {
		protected JobItem(int unitPrice, int quantity) {
			_unitPrice = unitPrice;
			_quantity = quantity;
		}

		public int getTotalPrice() {
			return getUnitPrice() * _quantity;
		}

		public int getUnitPrice() {
			return _unitPrice;
		}

		public int getQuantity() {
			return _quantity;
		}
		
		protected boolean isLabor() {
			return false;
		}

		private int _unitPrice;
		private int _quantity;
		protected Employee _employee;
	}
	
	class LaborItem extends JobItem {
		public LaborItem(int quantity, Employee employee) {
			super(0, quantity);
			_employee = employee;
		}

		public Employee getEmployee() {
			return _employee;
		}

		protected boolean isLabor() {
			return true;
		}
		
		public int getUnitPrice() {
			return _employee.getRate();
		}
	}

	class Employee {
		public Employee(int rate) {
			_rate = rate;
		}

		public int getRate() {
			return _rate;
		}

		private int _rate;
	}
}
