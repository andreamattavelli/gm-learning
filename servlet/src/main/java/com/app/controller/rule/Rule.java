package com.app.controller.rule;

public interface Rule {

	public boolean appliesOn(String string);
	public String getErrorMessage();
	
}
