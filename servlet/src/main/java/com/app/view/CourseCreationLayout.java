package com.app.view;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import com.github.manliogit.javatags.element.Element;

public class CourseCreationLayout {

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
        			          form(attr("class -> form-horizontal","role -> form","method -> post","action -> index.php"),
			        		    createFormInput("Name", "name", "text", "Course name", "Course name"),
			        			createFormInput("Number", "number", "text", "Course number", "Course number"),
			        			createFormInput("Description", "description", "text", "Course description", "Course description"),
			        			createFormInput("Init date", "initDate", "text", "Initial date", "Initial date"),
			        			div(attr("class -> form-group"),
			        			   div(attr("class -> col-sm-10 col-sm-offset-2"),
			        			      input(attr("id -> submit","name -> submit","type -> submit","value -> Send","class -> btn btn-primary"))
			        			   )
			        			)
        			         )
	                      )
        			   )
	        		),
	        		script(attr("src -> js/jquery.min.js")),
	        	    script(attr("src -> js/bootstrap.min.js"))
    			)
		      );
	}

	private Element createFormInput(String name, String id, String type, String placeholder, String value) {
		return div(attr("class -> form-group"),
		      label(attr("for -> " + id,"class -> col-sm-2 control-label"),
		        text(name)
		      ),
		      div(attr("class -> col-sm-10"),
		        input(attr("type -> " + type,"class -> form-control","id -> " + id,"name -> " + id,"placeholder -> " + placeholder,"value -> " + value))
		      )
		    );
	}
	
}
