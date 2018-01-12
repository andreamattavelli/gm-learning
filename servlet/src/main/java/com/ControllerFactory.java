package com;

import static java.util.Arrays.asList;

import java.util.List;

import com.app.controller.Controller;
import com.app.controller.course.CourseController;
import com.app.controller.course.CourseCreateController;
import com.app.controller.course.CourseDeleteController;
import com.app.controller.course.CourseUpdateController;

public class ControllerFactory {

	public List<Controller> create() {
		return asList(
				new CourseController(),
				new CourseCreateController(),
				new CourseUpdateController(),
				new CourseDeleteController()
				);
	}
}
