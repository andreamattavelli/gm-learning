package com.app.controller;

import static com.github.manliogit.javatags.lang.HtmlHelper.attr;
import static com.github.manliogit.javatags.lang.HtmlHelper.group;
import static com.github.manliogit.javatags.lang.HtmlHelper.span;
import static com.github.manliogit.javatags.lang.HtmlHelper.text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.manliogit.javatags.element.Element;
import com.github.manliogit.javatags.element.attribute.Attribute;

public class Feedback {
	
	public enum Type {
		VALID("has-success", "glyphicon-ok"),
		ERROR("has-error", "glyphicon-remove");
		
		private final String _cssClass;
		private final String _cssIcon;
		
		private Type(String cssClass, String cssIcon) {
			_cssClass = cssClass;
			_cssIcon = cssIcon;
		}

		public String getCssClass() {
			return _cssClass;
		}

		public String getCssIcon() {
			return _cssIcon;
		}
		
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
	
	private Type getFeedback(String key) {
		return _map.get(key) == null ? Type.VALID : Type.ERROR;
	}
	
	public String getParameterValue(String id) {
		return _context.request().getParameter(id);
	}

	public Attribute getFieldValue(String id) {
		if (isOk())
			return attr();
		return attr("value -> " + getParameterValue(id));
	}

	public Attribute getAttribute(String id) {
		String cssClass = "class -> form-group";
		if (!isOk()) {
			cssClass += " has-feedback" + " " + getFeedback(id).getCssClass();
		}
		return attr(cssClass);
	}

	public Element getErrorMessages(String id) {
		List<Element> elements = new ArrayList<Element>();
		if (!isOk()) {
			elements.add(span(attr("class -> glyphicon form-control-feedback " + getFeedback(id).getCssIcon())));
			if (getFeedback(id) == Type.ERROR) {
				for (String message : _map.get(id)) {
					elements.add(span(attr("class -> help-block"), text(message.toUpperCase())));
				}
			}
		}
		return group(elements.toArray(new Element[0]));
	}
	
}
