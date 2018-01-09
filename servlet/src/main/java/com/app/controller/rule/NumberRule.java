package com.app.controller.rule;

public class NumberRule implements Rule {
	
	private int _value;
	private NumberComparator _comparator;
	private String _message;

	public NumberRule(int value, NumberComparator comparator) {
		_value = value;
		_comparator = comparator;
	}

	@Override
	public boolean appliesOn(String string) {
		if (string == null || !isNumber(string)) {
			_message = "must be a number";
			return false;
		}
		
		int actual = Integer.parseInt(string);

		if (_comparator == NumberComparator.GREATHER_THAN && !(actual > _value)) {
			_message = "must be greather than " + _value;
			return false;
		} else if (_comparator == NumberComparator.LESS_THAN && !(actual < _value)) {
			_message = "must be less than " + _value;
			return false;
		}
		
		return true;
	}
	
	private boolean isNumber(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@Override
	public String getErrorMessage() {
		return _message;
	}

}
