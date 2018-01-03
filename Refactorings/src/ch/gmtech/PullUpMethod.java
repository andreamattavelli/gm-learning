package ch.gmtech;

import java.util.Date;

public class PullUpMethod {

//	abstract class Customer {
//		protected Date lastBillDate;
//
//		public void addBill(Date date, double amount) {}
//	}
//
//	class RegularCustomer extends Customer {
//		void createBill(Date date) {
//			double chargeAmount = chargeFor(lastBillDate, date);
//			addBill(date, chargeAmount);
//		}
//
//		private double chargeFor(Date lastBillDate, Date date) {
//			return -1;
//		}
//	}
//
//	class PreferredCustomer extends Customer {
//		void createBill(Date date) {
//			double chargeAmount = chargeFor(lastBillDate, date);
//			addBill(date, chargeAmount);
//		}
//
//		private double chargeFor(Date lastBillDate, Date date) {
//			return 0;
//		}
//	}
	
	
	abstract class Customer {
		protected Date lastBillDate;

		public void addBill(Date date, double amount) {}
		
		abstract double chargeFor(Date lastBillDate, Date date);
		
		void createBill(Date date) {
			double chargeAmount = chargeFor(lastBillDate, date);
			addBill(date, chargeAmount);
		}
	}

	class RegularCustomer extends Customer {
		double chargeFor(Date lastBillDate, Date date) {
			return -1;
		}
	}

	class PreferredCustomer extends Customer {
		double chargeFor(Date lastBillDate, Date date) {
			return 0;
		}
	}
}
