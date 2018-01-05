package com;

import static java.util.Arrays.asList;

import java.util.List;

import com.app.controller.Controller;
import com.app.controller.CourseCreationController;
import com.app.controller.MainController;

public class ControllerFactory {

	public List<Controller> create() {
		return asList(
				new MainController(),
				new CourseCreationController()
				);
	}
}
