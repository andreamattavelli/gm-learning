package ch.gmtech;

public class IntroduceNullObject {

//	class Site {
//		Customer getCustomer() {
//			return _customer;
//		}
//
//		Customer _customer;
//	}
//
//	static class BillingPlan {
//		public static BillingPlan basic() {
//			return null;
//		}
//	}
//
//	class Customer {
//		private String name;
//
//		public String getName() {
//			return name;
//		}
//
//		public BillingPlan getPlan() {
//			return null;
//		}
//
//		public PaymentHistory getHistory() {
//			return null;
//		}
//	}
//
//	public class PaymentHistory {
//		int getWeeksDelinquentInLastYear() {
//			return 365;
//		}
//	}
//	
//	private Site site;
//	
//	public void toRefactor() {
//		Customer customer = site.getCustomer();
//		BillingPlan plan;
//		if (customer == null) plan = BillingPlan.basic();
//		else plan = customer.getPlan();
//		// ...
//		String customerName;
//		if (customer == null) customerName = "occupant";
//		else customerName = customer.getName();
//		// ...
//		int weeksDelinquent;
//		if (customer == null) weeksDelinquent = 0;
//		else weeksDelinquent =
//		customer.getHistory().getWeeksDelinquentInLastYear();
//	}

	class Site {
		Customer getCustomer() {
			return _customer;
		}

		Customer _customer;
	}

	static class BillingPlan {
		public static BillingPlan basic() {
			return null;
		}
	}

	static class Customer {
		private String name;

		public String getName() {
			return name;
		}

		public BillingPlan getPlan() {
			return null;
		}

		public PaymentHistory getHistory() {
			return null;
		}
		
		public boolean isNull() {
			return false;
		}
		
		static Customer newNull() {
			return new NullCustomer();
		}
	}
	
	static class NullCustomer extends Customer {
		public boolean isNull() {
			return true;
		}
		public String getName() {
			return "occupant";
		}
		public BillingPlan getPlan() {
			return BillingPlan.basic();
		}

		public PaymentHistory getHistory() {
			return PaymentHistory.newNull();
		}
	}

	static class PaymentHistory {
		int getWeeksDelinquentInLastYear() {
			return 365;
		}

		public static PaymentHistory newNull() {
			return new NullPaymentHistory();
		}
	}
	
	static class NullPaymentHistory extends PaymentHistory {
		int getWeeksDelinquentInLastYear() {
			return 0;
		}
	}
	
	private Site site;
	
	public void toRefactor() {
		Customer customer = site.getCustomer();
		BillingPlan plan = customer.getPlan();
		// ...
		String customerName = customer.getName();
		// ...
		int weeksDelinquent = customer.getHistory().getWeeksDelinquentInLastYear();
	}
	
	
	
}
