package com.app.view.html;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.app.model.Course;
import com.app.view.Layout;
import com.github.manliogit.javatags.element.Element;

public class CourseLayout implements Layout {
	
	private Collection<Course> courses;

	public CourseLayout(Collection<Course> courses) {
		this.courses = courses;
	}

	public Element build() {
		return div(attr("class -> col-lg-8 col-md-8 col-sm-9"),
				table(attr("class -> table table-striped"),
						thead(
								tr(
										th(
												text("Id")
												),
										th(
												text("Name")
												),
										th(
												text("Location")
												),
										th(
												text("Total seats")
												),
										th(
												text("Start date")
												)
										)
								),
						tbody(buildCourses(courses))
						)
				);
	}

	private Element[] buildCourses(Collection<Course> courses) {
		List<Element> htmlCourses = new ArrayList<>();

		for (Course course : courses) {
			htmlCourses.add(buildCourse(course));
		}

		return htmlCourses.toArray(new Element[0]);
	}

	private Element buildCourse(Course course) {
		return tr(
				td(text(course.getId())),
				td(text(course.getName())),
				td(text(course.getLocation())),
				td(text(course.getSeats())),
				td(text(course.getInitDate()))
				);
	}
	
}
