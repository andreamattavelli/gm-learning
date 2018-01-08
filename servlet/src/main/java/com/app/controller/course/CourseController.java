package com.app.controller.course;

import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.model.CourseRepository;
import com.app.view.CourseLayout;

public class CourseController implements Controller {

	@Override
	public boolean handles(String route) {
		return route.equals("/course");
	}

	@Override
	public void execute(Context context) throws Exception {
		context.response().setContentType("text/html");
		context.response().setCharacterEncoding("UTF-8");
		
		context.response().getWriter().write(new CourseLayout(CourseRepository.getInstance().getCourses()).build().render());
	}

}
