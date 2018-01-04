package ch.gmtech;

import java.util.Arrays;
import java.util.List;

public class SubstituteAlgorithm {
	
//	String foundPerson(String[] people) {
//		for (int i = 0; i < people.length; i++) {
//			if (people[i].equals("Don")) {
//				return "Don";
//			}
//			if (people[i].equals("John")) {
//				return "John";
//			}
//			if (people[i].equals("Kent")) {
//				return "Kent";
//			}
//		}
//		return "";
//	}
	
	String foundPerson(String[] people) {
		List<String> candidates = Arrays.asList("Don", "John","Kent");
		for (String person : people) {
			if (candidates.contains(person)) {
				return person;
			}
		}
		return "";
	}
	
}
