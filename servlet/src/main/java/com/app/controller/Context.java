package com.app.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.model.Course;

public class Context {

	private final HttpServletRequest _request;
	private final HttpServletResponse _response;
	private final Collection<Course> _courses;

	public Context(HttpServletRequest request, HttpServletResponse response, Collection<Course> courses) {
		_request = request;
		_response = response;
		_courses = courses;
	}

	public HttpServletRequest request() {
		return _request;
	}

	public HttpServletResponse response() {
		return _response;
	}

	public Collection<Course> courses() {
		return _courses;
	}
	
	public String getParameter(String id) {
		return _request.getParameter(id);
	}
	
	public boolean isPost() {
		return _request.getMethod().equals("POST");
	}
}
