package com.app.view;

import static com.github.manliogit.javatags.lang.HtmlHelper.attr;
import static com.github.manliogit.javatags.lang.HtmlHelper.body;
import static com.github.manliogit.javatags.lang.HtmlHelper.div;
import static com.github.manliogit.javatags.lang.HtmlHelper.h1;
import static com.github.manliogit.javatags.lang.HtmlHelper.html5;

import com.github.manliogit.javatags.element.Element;

public class PageNotFoundLayout implements Layout {

	public Element build() {
		return 
			html5(
				HtmlLayoutHelper.getHead("Error 404 - Page not found"),
		        body(
		          div(attr("class -> container"),
		            div(attr("class -> jumbotron"),
		              h1(
		                "Error 404: Page not found!"
		              )
		            )
		          )
		        )
		      );
	}
	
}
