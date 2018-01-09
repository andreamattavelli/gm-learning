package com.app.controller.rule;

public class PositiveNumberRule implements Rule {

	@Override
	public boolean appliesOn(String string) {
		if (string == null)
			return false;

		try {
			if (Integer.parseInt(string) < 0)
				return false;
			else
				return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@Override
	public String getErrorMessage() {
		return "must be a positive number";
	}

}
