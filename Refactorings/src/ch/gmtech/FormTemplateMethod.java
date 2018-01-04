package ch.gmtech;

import java.util.Enumeration;

public class FormTemplateMethod {

//	class Rentals {
//		public Enumeration elements() {
//			return null;
//		}
//	}
//	
//	class Movie {
//		public String getTitle() {
//			return null;
//		}
//	}
//	
//	class Rental {
//		public Movie getMovie() {
//			return null;
//		}
//		public double getCharge() {
//			return 0.0;
//		}
//	}
//	
//	class Customer {
//		
//		private Rentals _rentals;
//		
//		public String getName() {
//			return null;
//		}
//		
//		public double getTotalCharge() {
//			return 0.0;
//		}
//		
//		public double getTotalFrequentRenterPoints() {
//			return 0.0;
//		}
//		
//		public String statement() {
//			Enumeration rentals = _rentals.elements();
//			String result = "Rental Record for " + getName() + "\n";
//			while (rentals.hasMoreElements()) {
//				Rental each = (Rental) rentals.nextElement();
//				// show figures for this rental
//				result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
//			}
//			// add footer lines
//			result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
//			result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
//			return result;
//		}
//
//		public String htmlStatement() {
//			Enumeration rentals = _rentals.elements();
//			String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
//			while (rentals.hasMoreElements()) {
//				Rental each = (Rental) rentals.nextElement();
//				// show figures for each rental
//				result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
//			}
//			// add footer lines
//			result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
//			result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints())
//					+ "</EM> frequent renter points<P>";
//			return result;
//		}
//	}
	
	class Rentals {
		public Enumeration elements() {
			return null;
		}
	}
	
	class Movie {
		public String getTitle() {
			return null;
		}
	}
	
	class Rental {
		public Movie getMovie() {
			return null;
		}
		public double getCharge() {
			return 0.0;
		}
	}
	
	class Customer {
		
		private Rentals _rentals;
		
		public String getName() {
			return null;
		}
		
		public Enumeration getRentals() {
			return _rentals.elements();
		}
		
		public double getTotalCharge() {
			return 0.0;
		}
		
		public double getTotalFrequentRenterPoints() {
			return 0.0;
		}
		
		public String statement() {
			return new TextStatement().getValue(this);
		}

		public String htmlStatement() {
			return new HtmlStatement().getValue(this);
		}
	}
	
	abstract class Statement {
		
		public String getValue(Customer customer) {
			Enumeration rentals = customer.getRentals();
			String result = headerString(customer);
			while (rentals.hasMoreElements()) {
				Rental each = (Rental) rentals.nextElement();
				// show figures for each rental
				result += rentalString(each);
			}
			result = footerString(customer);
			return result;
		}
		
		abstract String footerString(Customer customer);

		abstract String rentalString(Rental each);

		abstract String headerString(Customer customer);
		
	}
	class TextStatement extends Statement {
		
		String headerString(Customer customer) {
			return "Rental Record for " + customer.getName() + "\n";
		}

		String rentalString(Rental each) {
			return "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
		}

		String footerString(Customer customer) {
			// add footer lines
			String result = "Amount owed is " + String.valueOf(customer.getTotalCharge()) + "\n";
			result += "You earned " + String.valueOf(customer.getTotalFrequentRenterPoints()) + " frequent renter points";
			return result;
		}
		
	}
	
	class HtmlStatement extends Statement {
		
		String headerString(Customer customer) {
			return "<H1>Rentals for <EM>" + customer.getName() + "</EM></H1><P>\n";
		}
		
		String rentalString(Rental each) {
			return each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
		}

		String footerString(Customer customer) {
			// add footer lines
			String result = "<P>You owe <EM>" + String.valueOf(customer.getTotalCharge()) + "</EM><P>\n";
			result += "On this rental you earned <EM>" + String.valueOf(customer.getTotalFrequentRenterPoints())
					+ "</EM> frequent renter points<P>";
			return result;
		}
		
	}
	
	
	
}
