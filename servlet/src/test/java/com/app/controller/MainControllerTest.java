package com.app.controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainControllerTest {

	@Test
	public void handlesMainRoute() throws Exception {
		assertTrue(new MainController().handles("/"));
	}
	
	@Test
	public void handlesCourseHtmlRoute() throws Exception {
		assertTrue(new CourseHtmlController().handles("/course/html"));
	}
	
	@Test
	public void handlesCourseRawRoute() throws Exception {
		assertTrue(new CourseRawController().handles("/course/raw"));
	}
	
	@Test
	public void handlesCourseCsvRoute() throws Exception {
		assertTrue(new CourseCSVController().handles("/course/csv"));
	}
	
}
