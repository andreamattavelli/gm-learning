package com.app.controller.rule;

public class CharLengthRule implements Rule {

	private int _length;
	private NumberComparator _comparator;
	private String _message;
	
	public CharLengthRule(int length, NumberComparator comparator) {
		_length = length;
		_comparator = comparator;
	}

	@Override
	public boolean appliesOn(String string) {
		if (string == null) {
			_message = "";
			return false;
		}
		
		if (_comparator == NumberComparator.GREATHER_THAN && !(string.toCharArray().length > _length)) {
			_message = "must have more than " + _length + " chars";
			return false;
		} else if (_comparator == NumberComparator.LESS_THAN && !(string.toCharArray().length < _length)) {
			_message = "must have less than " + _length + " chars";
			return false;
		}
		
		return true;
	}

	@Override
	public String getErrorMessage() {
		return _message;
	}

}
