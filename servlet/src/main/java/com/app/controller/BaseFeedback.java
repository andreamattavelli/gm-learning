package com.app.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseFeedback implements Feedback {

	private Context _context;
	private Map<String, List<String>> _map;
	
	public BaseFeedback(Context context) {
		_context = context;
		_map = new HashMap<>();
	}
	
	@Override
	public void putError(String key, String message) {
		if (_map.get(key) == null) {
			List<String> messages = new ArrayList<>();
			_map.put(key, messages);
		}
		_map.get(key).add(message);
	}
	

	@Override
	public Collection<String> getErrors(String key) {
		return _map.get(key);
	}

	@Override
	public boolean isOk() {
		return _map.isEmpty();
	}
	
	@Override
	public boolean isValid(String key) {
		return _map.get(key) == null;
	}

	@Override
	public String getParameterValue(String id) {
		return _context.request().getParameter(id);
	}
	
}
