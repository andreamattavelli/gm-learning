package com.app.view.html;

import static com.github.manliogit.javatags.lang.HtmlHelper.h1;

import com.app.view.Layout;
import com.github.manliogit.javatags.element.Element;

public class PageNotFoundLayout implements Layout {

	public Element build() {
		return h1("Error 404: Page not found!");
	}
	
}
