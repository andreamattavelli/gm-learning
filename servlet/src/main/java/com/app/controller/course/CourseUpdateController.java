package com.app.controller.course;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.app.controller.BaseFeedback;
import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.controller.Feedback;
import com.app.model.Course;
import com.app.model.CourseModelManager;
import com.app.view.html.HtmlFeedback;
import com.app.view.html.MainLayout;
import com.app.view.html.course.CourseUpdateLayout;

public class CourseUpdateController extends Controller {
	
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String LOCATION = "location";
	public static final String SEATS = "seats";
	public static final String STARTDATE = "start";
	public static final String DESCRIPTION = "description";
	
	@Override
	public boolean handles(String route) {
		return route.matches("/course/update") || route.matches("/course/[0-9]+");
	}

	@SuppressWarnings("serial")
	@Override
	public void execute(Context context) throws Exception {
		context.response().setContentType("text/html");
		context.response().setCharacterEncoding("UTF-8");

		Feedback feedback = new BaseFeedback(context);
		if (context.isPost()) {
			feedback = saveCourse(context);
			if (feedback.isOk()) {
				context.response().sendRedirect("/course");
				return;
			}
		} else {
			String id = context.request().getRequestURI().substring(context.request().getRequestURI().lastIndexOf('/')+1, context.request().getRequestURI().length());
			Course course = new CourseModelManager(context.connection()).findById(id);
			
			if (course != null) {
				Map<String, String[]> map = new HashMap<String, String[]>() {
					{
						put(NAME, new String[] {course.getName()});
						put(ID, new String[] {course.getId()});
						put(LOCATION, new String[] {course.getLocation()});
						put(SEATS, new String[] {course.getSeats()});
						put(STARTDATE, new String[] {course.getInitDate()}); 
						put(DESCRIPTION, new String[] {course.getDescription()});
					}
				};

				feedback = new BaseFeedback(map);
			}
		}
		
		context.response().getWriter().write(new MainLayout("Seminar manager", new CourseUpdateLayout(new HtmlFeedback(feedback))).build().render());
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
			new CourseModelManager(context.connection()).update(created);
		}
		return feedback;
	}
}
