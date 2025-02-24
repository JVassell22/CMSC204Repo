
public class MyLinkedList<T> {
	
	Node<T> head,tail;
	int size = 0;
	
	MyLinkedList() {
		head = null;
	}
	
	public boolean add(T s) {
		if(head == null) {
			head = new Node<T>(s);
		}
		else {
			Node<T> nextNode = new Node<T>(s);
			nextNode.next = head;
			head = nextNode;
		}
		size++;
		return true;
	}
	
	
	public T removeFirst() {
		if(head != null) {
			T temp = head.data;
			head = head.next;
			size--;
			return temp;
		}
		size--;
		return null;
		
	}
	
	public T removeLast() {
		T temp = null;
		if(head == null) {
			return null;
		}
		else if(head.next == null) {
			temp = head.data;
			head = null;
			return temp;
		}
		else if(head.next.next == null) {
			temp = head.next.data;
			head.next = null;
			return temp;
		}
		else {
			Node<T> n = head;
			while(n.next.next != null) {
				n = n.next;
				temp = n.next.data;
			}
			n.next = null;
		}
		size--;
		return temp;
	}
	
	public T get(int x) {
		Node<T> temp = head;
		for(int i = 0; i < x; i++) {
			temp = temp.next;
		}
		return temp.data;
	}
	
	public T getHead() {
		return head.data;
	}
	
	public void delete() {
		head = null;
	}
	
	public String message() {
		StringBuilder build = new StringBuilder();
		if(head == null) {
			return null;
		}
		else if(head.next == null) {
			build.append(head.getData());
		}
		else {
			Node<T> temp = head;
			while(temp != null) {
				build.append(temp.getData());
				temp = temp.next;
			}
			build = build.reverse();
		}
		return build.toString();
	}
	
	public String message(String delimiter) {
		StringBuilder build = new StringBuilder();
		if(head == null) {
			return null;
		}
		else if(head.next == null) {
			build.append(head.getData()+delimiter);
		}
		else {
			Node<T> temp = head;
			while(temp != null) {
				if(temp.next == null) 
					build.append(temp.getData());
				else
					build.append(temp.getData()+delimiter);
				temp = temp.next;
			}
			build = build.reverse();
		}
		return build.toString();
	}



}
