package com.app.view;

import static com.github.manliogit.javatags.lang.HtmlHelper.attr;
import static com.github.manliogit.javatags.lang.HtmlHelper.head;
import static com.github.manliogit.javatags.lang.HtmlHelper.link;
import static com.github.manliogit.javatags.lang.HtmlHelper.meta;
import static com.github.manliogit.javatags.lang.HtmlHelper.text;
import static com.github.manliogit.javatags.lang.HtmlHelper.title;

import com.github.manliogit.javatags.element.Element;

public class HtmlLayoutHelper {

	public static Element getHead(String title) {
		return head(
		          meta(attr("charset -> utf-8")),
		          meta(attr("http-equiv -> X-UA-Compatible","content -> IE=edge")),
		          meta(attr("name -> viewport","content -> width=device-width, initial-scale=1")),
		          title(
		            title
		          ),
		          text("<!-- Bootstrap core CSS -->"),
		          link(attr("href -> https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css","rel -> stylesheet"))
		        );
	}
	
}
