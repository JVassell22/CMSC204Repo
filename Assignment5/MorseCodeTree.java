import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	
	private TreeNode<String> root = new TreeNode<>("");
	private ArrayList<String> treeArr = new ArrayList<>();
	
	public MorseCodeTree() {
		buildTree();
	}

	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
		
	}

	@Override
	public void insert(String code, String result) {
		addNode(this.root, code, result);
		
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if(code.charAt(0) == ('.')) {
			if(root.getLeft() == null) {
				root.left = new TreeNode<String>(letter);
			}
			else {
				addNode(root.getLeft(),code.substring(1),letter);

			}
		}
		if(code.charAt(0) == ('-')) {
			if(root.getRight() == null) {
				root.right = new TreeNode<String>(letter);
			}
			else {
				addNode(root.getRight(),code.substring(1),letter);
			}
		}
	}

	@Override
	public String fetch(String code) {
		return(fetchNode(root,code));
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if(root == null) {
			return null;
		}
		if(code.length() == 0) {
			return root.getData();
		}
		if(code.charAt(0) == ('.')) {
			return fetchNode(root.getLeft(),code.substring(1));
		}
		else {
			return fetchNode(root.getRight(),code.substring(1));
		}
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void buildTree() {
		insert(".","e");
		insert("-","t");
		insert("..","i");
		insert(".-","a");
		insert("-.","n");
		insert("--","m");
		insert("...","s");
		insert("..-","u");
		insert(".-.","r");
		insert(".--","w");
		insert("-..","d");
		insert("-.-","k");
		insert("--.","g");
		insert("---","o");
		insert("....","h");
		insert("...-","v");
		insert("..-.","f");
		insert(".-..","l");
		insert(".--.","p");
		insert(".---","j");
		insert("-...","b");
		insert("-..-","x");
		insert("-.-.","c");
		insert("-.--","y");
		insert("--..","z");
		insert("--.-","q");
	}

	@Override
	public ArrayList<String> toArrayList() {
		LNRoutputTraversal(root, treeArr);
		return treeArr;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root!=null) {
			LNRoutputTraversal(root.getLeft(),list);
			list.add(root.getData());
			LNRoutputTraversal(root.getRight(),list);
		}
	}
	

}
