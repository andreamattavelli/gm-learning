package ch.gmtech;

public class ExtractClass {

//	class Person {
//		public String getName() {
//			return _name;
//		}
//
//		public String getTelephoneNumber() {
//			return ("(" + _officeAreaCode + ") " + _officeNumber);
//		}
//
//		String getOfficeAreaCode() {
//			return _officeAreaCode;
//		}
//
//		void setOfficeAreaCode(String arg) {
//			_officeAreaCode = arg;
//		}
//
//		String getOfficeNumber() {
//			return _officeNumber;
//		}
//
//		void setOfficeNumber(String arg) {
//			_officeNumber = arg;
//		}
//
//		private String _name;
//		private String _officeAreaCode;
//		private String _officeNumber;
//	}

	class Person {
		public String getName() {
			return _name;
		}

		public String getTelephoneNumber() {
			return telephone.getTelephoneNumber();
		}

		private String _name;
		private Telephone telephone;
	}
	
	class Telephone {
		private String _officeAreaCode;
		private String _officeNumber;
		
		String getOfficeAreaCode() {
			return _officeAreaCode;
		}

		void setOfficeAreaCode(String arg) {
			_officeAreaCode = arg;
		}

		String getOfficeNumber() {
			return _officeNumber;
		}

		void setOfficeNumber(String arg) {
			_officeNumber = arg;
		}
		
		public String getTelephoneNumber() {
			return ("(" + _officeAreaCode + ") " + _officeNumber);
		}
	}
	
}
