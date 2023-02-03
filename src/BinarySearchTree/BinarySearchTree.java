package BinarySearchTree;

public class BinarySearchTree<TYPE> {
	Node<TYPE> _root = null;
	
	public BinarySearchTree() { }
	public BinarySearchTree(TYPE DATA) {
		_root = new Node<TYPE>(DATA);
	}
	public void insert(TYPE DATA, CompareCallback<TYPE> callback) {
		Node<TYPE> newNode = new Node<TYPE>(DATA);
		if(_root == null) {
			_root = newNode;
			return;
		}
		_root.insert(newNode, callback);
	}
	public void printTree(PrintCallback<TYPE> callback) {
		if (_root == null) return;
		System.out.print(callback.call(_root._data));
		if(_root._left != null) _root._left.printSelf("", (_root._right != null) ? "├──" : "└──", _root._right != null, callback);
		if(_root._right != null) _root._right.printSelf("", "└──", false, callback);
	}
	public void printTree(PrintAndShow<TYPE> callback) {
		if (_root == null) return;
		System.out.print(callback.call(_root._data));
		if(_root._left != null) _root._left.printSelf("", (_root._right != null) ? "├──" : "└──", _root._right != null, callback);
		if(_root._right != null) _root._right.printSelf("", "└──", false, callback);
	}
	public void printTree(PrintAndShow<TYPE> callback, PrintCallback<TYPE> customPrintCallBack) {
		callback.customToString = customPrintCallBack;
		printTree(callback);
	}
	public Boolean find(TYPE searchTerm, CompareCallback<TYPE> callback, CompareCallback<TYPE> pathCompareCallback) {
		if(_root == null) return false;
		
		Node<TYPE> node = _root;
		System.out.println("\n");
		do {
			if(callback.call(searchTerm, node._data)) return true;
			System.out.println(node._data);
			node = node.find(searchTerm, pathCompareCallback);
		}while(node != null);
		
		return false;
	}
	
}
