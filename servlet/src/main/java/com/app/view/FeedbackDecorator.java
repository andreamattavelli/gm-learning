package com.app.view;

import java.util.Collection;

import com.app.controller.Feedback;

public abstract class FeedbackDecorator implements Feedback {

	protected Feedback _feedback;
	
	public FeedbackDecorator(Feedback feedback) {
		_feedback = feedback;
	}

	@Override
	public void putError(String key, String message) {
		_feedback.putError(key, message);
	}

	@Override
	public Collection<String> getErrors(String key) {
		return _feedback.getErrors(key);
	}

	@Override
	public boolean isOk() {
		return _feedback.isOk();
	}

	@Override
	public boolean isValid(String key) {
		return _feedback.isValid(key);
	}

	@Override
	public String getParameterValue(String id) {
		return _feedback.getParameterValue(id);
	}

}
