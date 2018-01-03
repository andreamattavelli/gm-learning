package ch.gmtech;

public class MonitorableQueue<E> implements Queue<E> {

	private int max_size = 0;
	private int size = 0;
	private StandardQueue<E> queue;
	
	@Override
	public void enqueue(E element) {
		if (++size > max_size)
			max_size = size;
		queue.enqueue(element);
	}

	@Override
	public E dequeue() {
		--size;
		return queue.dequeue();
	}

	@Override
	public E peek() {
		return queue.peek();
	}

	@Override
	public boolean isFull() {
		return queue.isFull();
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

}
