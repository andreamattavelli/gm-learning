package com.app.view.html;

import static com.github.manliogit.javatags.lang.HtmlHelper.attr;
import static com.github.manliogit.javatags.lang.HtmlHelper.head;
import static com.github.manliogit.javatags.lang.HtmlHelper.link;
import static com.github.manliogit.javatags.lang.HtmlHelper.meta;
import static com.github.manliogit.javatags.lang.HtmlHelper.text;
import static com.github.manliogit.javatags.lang.HtmlHelper.title;

import com.github.manliogit.javatags.element.Element;

public class HtmlLayoutHelper {
	
	private static final String ASSET_VERSION = "?v=1.0.0";

	public static Element getHead(String title) {
		return head(
			    meta(attr("http-equiv -> content-type","content -> text/html; charset=UTF-8")),
			    meta(attr("charset -> utf-8")),
			    title(title),
			    meta(attr("name -> viewport","content -> width=device-width, initial-scale=1")),
			    meta(attr("http-equiv -> X-UA-Compatible","content -> IE=edge")),
			    link(attr("rel -> stylesheet","href -> /css/bootstrap.min.css" + ASSET_VERSION,"media -> screen")),
			    link(attr("rel -> stylesheet","href -> /css/custom.css" + ASSET_VERSION)),
			    link(attr("rel -> stylesheet","href -> /css/app.css" + ASSET_VERSION)),
			    text("<!--[if lt IE 9]>"),
			    text("<script src='https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js'></script>"),
			    text("<script src='https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js'></script>"),
			    text("<![endif]-->")
			  );
	}
	
}
