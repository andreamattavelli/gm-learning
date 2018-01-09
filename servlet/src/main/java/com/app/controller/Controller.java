package com.app.controller;

import com.app.controller.rule.Rule;
import com.app.controller.rule.RuleFactory;

public abstract class Controller {

	public abstract boolean handles(String route);
	
	public abstract void execute(Context context) throws Exception;
	
	public Feedback applyRules(Context context) {
		Feedback feedback = new BaseFeedback(context);
		for (String value : RuleFactory.rulesForCourse().keySet()) {
			for (Rule rule : RuleFactory.rulesForCourse().get(value)) {
				if (!rule.appliesOn(context.getParameter(value))) {
					feedback.putError(value, rule.getErrorMessage());
				}
			}
		}
		return feedback;
	}
	
}
