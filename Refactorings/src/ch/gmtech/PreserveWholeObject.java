package ch.gmtech;

public class PreserveWholeObject {

//	class Room {
//		boolean withinPlan(HeatingPlan plan) {
//			int low = daysTempRange().getLow();
//			int high = daysTempRange().getHigh();
//			return plan.withinRange(low, high);
//			}
//
//		private TempRange daysTempRange() {
//			return null;
//		}
//	}
//
//	class HeatingPlan {
//		boolean withinRange (int low, int high) {
//			return (low >= _range.getLow() && high <= _range.getHigh());
//		}
//
//		private TempRange _range;
//	}
//	
//	class TempRange {
//		private int low;
//		private int high;
//		
//		public int getLow() {
//			return low;
//		}
//
//		public int getHigh() {
//			return high;
//		}
//	}
	
	class Room {
		boolean withinPlan(HeatingPlan plan) {
			return plan.withinRange(daysTempRange());
		}

		private TempRange daysTempRange() {
			return null;
		}
	}

	class HeatingPlan {
		boolean withinRange(TempRange daysTempRange) {
			return _range.includes(daysTempRange);
		}

		private TempRange _range;
	}
	
	class TempRange {
		private int low;
		private int high;
		
		public int getLow() {
			return low;
		}

		public int getHigh() {
			return high;
		}

		public boolean includes(TempRange range) {
			return (range.getLow() >= getLow() && range.getHigh() <= getHigh());
		}
	}
	
}
