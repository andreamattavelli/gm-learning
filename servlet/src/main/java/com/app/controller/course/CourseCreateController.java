package com.app.controller.course;

import java.io.IOException;

import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.controller.Feedback;
import com.app.controller.rule.Rule;
import com.app.controller.rule.RuleFactory;
import com.app.model.Course;
import com.app.view.CourseCreateLayout;

public class CourseCreateController implements Controller {
	
	@Override
	public boolean handles(String route) {
		return route.matches("/course/create");
	}

	@Override
	public void execute(Context context) throws Exception {
		context.response().setContentType("text/html");
		context.response().setCharacterEncoding("UTF-8");

		Feedback feedback = new Feedback(context);
		if (context.isPost()) {
			feedback = saveCourse(context);
			if (feedback.isOk()) {
				context.response().sendRedirect("/course");
				return;
			}
		}
		
		context.response().getWriter().write(new CourseCreateLayout(feedback).build().render());
	}

	private Feedback saveCourse(Context context) throws IOException {
		Feedback feedback = applyRules(context);
		if (feedback.isOk()) {
			Course created = new Course(
					context.getParameter("name"),
					context.getParameter("number"),
					context.getParameter("description"),
					context.getParameter("initDate"),
					context.getParameter("location"));
			context.courses().add(created);
		}
		return feedback;
	}

	public Feedback applyRules(Context context) {
		Feedback feedback = new Feedback(context);
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
