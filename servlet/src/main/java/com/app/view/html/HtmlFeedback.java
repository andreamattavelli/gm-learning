package com.app.view.html;

import static com.github.manliogit.javatags.lang.HtmlHelper.attr;
import static com.github.manliogit.javatags.lang.HtmlHelper.group;
import static com.github.manliogit.javatags.lang.HtmlHelper.span;
import static com.github.manliogit.javatags.lang.HtmlHelper.text;

import java.util.ArrayList;
import java.util.List;

import com.app.controller.Feedback;
import com.app.view.FeedbackDecorator;
import com.github.manliogit.javatags.element.Element;
import com.github.manliogit.javatags.element.attribute.Attribute;

public class HtmlFeedback extends FeedbackDecorator {

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

	public HtmlFeedback(Feedback feedback) {
		super(feedback);
	}

	private Type getFeedback(String key) {
		return _feedback.getErrors(key) == null ? Type.VALID : Type.ERROR;
	}
	
	public Attribute getFieldValue(String id) {
		if (_feedback.getParameterValue(id) == null) {
			return attr();
		}
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
				for (String message : _feedback.getErrors(id)) {
					elements.add(span(attr("class -> help-block"), text(message.toUpperCase())));
				}
			}
		}
		return group(elements.toArray(new Element[0]));
	}

}
