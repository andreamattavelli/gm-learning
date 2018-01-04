package ch.gmtech;

public class MoveField {

//	class Account {
//		private AccountType _type;
//		private double _interestRate;
//		
//		double interestForAmount_days(double amount, int days) {
//			return _interestRate * amount * days / 365;
//		}
//	}
//	
//	class AccountType {
//	}
	
	class Account {
		private AccountType _type;
		
		double interestForAmount_days(double amount, int days) {
			return _type.getInterestRate() * amount * days / 365;
		}
	}
	
	class AccountType {
		private double _interestRate;

		void setInterestRate(double arg) {
			_interestRate = arg;
		}

		double getInterestRate() {
			return _interestRate;
		}
	}

}
