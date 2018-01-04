package ch.gmtech;

import java.util.Vector;

public class ReplaceInheritanceWithDelegation {

//	class MyStack extends Vector {
//		public void push(Object element) {
//			insertElementAt(element, 0);
//		}
//
//		public Object pop() {
//			Object result = firstElement();
//			removeElementAt(0);
//			return result;
//		}
//	}

	class MyStack {
		private Vector _vector = new Vector();
		
		public void push(Object element) {
			_vector.insertElementAt(element, 0);
		}

		public Object pop() {
			Object result = _vector.firstElement();
			_vector.removeElementAt(0);
			return result;
		}
	}
	
}
