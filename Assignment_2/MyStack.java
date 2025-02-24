import java.util.ArrayList;

public class MyStack <T> implements StackInterface<T>{
	
	int top,size;
	MyLinkedList<T> mList = new MyLinkedList<T>();
	
	
	MyStack() {
		top = 0;
		size = 100;
		mList = new MyLinkedList<T>();
	}

	MyStack(int size) {
		top = 0;
		this.size = size;
		mList = new MyLinkedList<T>();
	}

	@Override
	public boolean isEmpty() {
		if(top == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(top == this.size) {
			return true;
		}
		return false;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(top == 0) {
			throw new StackUnderflowException();
		}
		top--;
		return(mList.removeFirst());
	}

	@Override
	public T top() throws StackUnderflowException {
		if(top == 0) {
			throw new StackUnderflowException();
		}
		return(mList.getHead());
	}

	@Override
	public int size() {
		return top;
	}

	@Override
	public boolean push(T e) throws StackOverflowException {
		if(top == size) {
			throw new StackOverflowException();
		}
		top++;
		mList.add(e);
		return true;
	}

	@Override
	public String toString() {
		return(mList.message());
	}
	@Override
	public String toString(String delimiter) {
		return(mList.message(delimiter));
	}

	@Override
	public void fill(ArrayList<T> list) {
		mList.delete();
		for(int i = 0; i < list.size(); i++) {
			mList.add(list.get(i));
			top++;
		}
	}
	public void empty() {
		mList = new MyLinkedList<T>();
	}

}
