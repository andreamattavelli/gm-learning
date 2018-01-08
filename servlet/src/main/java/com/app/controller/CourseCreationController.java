package com.app.controller;

import java.util.Map;

import com.app.model.Course;
import com.app.model.CourseRepository;
import com.app.view.CourseCreationLayout;

public class CourseCreationController implements Controller {

	@Override
	public boolean handles(String route) {
		return "/course/creation".equals(route);
	}

	@Override
	public void execute(Context context) throws Exception {
		context.response().setContentType("text/html");
		context.response().setCharacterEncoding("UTF-8");
		Course created = null;
		if (checkParameters(context.request().getParameterMap())) {
			created = new Course(context.request().getParameterMap().get("name")[0], 
					context.request().getParameterMap().get("number")[0], 
					context.request().getParameterMap().get("description")[0], 
					context.request().getParameterMap().get("initDate")[0], 
					context.request().getParameterMap().get("location")[0]);
			CourseRepository.getInstance().addNewCourse(created);
			context.response().sendRedirect("/course");
		} else {
			context.response().getWriter().write(new CourseCreationLayout().build().render());
		}
	}

	private boolean checkParameters(Map<String, String[]> parameterMap) {
		boolean response = true;
		response &= !parameterMap.get("name").equals("");
		return response;
	}
}
