package com.app.view.html;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import com.app.controller.course.CourseCreateController;
import com.app.view.Layout;
import com.github.manliogit.javatags.element.Element;

public class CourseCreateLayout implements Layout {
	
	private HtmlFeedback _feedback;
	
	public CourseCreateLayout(HtmlFeedback feedback) {
		_feedback = feedback;
	}
	
	public Element build() {
		return div(attr("class -> col-md-6 col-md-offset-1"),
				h2(attr("class -> text-center"),
						text("Course Creation Form")
						),
				form(attr("class -> form-horizontal","role -> form","method -> post","action -> /course/create"),
						createFormInput("Name", CourseCreateController.NAME, "text", "Course name"),
						createFormInput("Room", CourseCreateController.LOCATION, "text", "Course room"),
						createFormInput("Seats", CourseCreateController.SEATS, "text", "Total seats"),
						createFormInput("Start date", CourseCreateController.STARTDATE, "text", "Starting date"),
						createFormInput("Description", CourseCreateController.DESCRIPTION, "text", "Course description"),
						div(attr("class -> form-group"),
								div(attr("class -> col-sm-10 col-sm-offset-2"),
										input(attr("id -> submit","name -> submit","type -> submit","class -> btn btn-primary"))
										)
								)
						)
				);
	}

	private Element createFormInput(String name, String id, String type, String placeholder) {
		return div(_feedback.getAttribute(id), 
				label(attr("for -> " + id,"class -> col-sm-2 control-label"),
						text(name)
						),
				div(attr("class -> col-sm-10"),
						input(attr("type -> " + type).
								add(attr("class -> form-control")).
								add(attr("id -> " + id)).
								add(attr("name -> " + id)).
								add(attr("placeholder -> " + placeholder)).
								add(_feedback.getFieldValue(id))),
						_feedback.getErrorMessages(id)
						)
				);
	}
	
}
