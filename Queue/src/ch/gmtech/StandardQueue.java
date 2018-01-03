package ch.gmtech;

public class StandardQueue<E> implements Queue<E> {

	private Object objects[] = new Object[100];
	private int front = 0;
	private int back = -1;
	
	@Override
	public void enqueue(E element) {
		back++;
		objects[back] = element;
	}

	@Override
	public E dequeue() {
		Object data = objects[front];
		front++;
		return (E) data;
	}

	@Override
	public E peek() {
		return (E) objects[front];
	}

	@Override
	public boolean isFull() {
		return back == 100;
	}

	@Override
	public boolean isEmpty() {
		return front > back;
	}

}
