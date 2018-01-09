package com.app.controller.rule;

public class MandatoryRule implements Rule {

	@Override
	public boolean appliesOn(String string) {
		return !(string == null || string.equals(""));
	}

	@Override
	public String getErrorMessage() {
		return "mandatory field";
	}

}
