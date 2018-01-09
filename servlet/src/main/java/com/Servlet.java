package com;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.model.Course;
import com.app.view.PageNotFoundLayout;

public class Servlet extends HttpServlet {

	private Set<Course> _courses;
	
	@Override
	public void init() throws ServletException {
		_courses = new HashSet<>();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		for(Controller c : new ControllerFactory().create()){
			if(c.handles(req.getRequestURI())){
				try {
					c.execute(new Context(req, resp, _courses));
					return;
				} catch (Exception e) {
					resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					throw new RuntimeException(e);
				}
			}
		}
		resp.getWriter().write(new PageNotFoundLayout().build().render());
		resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}
	
}
