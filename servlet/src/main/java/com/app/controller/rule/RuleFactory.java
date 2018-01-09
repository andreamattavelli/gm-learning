package com.app.controller.rule;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.controller.course.CourseCreateController;

public class RuleFactory {

	@SuppressWarnings("serial")
	public static Map<String, List<Rule>> rulesForCourse() {
		Map<String, List<Rule>> toReturn = new HashMap<String, List<Rule>>() {
			{
				put(CourseCreateController.NAME,        Arrays.asList(new MandatoryRule(), new CharLengthRule(15, NumberComparator.LESS_THAN)));
				put(CourseCreateController.LOCATION,    Arrays.asList(new MandatoryRule(), new CharLengthRule(20, NumberComparator.LESS_THAN)));
				put(CourseCreateController.SEATS,       Arrays.asList(new MandatoryRule(), new CharLengthRule(3, NumberComparator.LESS_THAN), new NumberRule(100, NumberComparator.LESS_THAN)));
				put(CourseCreateController.STARTDATE,   Arrays.asList(new MandatoryRule(), new DateRule()));
				put(CourseCreateController.DESCRIPTION, Arrays.asList());
			}
		};

		return toReturn;
	}

}
