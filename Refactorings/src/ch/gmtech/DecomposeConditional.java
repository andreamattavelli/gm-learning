package ch.gmtech;

public class DecomposeConditional {

	private static final Date SUMMER_START = null;
	private static final Date SUMMER_END = null;
	private Date date;
	private int quantity;
	private int _winterRate;
	private int _winterServiceCharge;
	private int _summerRate;

//	void toRefactor() {
//		double charge;
//		if (date.before(SUMMER_START) || date.after(SUMMER_END))
//			charge = quantity * _winterRate + _winterServiceCharge;
//		else
//			charge = quantity * _summerRate;
//	}

	void toRefactor() {
		double charge;
		if (notSummer(date))
			charge = winterCharge(quantity);
		else
			charge = summerCharge(quantity);
	}

	private boolean notSummer(Date date) {
		return date.before(SUMMER_START) || date.after(SUMMER_END);
	}

	private double summerCharge(int quantity) {
		return quantity * _summerRate;
	}

	private double winterCharge(int quantity) {
		return quantity * _winterRate + _winterServiceCharge;
	}
	
	class Date {
		boolean before(Date date) {
			return false;
		}
		boolean after(Date date) {
			return false;
		}
	}

}
