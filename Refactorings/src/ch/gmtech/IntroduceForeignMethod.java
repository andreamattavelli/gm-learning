package ch.gmtech;

import java.util.Date;

public class IntroduceForeignMethod {

//	public void toRefactor() {
//		Date previousEnd = null;
//
//		Date newStart = new Date(previousEnd.getYear(), previousEnd.getMonth(), previousEnd.getDate() + 1);
//	}
	
	public void toRefactor() {
		Date previousEnd = null;
		Date newStart = nextDay(previousEnd);
	}

	private static Date nextDay(Date arg) {
		return new Date(arg.getYear(), arg.getMonth(), arg.getDate() + 1);
	}
	
}
