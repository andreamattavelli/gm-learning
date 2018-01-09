package com.app.controller.rule;

public class DateRule implements Rule {

	@Override
	public boolean appliesOn(String string) {
		return !(string == null || !string.matches("[0-9][0-9][.][0-9][0-9][.][0-9][0-9][0-9][0-9]"));
	}

	@Override
	public String getErrorMessage() {
		return "must be a date in the format dd.mm.yyyy";
	}

}
