package ch.gmtech;

public class MoveMethod {

//	class Account {
//		double overdraftCharge() {
//			if (_type.isPremium()) {
//				double result = 10;
//				if (_daysOverdrawn > 7)
//					result += (_daysOverdrawn - 7) * 0.85;
//				return result;
//			} else
//				return _daysOverdrawn * 1.75;
//		}
//
//		double bankCharge() {
//			double result = 4.5;
//			if (_daysOverdrawn > 0)
//				result += overdraftCharge();
//			return result;
//		}
//
//		private AccountType _type;
//		private int _daysOverdrawn;
//	}
//	
//	class AccountType {
//		public boolean isPremium() {
//			return false;
//		}
//	}

	class Account {
		double bankCharge() {
			double result = 4.5;
			if (_daysOverdrawn > 0)
				result += _type.overdraftCharge(_daysOverdrawn);
			return result;
		}

		private AccountType _type;
		private int _daysOverdrawn;
	}
	
	class AccountType {
		public boolean isPremium() {
			return false;
		}
		
		double overdraftCharge(int daysOverdrawn) {
			if (isPremium()) {
				double result = 10;
				if (daysOverdrawn > 7)
					result += (daysOverdrawn - 7) * 0.85;
				return result;
			} else
				return daysOverdrawn * 1.75;
		}
	}

}
