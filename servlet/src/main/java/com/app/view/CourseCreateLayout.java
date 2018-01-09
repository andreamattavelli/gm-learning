package com.app.view;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import java.util.ArrayList;
import java.util.List;

import com.app.controller.Feedback;
import com.app.controller.Feedback.Type;
import com.github.manliogit.javatags.element.Element;
import com.github.manliogit.javatags.element.attribute.Attribute;

public class CourseCreateLayout implements Layout {

	private Feedback _feedback;
	
	public CourseCreateLayout(Feedback feedback) {
		_feedback = feedback;
	}
	
	public Element build() {
		return 
			html5(
				HtmlLayoutHelper.getHead("Seminar"),
		        body(
	        		div(attr("class -> container"),
	        		   div(attr("class -> row"),
        				  div(attr("class -> col-md-6 col-md-offset-3"),
        			          h1(attr("class -> page-header text-center"),
        			            text("Course Creation Form")
        			          ),
        			          form(attr("class -> form-horizontal","role -> form","method -> post","action -> /course/create"),
			        		    createFormInput("Name", "name", "text", "Course name", "Course name"),
			        			createFormInput("Number", "number", "number", "Course number", "Course number"),
			        			createFormInput("Room", "location", "text", "Course room", "Course room"),
			        			createFormInput("Seats", "totalSeats", "number", "Total seats", "Total seats"),
			        			createFormInput("Start date", "start", "text", "Starting date", "Starting date"),
			        			createFormInput("Description", "description", "text", "Course description", "Course description"),
			        			div(attr("class -> form-group"),
			        			   div(attr("class -> col-sm-10 col-sm-offset-2"),
			        			      input(attr("id -> submit","name -> submit","type -> submit","class -> btn btn-primary"))
			        			   )
			        			)
        			         )
	                      )
        			   )
	        		),
	        		script(attr("src -> js/jquery.min.js"))
    			)
		      );
	}

	private Element createFormInput(String name, String id, String type, String placeholder, String value) {
		return div(getFeedbackAttribute(id), 
				label(attr("for -> " + id,"class -> col-sm-2 control-label"),
			      text(name)
			),
			div(attr("class -> col-sm-10"),
			    input(attr("type -> " + type).
			    		add(attr("class -> form-control")).
			    		add(attr("id -> " + id)).
			    		add(attr("name -> " + id)).
			    		add(attr("placeholder -> " + placeholder)).
			    		add(getFeedbackValue(id))),
			    getFeedbackMessages(id)
			));
	}

	private Attribute getFeedbackValue(String id) {
		if (_feedback.isOk())
			return attr();
		return attr("value -> " + _feedback.getParameterValue(id));
	}

	private Attribute getFeedbackAttribute(String id) {
		String cssClass = "class -> form-group";
		if (!_feedback.isOk()) {
			cssClass += " has-feedback";
			if (_feedback.getFeedback(id) == Type.VALID) {
				cssClass += " has-success";
			} else {
				cssClass += " has-error";
			}
		}
		return attr(cssClass);
	}

	private Element getFeedbackMessages(String id) {
		List<Element> elements = new ArrayList<Element>();
		if (!_feedback.isOk()) {
			if (_feedback.getFeedback(id) == Type.ERROR) {
				elements.add(span(attr("class -> glyphicon glyphicon-remove form-control-feedback")));
				for (String message : _feedback.getFeedbackMessages(id)) {
					elements.add(span(attr("class -> help-block"), text(message.toUpperCase())));
				}
			} else {
				elements.add(span(attr("class -> glyphicon glyphicon-ok form-control-feedback")));
			}
		}
		return group(elements.toArray(new Element[0]));
	}
	
}
