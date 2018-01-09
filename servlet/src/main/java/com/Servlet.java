package com;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.view.html.MainLayout;
import com.app.view.html.PageNotFoundLayout;

public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private DataSource _ds;
	
	@Override
	public void init() throws ServletException {
		try {
			_ds = (DataSource)new InitialContext().lookup("java:comp/env/jdbc/ds");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		for(Controller c : new ControllerFactory().create()){
			if(c.handles(req.getRequestURI())){
				ConnectionManager connection = new ConnectionManager(_ds);
				try {
					connection.setAutoCommit(false);
					c.execute(new Context(req, resp, connection.get()));
					connection.commit();
					return;
				} catch (Exception e) {
					resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					connection.rollback();
					throw new RuntimeException(e);
				} finally {
					connection.close();
				}
			}
		}
		resp.getWriter().write(new MainLayout("404 - Page not found", new PageNotFoundLayout()).build().render());
		resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}
	
}
