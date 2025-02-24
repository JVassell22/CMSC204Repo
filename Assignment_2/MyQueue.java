import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> {
	
	int front, back, size;
	MyLinkedList<T> list;

	MyQueue() {
		front = back = 0;
		size = 100;
		list = new MyLinkedList<T>();
	}
	MyQueue(int size) {
		this.size = size;
		list = new MyLinkedList<T>();
		front = back = 0;
	}
	@Override
	public boolean isEmpty() {
		if(front == back) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(front == 0 && back == size) {
			return true;
		}
		return false;
	}
	
	@Override
	public T dequeue() throws QueueUnderflowException {
		if(front == back) {
			throw new QueueUnderflowException();
		}
		back--;
		return(list.removeLast());
	}

	@Override
	public int size() {
		return back;
	}
	
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if(back == size) {
			throw new QueueOverflowException();
		}
		list.add(e);
		back++;
		return true;
	}

	
	@Override
	public String toString() {
		return(list.message());
	}
	@Override
	public String toString(String delimiter) {
		return(list.message(delimiter));
	}

	@Override
	public void fill (ArrayList<T> fill) {
		list.delete();
		for(int i = 0; i < fill.size(); i++) {
			list.add(fill.get(i));
			back++;
		}
	}
	
	public void empty() {
		list = new MyLinkedList<T>();
	}
}
