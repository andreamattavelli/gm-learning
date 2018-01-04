package ch.gmtech;

public class ReplaceDataValueWithObject {

//	class Order {
//		public Order(String customer) {
//			_customer = customer;
//		}
//
//		public String getCustomer() {
//			return _customer;
//		}
//
//		public void setCustomer(String arg) {
//			_customer = arg;
//		}
//
//		private String _customer;
//	}

	class Order {
		public Order(String customer) {
			_customer = new Customer(customer);
		}

		public String getCustomer() {
			return _customer.getName();
		}

		public void setCustomer(String arg) {
			_customer = new Customer(arg);
		}

		private Customer _customer;
	}

	class Customer {
		public Customer(String name) {
			_name = name;
		}

		public String getName() {
			return _name;
		}

		private final String _name;
	}
	
}
