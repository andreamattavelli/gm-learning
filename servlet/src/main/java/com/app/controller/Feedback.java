package com.app.controller;

import java.util.Collection;

public interface Feedback {

	public void putError(String key, String message);
	public Collection<String> getErrors(String key);
	public boolean isOk();
	public boolean isValid(String key);
	public String getParameterValue(String id);	
	
}
