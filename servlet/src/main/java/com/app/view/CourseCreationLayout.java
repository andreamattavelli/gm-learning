package com.app.view;

import static com.github.manliogit.javatags.lang.HtmlHelper.a;
import static com.github.manliogit.javatags.lang.HtmlHelper.attr;
import static com.github.manliogit.javatags.lang.HtmlHelper.body;
import static com.github.manliogit.javatags.lang.HtmlHelper.div;
import static com.github.manliogit.javatags.lang.HtmlHelper.h1;
import static com.github.manliogit.javatags.lang.HtmlHelper.html5;
import static com.github.manliogit.javatags.lang.HtmlHelper.p;
import static com.github.manliogit.javatags.lang.HtmlHelper.script;
import static com.github.manliogit.javatags.lang.HtmlHelper.text;

import com.github.manliogit.javatags.element.Element;

public class CourseCreationLayout implements Layout {

	public Element build() {
		return 
			html5(
				HtmlLayoutHelper.getHead("Seminar"),
		        body(
	        		div(attr("class -> container"),
	        		   div(attr("class -> row"),
        				  div(attr("class -> col-md-6 col-md-offset-3"),
        			          h1(attr("class -> page-header text-center"),
        			            text("Course Creation")
        			          ),
        			          text("Failed to create course"),
        			          p(
				                a(attr("class -> btn btn-lg btn-success","href -> /course","role -> button"),
				                  text("Go to courses")
				                )
				              )
	                      )
        			   )
	        		),
	        		script(attr("src -> js/jquery.min.js"))
    			)
		      );
	}
	
}
