package smell;

import java.io.PrintWriter;

public class Item {
	
	private int productId;
	private int ImageID;
	private int qty;
	private int Unitprice;

	public Item(int prodID, int ImageID, int inQty, int unitPrice) {
		this.productId = prodID;
		this.ImageID = ImageID;
		this.qty = inQty;
		this.Unitprice = unitPrice;
	}

	public int getTotal() {
		return Unitprice * qty;
	}
	
	public void writeLineItem(PrintWriter pw) {
		pw.println("Begin Line Item");
		pw.println("Product = " + productId);
		pw.println("Image = " + ImageID);
		pw.println("Quantity = " + qty);
		pw.println("Total = " + getTotal());
		pw.println("End Line Item");
	}

}
