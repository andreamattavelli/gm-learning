package ch.gmtech;

import java.util.HashSet;
import java.util.Set;

public class ChangeBidirectionalAssociationToUnidirectional {

//	class Order {
//		Customer getCustomer() {
//			return _customer;
//		}
//
//		void setCustomer(Customer arg) {
//			if (_customer != null)
//				_customer.friendOrders().remove(this);
//			_customer = arg;
//			if (_customer != null)
//				_customer.friendOrders().add(this);
//		}
//
//		double getDiscountedPrice() {
//			return getGrossPrice() * (1 - _customer.getDiscount());
//		}
//		
//		private int getGrossPrice() {
//			return 0;
//		}
//
//		private Customer _customer;
//	}
//
//	class Customer {
//		void addOrder(Order arg) {
//			arg.setCustomer(this);
//		}
//
//		public int getDiscount() {
//			return 0;
//		}
//
//		private Set _orders = new HashSet();
//
//		Set friendOrders() {
//			/** should only be used by Order */
//			return _orders;
//		}
//	}

	class Order {
		double getDiscountedPrice(Customer customer) {
			return getGrossPrice() * (1 - customer.getDiscount());
		}
		
		private int getGrossPrice() {
			return 0;
		}

	}

	class Customer {
		void addOrder(Order arg) {
		}

		public int getDiscount() {
			return 0;
		}

		private Set _orders = new HashSet();

		Set friendOrders() {
			/** should only be used by Order */
			return _orders;
		}
	}

}
