package ch.gmtech;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

public class InduceParameterObject {

//	class Entry {
//		Entry(double value, Date chargeDate) {
//			_value = value;
//			_chargeDate = chargeDate;
//		}
//
//		Date getDate() {
//			return _chargeDate;
//		}
//
//		double getValue() {
//			return _value;
//		}
//
//		private Date _chargeDate;
//		private double _value;
//	}
//	
//	class Account {
//		double getFlowBetween(Date start, Date end) {
//			double result = 0;
//			Enumeration e = _entries.elements();
//			while (e.hasMoreElements()) {
//				Entry each = (Entry) e.nextElement();
//				if (each.getDate().equals(start) 
//						|| each.getDate().equals(end)
//						|| (each.getDate().after(start) && each.getDate().before(end))) {
//					result += each.getValue();
//				}
//			}
//			return result;
//		}
//
//		private Vector _entries = new Vector();
//	}
	
	class Entry {
		Entry(double value, Date chargeDate) {
			_value = value;
			_chargeDate = chargeDate;
		}

		Date getDate() {
			return _chargeDate;
		}

		double getValue() {
			return _value;
		}

		private Date _chargeDate;
		private double _value;
	}
	
	class Account {
		double getFlowBetween(DateRange range) {
			double result = 0;
			Enumeration e = _entries.elements();
			while (e.hasMoreElements()) {
				Entry each = (Entry) e.nextElement();
				if (range.includes(each.getDate())) {
					result += each.getValue();
				}
			}
			return result;
		}

		private Vector _entries = new Vector();
	}
	
	class DateRange {
		DateRange(Date start, Date end) {
			_start = start;
			_end = end;
		}

		Date getStart() {
			return _start;
		}

		Date getEnd() {
			return _end;
		}
		
		boolean includes(Date arg) {
			return (arg.equals(_start) || arg.equals(_end) || (arg.after(_start) && arg.before(_end)));
		}

		private final Date _start;
		private final Date _end;
	}
}
