package ch.gmtech;

public class RemoveSettingMethod {

//	class Account {
//		private String _id;
//
//		Account(String id) {
//			setId(id);
//		}
//
//		void setId(String arg) {
//			_id = "ZZ" + arg;
//		}
//	}
//
//	class InterestAccount extends Account {
//		private double _interestRate;
//
//		InterestAccount(String id, double rate) {
//			super(id);
//			setId(id);
//			_interestRate = rate;
//		}
//	}

	class Account {
		private String _id;

		Account(String id) {
			initialize(id);
		}

		void initialize(String arg) {
			_id = "ZZ" + arg;
		}
	}

	class InterestAccount extends Account {
		private double _interestRate;

		InterestAccount(String id, double rate) {
			super(id);
			_interestRate = rate;
		}
	}
	
}
