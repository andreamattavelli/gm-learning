package ch.gmtech;

public class ReplaceTempWithQuery {

	int _quantity;
	int _itemPrice;
	
//	double getPrice() {
//		int basePrice = _quantity * _itemPrice;
//		double discountFactor;
//		if (basePrice > 1000)
//			discountFactor = 0.95;
//		else
//			discountFactor = 0.98;
//		return basePrice * discountFactor;
//	}
	
	double getPrice() {
		return getBasePrice() * discountFactor();
	}

	private double discountFactor() {
		double discountFactor;
		if (getBasePrice() > 1000)
			discountFactor = 0.95;
		else
			discountFactor = 0.98;
		return discountFactor;
	}

	private int getBasePrice() {
		return _quantity * _itemPrice;
	}
}
