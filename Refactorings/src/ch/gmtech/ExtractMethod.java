package ch.gmtech;

import java.util.Enumeration;

public class ExtractMethod {

	class Order {
		double getAmount() {
			return 0.0;
		}
	}
	
	class Orders {
		Enumeration elements() {
			return null;
		}
	}
	
	Orders _orders;
	String _name;
	
//	void printOwing() {
//		Enumeration e = _orders.elements();
//		double outstanding = 0.0;
//		// print banner
//		System.out.println ("**************************");
//		System.out.println ("***** Customer Owes ******");
//		System.out.println ("**************************");
//		// calculate outstanding
//		while (e.hasMoreElements()) {
//			Order each = (Order) e.nextElement();
//			outstanding += each.getAmount();
//		}
//		//print details
//		System.out.println ("name:" + _name);
//		System.out.println ("amount" + outstanding);
//	}

	void printOwing() {
		printBanner();
		printDetails(computeOutstanding());
	}

	private double computeOutstanding() {
		double outstanding = 0.0;
		Enumeration e = _orders.elements();
		// calculate outstanding
		while (e.hasMoreElements()) {
			Order each = (Order) e.nextElement();
			outstanding += each.getAmount();
		}
		return outstanding;
	}

	private void printDetails(double outstanding) {
		//print details
		System.out.println ("name:" + _name);
		System.out.println ("amount" + outstanding);
	}

	private void printBanner() {
		// print banner
		System.out.println ("**************************");
		System.out.println ("***** Customer Owes ******");
		System.out.println ("**************************");
	}
	
	void printOwing(double previousAmount) {
		printBanner();
		printDetails(computeOutstanding(previousAmount * 1.2));
	}

	private double computeOutstanding(double initialValue) {
		double outstanding = initialValue;
		Enumeration e = _orders.elements();
		while (e.hasMoreElements()) {
			Order each = (Order) e.nextElement();
			outstanding += each.getAmount();
		}
		return outstanding;
	}

}
