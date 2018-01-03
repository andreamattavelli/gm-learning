package ch.gmtech;

public interface Queue<E> {

	void enqueue(E element);
	E dequeue();
	E peek();
	boolean isFull();
	boolean isEmpty();
}
