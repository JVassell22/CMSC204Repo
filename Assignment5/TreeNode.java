
public class TreeNode<T>  {
	
	T dataNode;
	TreeNode<T> left, right;
	
	public TreeNode(T dataNode) {
		this.dataNode = dataNode;
		left = right = null;
	}
	
	public TreeNode(TreeNode<T> node) {
		this.dataNode = node.getData();
		this.left = node.getLeft();
		this.right = node.getRight();
	}
	
	public T getData() {
		return dataNode;
	}
	
	public TreeNode<T> getLeft() {
		return left;
	}
	
	public TreeNode<T> getRight()
	{
		return right;
	}
}
