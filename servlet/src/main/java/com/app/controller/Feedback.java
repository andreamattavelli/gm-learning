package com.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Feedback {
	
	public enum Type {
		VALID,
		ERROR
	}

	private Context _context;
	private Map<String, List<String>> _map;
	
	public Feedback(Context context) {
		_context = context;
		_map = new HashMap<>();
	}
	
	public void putError(String key, String message) {
		if (_map.get(key) == null) {
			List<String> messages = new ArrayList<>();
			_map.put(key, messages);
		}
		_map.get(key).add(message);
	}

	public boolean isOk() {
		return _map.isEmpty();
	}
	
	public boolean isValid(String key) {
		return _map.get(key) == null;
	}
	
	public Type getFeedback(String key) {
		return _map.get(key) == null ? Type.VALID : Type.ERROR;
	}
	
	public List<String> getFeedbackMessages(String key) {
		return _map.get(key);
	}
	
	public String getParameterValue(String id) {
		return _context.request().getParameter(id);
	}
	
}
