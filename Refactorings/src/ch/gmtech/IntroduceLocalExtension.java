package ch.gmtech;

import java.util.Date;

public class IntroduceLocalExtension {

	class MfDateSub extends Date {
		private Date _original;
		
		public MfDateSub(String dateString) {
			super(dateString);
		};
		
		public MfDateSub(Date arg) {
			super(arg.getTime());
		}
		
		Date nextDay() {
			return new Date(getYear(), getMonth(), getDate() + 1);
		}
	}
	
}
