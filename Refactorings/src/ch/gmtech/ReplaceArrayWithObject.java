package ch.gmtech;

public class ReplaceArrayWithObject {

//	public void toRefactor() {
//		String[] row = new String[3];
//		row [0] = "Liverpool";
//		row [1] = "15";
//		String name = row[0];
//		int wins = Integer.parseInt(row[1]);
//	}

	public void toRefactor() {
		Performance row = new Performance();
		row.setName("Liverpool");
		row.setWins("15");
		String name = row.getName();
		int wins = row.getWins();
	}
	
	class Performance {
		private String[] _data = new String[3];
		private String _name;
		private String _wins;
		
		public String getName() {
			return _name;
		}

		public void setName(String arg) {
			_name = arg;
		}
		
		public int getWins() {
			return Integer.parseInt(_wins);
		}

		public void setWins(String arg) {
			_wins = arg;
		}
	}
	
}
