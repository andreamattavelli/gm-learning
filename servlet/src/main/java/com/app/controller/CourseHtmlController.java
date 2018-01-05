package com.app.controller;

import java.util.Arrays;
import java.util.List;

import com.app.model.Course;
import com.app.model.Seminar;
import com.app.model.Student;
import com.app.view.CourseHtmlLayout;

public class CourseHtmlController implements Controller {

	@Override
	public boolean handles(String route) {
		return "/course/html".equals(route);
	}

	@Override
	public void execute(Context context) throws Exception {
		context.response().setContentType("text/html");
		context.response().setCharacterEncoding("UTF-8");
		
		List<Student> student = Arrays.asList(
				new Student("Pippo", "Pluto"),
				new Student("Asd", "Qwert"));
		Seminar seminar = new Seminar(new Course("Sw Eng", "12312561", "Sw Engineering class", "12/09/2017"), "Room 918", student);

		context.response().getWriter().write(new CourseHtmlLayout().build(seminar));
	}

}
