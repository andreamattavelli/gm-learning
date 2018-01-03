package smell;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

public class Order {

	private Vector lineItemList;

	public Order(Vector lis) {
		lineItemList = lis;
	}

	// writes this order object to the specified print writer
	public void writeOrder(PrintWriter pw) {
		Iterator iter = lineItemList.iterator();
		while (iter.hasNext()) {
			Item item = (Item) iter.next();
			item.writeLineItem(pw);
		}
		pw.println("Order total = " + getTotal());
	}

	private int getTotal() {
		Iterator iter = lineItemList.iterator();
		int total = 0;
		while (iter.hasNext()) {
			Item item = (Item) iter.next();
			total += item.getTotal();
		}
		return total;
	}

	
	public void saveOrder() throws SQLException {
		DatabaseManager manager = new DatabaseManager();
		manager.saveOrder(this);
	}
	
}
