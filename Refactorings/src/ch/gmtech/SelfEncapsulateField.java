package ch.gmtech;

public class SelfEncapsulateField {

//	class IntRange {
//		private int _low, _high;
//
//		boolean includes(int arg) {
//			return arg >= _low && arg <= _high;
//		}
//
//		void grow(int factor) {
//			_high = _high * factor;
//		}
//
//		IntRange(int low, int high) {
//			_low = low;
//			_high = high;
//		}
//	}
	
	class IntRange {
		private int _low, _high;

		public int getLow() {
			return _low;
		}

		public int getHigh() {
			return _high;
		}
		
		public void setLow(int _low) {
			this._low = _low;
		}

		public void setHigh(int _high) {
			this._high = _high;
		}

		boolean includes(int arg) {
			return arg >= getLow() && arg <= getHigh();
		}

		void grow(int factor) {
			setHigh(getHigh() * factor);
		}

		IntRange(int low, int high) {
			initialize(low, high);
		}

		private void initialize(int low, int high) {
			_low = low;
			_high = high;
		}
	}
	
}
