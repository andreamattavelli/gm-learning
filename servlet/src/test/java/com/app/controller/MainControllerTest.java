package com.app.controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainControllerTest {

	@Test
	public void handlesMainRoute() throws Exception {
		assertTrue(new MainController().handles("/"));
	}
	
}
