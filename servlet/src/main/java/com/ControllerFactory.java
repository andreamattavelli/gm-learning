package com;

import static java.util.Arrays.asList;

import java.util.List;

import com.app.controller.Controller;
import com.app.controller.CourseCSVController;
import com.app.controller.CourseCreationController;
import com.app.controller.CourseHtmlController;
import com.app.controller.CourseRawController;
import com.app.controller.MainController;

public class ControllerFactory {

	public List<Controller> create() {
		return asList(
				new MainController(), 
				new CourseRawController(), 
				new CourseHtmlController(), 
				new CourseCSVController(),
				new CourseCreationController()
				);
	}
}
