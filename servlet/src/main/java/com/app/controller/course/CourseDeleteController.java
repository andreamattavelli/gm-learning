package com.app.controller.course;

import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.model.CourseModelManager;

public class CourseDeleteController extends Controller {
	
	@Override
	public boolean handles(String route) {
		return route.matches("/course/delete/[0-9]+");
	}

	@Override
	public void execute(Context context) throws Exception {
		String id = context.request().getRequestURI().substring(context.request().getRequestURI().lastIndexOf('/')+1, context.request().getRequestURI().length());
		
		new CourseModelManager(context.connection()).deleteById(id);
		
		context.response().sendRedirect("/course");
		
	}
	
}
