
 class Node<T> {
	
	 T data;
	 Node<T> next = null;
	
	Node(T data) {
		this.data = data;
	}
	Node(T data, Node<T> nextNode) {
		this.data = data;
		next = nextNode;
	}
	public T getData() {
		return data;
	}
}
