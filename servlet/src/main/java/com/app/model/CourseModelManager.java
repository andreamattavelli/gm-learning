package com.app.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CourseModelManager {

	private Connection _connection;

	public CourseModelManager(Connection _connection) {
		this._connection = _connection;
	}
	
	public void insert(Course course){
		try {
			PreparedStatement ps = _connection.prepareStatement("insert into Course (name, description, location, totalSeats, start) values (?,?,?,?,?)");
			ps.setObject(1, course.getName());
			ps.setObject(2, course.getDescription());
			ps.setObject(3, course.getLocation());
			ps.setObject(4, course.getSeats());
			ps.setObject(5, course.getInitDate());

			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Collection<Course> findAllCourses() {
		try {
			PreparedStatement preparedStatement = _connection.prepareStatement("select * from Course");
			ResultSet rs = preparedStatement.executeQuery();
			List<Course> courses = new ArrayList<Course>();
			while(rs.next()){
				courses.add(
						new Course(
								rs.getString(2),
								rs.getString(1),
								rs.getString(4),
								rs.getString(5),
								rs.getString(6),
								rs.getString(3)
								)
						);
			}
			preparedStatement.close();
			rs.close();
			return courses;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
