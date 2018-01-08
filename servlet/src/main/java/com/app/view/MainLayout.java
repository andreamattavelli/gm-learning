package com.app.view;

import com.github.manliogit.javatags.element.Element;
import static com.github.manliogit.javatags.lang.HtmlHelper.*;

public class MainLayout implements Layout {

	public Element build() {
		return 
			html5(
				HtmlLayoutHelper.getHead("Seminar"),
		        body(
		          div(attr("class -> container"),
		            div(attr("class -> jumbotron"),
		              h1(
		                "Hello World!"
		              ),
		              p(attr("class -> lead"),
		                text("Hello world!")
		              ),
		              p(
		                a(attr("class -> btn btn-lg btn-success","href -> #","role -> button"),
		                  text("Sign up today")
		                )
		              )
		            )
		          )
		        )
		      );
	}

}
