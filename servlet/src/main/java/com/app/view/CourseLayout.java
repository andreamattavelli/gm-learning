package com.app.view;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.app.model.Course;
import com.app.model.Student;
import com.github.manliogit.javatags.element.Element;

public class CourseLayout implements Layout {
	
	private Collection<Course> courses;
	
	public CourseLayout(Collection<Course> courses) {
		this.courses = courses;
	}

	public Element build() {
		return html5(
					HtmlLayoutHelper.getHead("Course list"),
			        body(
			        	div(attr("class -> container"),
		        		    buildCourses(courses)
		        		   )
			        	),
		            script(attr("src -> js/jquery.min.js"))
			      );
	}

	private Element[] buildCourses(Collection<Course> courses) {
		List<Element> htmlCourses = new ArrayList<>();
		
		htmlCourses.add(buildPageTitle());
		
		for (Course course : courses) {
			htmlCourses.add(buildCourse(course));
		}
		
		return htmlCourses.toArray(new Element[0]);
	}

	private Element buildPageTitle() {
		return div(attr("class -> col-md-6 col-md-offset-3"),
	        		h1(attr("class -> page-header text-center"),
	        		   text("Course List")
	        		)
	              );
	}

	private Element buildCourse(Course course) {
		return div(attr("class -> row"),
				  div(attr("class -> col-md-6 col-md-offset-3"),
					b(text(course.getName())),
					ul(
						li(text(course.getDescription())),
						li(text(course.getLocation()))
						),
					text("Students:"),
					buildStudentList(course.getStudents())
                  )
 			   );
	}

	private Element buildStudentList(Collection<Student> students) {
		List<Element> htmlStudents = new ArrayList<>();
		
		for (Student student : students) {
			htmlStudents.add(li(student.toString()));
		}
		
		return ul(htmlStudents.toArray(new Element[0]));
	}
	
}
