package com.app.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseFeedback implements Feedback {

	private Map<String, String[]> _valueMap;
	private Map<String, List<String>> _errorMap;
	
	public BaseFeedback(Context context) {
		_valueMap = context.request().getParameterMap();
		_errorMap = new HashMap<>();
	}
	
	public BaseFeedback(Map<String, String[]> valueMap) {
		_valueMap = valueMap;
		_errorMap = new HashMap<>();
	}
	
	@Override
	public void putError(String key, String message) {
		if (_errorMap.get(key) == null) {
			List<String> messages = new ArrayList<>();
			_errorMap.put(key, messages);
		}
		_errorMap.get(key).add(message);
	}
	

	@Override
	public Collection<String> getErrors(String key) {
		return _errorMap.get(key);
	}

	@Override
	public boolean isOk() {
		return _errorMap.isEmpty();
	}
	
	@Override
	public boolean isValid(String key) {
		return _errorMap.get(key) == null;
	}

	@Override
	public String getParameterValue(String id) {
		return _valueMap.get(id) == null ? null : _valueMap.get(id)[0];
	}
	
}
