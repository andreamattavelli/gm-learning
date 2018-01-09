package com.app.controller.course;

import java.io.IOException;

import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.controller.Feedback;
import com.app.model.Course;
import com.app.view.CourseCreateLayout;

public class CourseCreateController extends Controller {
	
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String LOCATION = "location";
	public static final String SEATS = "seats";
	public static final String STARTDATE = "start";
	public static final String DESCRIPTION = "description";
	
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
					context.getParameter(NAME),
					context.getParameter(ID),
					context.getParameter(LOCATION),
					context.getParameter(SEATS),
					context.getParameter(STARTDATE), 
					context.getParameter(DESCRIPTION));
			context.courses().add(created);
		}
		return feedback;
	}
}
