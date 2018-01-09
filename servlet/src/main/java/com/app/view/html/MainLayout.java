package com.app.view.html;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import com.app.view.Layout;
import com.github.manliogit.javatags.element.Element;

public class MainLayout implements Layout {

	private String _title;
	private Layout _bodyContent;
	
	public MainLayout(String title, Layout bodyContent) {
		_title = title;
		_bodyContent = bodyContent;
	}

	public Element build() {
		return 
				html5(attr("lang -> en"),
						  head(
						    meta(attr("http-equiv -> content-type","content -> text/html; charset=UTF-8")),
						    meta(attr("charset -> utf-8")),
						    title(_title),
						    meta(attr("name -> viewport","content -> width=device-width, initial-scale=1")),
						    meta(attr("http-equiv -> X-UA-Compatible","content -> IE=edge")),
						    link(attr("rel -> stylesheet","href -> /css/bootstrap.min.css?v=1.0.0","media -> screen")),
						    link(attr("rel -> stylesheet","href -> /css/custom.css?v=1.0.0")),
						    link(attr("rel -> stylesheet","href -> /css/app.css?v=1.0.0")),
						    text("<!--[if lt IE 9]><script src='https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js'></script><![endif]-->")
						  ),
						  body(
						    div(attr("class -> navbar navbar-default navbar-fixed-top"),
						    	      div(attr("class -> container"),
						    	        div(attr("class -> navbar-header"),
						    	          a(attr("href -> /","class -> navbar-brand"),
						    	            text("Seminar")
						    	          )
						    	        )
						    	      )
						    	    ),
						    div(attr("class -> container"),
						    	      div(attr("class -> page-header","id -> banner"),
						    	        div(attr("class -> row"),
						    	          div(attr("class -> col-lg-8 col-md-7 col-sm-6"),
						    	            h1(
						    	              text("Seminar")
						    	            ),
						    	            p(attr("class -> lead"),
						    	              text("Manage your courses!")
						    	            )
						    	          )
						    	        ),
						    	        div(attr("class -> row"),
						    	          div(attr("class -> col-lg-2 col-md-2 col-sm-3"),
						    	            div(attr("class -> list-group table-of-contents"),
						    	              a(attr("class -> list-group-item","href -> /course"),
						    	                text("List")
						    	              ),
						    	              a(attr("class -> list-group-item","href -> /course/create"),
						    	                text("Create")
						    	              )
						    	            )
						    	          ),
						    	          _bodyContent.build()
						    	        )
						    	      )
						    	    ),
						    	    script(attr("src -> /js/jquery.min.js?v=1.0.0")),
						    	    script(attr("src -> /js/bootstrap.min.js?v=1.0.0")),
						    	    script(attr("src -> /js/custom.js?v=1.0.0"))
						    	  )
						    	);
	}

}
