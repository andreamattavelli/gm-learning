package com.app.view.html.course;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import com.app.controller.course.CourseCreateController;
import com.app.view.Layout;
import com.app.view.html.HtmlFeedback;
import com.github.manliogit.javatags.element.Element;

public class CourseUpdateLayout implements Layout {
	
	private HtmlFeedback _feedback;
	
	public CourseUpdateLayout(HtmlFeedback feedback) {
		_feedback = feedback;
	}
	
	public Element build() {
		return div(attr("class -> col-md-6 col-md-offset-1"),
				h2(attr("class -> text-center"),
						text("Course Update Form")
						),
				form(attr("class -> form-horizontal","role -> form","method -> post","action -> /course/update"),
						createFormElement("id", CourseCreateController.ID, "hidden", "id", true),
						createFormElement("Name", CourseCreateController.NAME, "text", "Course name"),
						createFormElement("Room", CourseCreateController.LOCATION, "text", "Course room"),
						createFormElement("Seats", CourseCreateController.SEATS, "text", "Total seats"),
						createFormElement("Start date", CourseCreateController.STARTDATE, "text", "Starting date"),
						createFormElement("Description", CourseCreateController.DESCRIPTION, "text", "Course description"),
						div(attr("class -> form-group"),
								div(attr("class -> col-sm-10 col-sm-offset-2"),
										input(attr("id -> submit","name -> submit","type -> submit","class -> btn btn-primary"))
										)
								)
						)
				);
	}

	private Element createFormElement(String name, String id, String type, String placeholder) {
		return createFormElement(name, id, type, placeholder, false);
	}
	
	private Element createFormElement(String name, String id, String type, String placeholder, boolean hidden) {
		return div(_feedback.getAttribute(id), 
					label(attr("for -> " + id,"class -> col-sm-2 control-label"),
						hidden ? voidEl(""): text(name)
					),
					createFormInput(id, type, placeholder, hidden)
				);
	}

	private Element createFormInput(String id, String type, String placeholder, boolean hidden) {
		return div(attr("class -> col-sm-10"),
				input(attr("type -> " + type).
						add(attr("class -> form-control")).
						add(attr("id -> " + id)).
						add(attr("name -> " + id)).
						add(attr("placeholder -> " + placeholder)).
						add(_feedback.getFieldValue(id))),
				hidden ? voidEl("") : _feedback.getErrorMessages(id)
				);
	}
	
}
