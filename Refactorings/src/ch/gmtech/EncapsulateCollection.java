package ch.gmtech;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EncapsulateCollection {

//	class Course {
//		public Course(String name, boolean isAdvanced) {
//		}
//
//		public boolean isAdvanced() {
//			return false;
//		}
//	}
//
//	class Person {
//		public Set getCourses() {
//			return _courses;
//		}
//
//		public void setCourses(Set arg) {
//			_courses = arg;
//		}
//
//		private Set _courses;
//	}
//	
//	public void toRefactor() {
//		Person kent = new Person();
//		Set s = new HashSet();
//		s.add(new Course("Smalltalk Programming", false));
//		s.add(new Course("Appreciating Single Malts", true));
//		kent.setCourses(s);
//		Course refact = new Course("Refactoring", true);
//		kent.getCourses().add(refact);
//		kent.getCourses().add(new Course("Brutal Sarcasm", false));
//		kent.getCourses().remove(refact);
//
//		Iterator iter = kent.getCourses().iterator();
//		int count = 0;
//		while (iter.hasNext()) {
//			Course each = (Course) iter.next();
//			if (each.isAdvanced())
//				count++;
//		}
//	}

	class Course {
		public Course(String name, boolean isAdvanced) {
		}

		public boolean isAdvanced() {
			return false;
		}
	}

	class Person {
		public Set getCourses() {
			return Collections.unmodifiableSet(_courses);
		}

		public void initializeCourses(Set arg) {
			_courses.addAll(arg);
		}
		
		public void addCourse(Course arg) {
			_courses.add(arg);
		}

		public void removeCourse(Course arg) {
			_courses.remove(arg);
		}

		int advancedCoursesSize() {
			Iterator iter = _courses.iterator();
			int count = 0;
			while (iter.hasNext()) {
				Course each = (Course) iter.next();
				if (each.isAdvanced())
					count++;
			}
			return count;
		}

		private Set _courses = new HashSet();
	}
	
	public void toRefactor() {
		Person kent = new Person();
		kent.addCourse(new Course("Smalltalk Programming", false));
		kent.addCourse(new Course("Appreciating Single Malts", true));
		Course refact = new Course("Refactoring", true);
		kent.addCourse(refact);
		kent.addCourse(new Course("Brutal Sarcasm", false));
		kent.removeCourse(refact);

		kent.advancedCoursesSize();
	}
}
