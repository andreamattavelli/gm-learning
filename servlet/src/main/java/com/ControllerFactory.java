package com;

import static java.util.Arrays.asList;

import java.util.List;

import com.app.controller.Controller;
import com.app.controller.MainController;
import com.app.controller.course.CourseController;
import com.app.controller.course.CourseCreateController;

public class ControllerFactory {

	public List<Controller> create() {
		return asList(
				new MainController(),
				new CourseController(),
				new CourseCreateController()
				);
	}
}
