package com.app.controller.rule;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleFactory {

	@SuppressWarnings("serial")
	public static Map<String, List<Rule>> rulesForCourse() {
		Map<String, List<Rule>> toReturn = new HashMap<String, List<Rule>>() {
			{
				put("name",        Arrays.asList(new MandatoryRule()));
				put("number",      Arrays.asList(new MandatoryRule(), new PositiveNumberRule()));
				put("location",    Arrays.asList(new MandatoryRule()));
				put("start",       Arrays.asList(new MandatoryRule(), new DateRule()));
				put("totalSeats",  Arrays.asList(new MandatoryRule(), new PositiveNumberRule()));
				put("description", Arrays.asList());
			}
		};

		return toReturn;
	}

}
