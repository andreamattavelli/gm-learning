package com.app.controller;

import com.app.view.CourseCreateLayout;

public class CourseCreateController implements Controller {

	@Override
	public boolean handles(String route) {
		return "/course/create".equals(route);
	}

	@Override
	public void execute(Context context) throws Exception {
		context.response().setContentType("text/html");
		context.response().setCharacterEncoding("UTF-8");

		context.response().getWriter().write(new CourseCreateLayout().build().render());
	}
}