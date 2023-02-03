package BinarySearchTree;

public class Node<TYPE> {
	Node<TYPE> 	_left 	= null;
	Node<TYPE> 	_right 	= null;
	TYPE       	_data 	= null;
	
	Node(){ }
	
	Node(TYPE DATA){
		this._data = DATA;
	}
	public void insert(Node<TYPE> newNode, CompareCallback<TYPE> callback) {
		if(_left == null && callback.call(_data, newNode._data)) {
			_left = newNode;
			return;
		}
		if(_right == null && !callback.call(_data, newNode._data)) {
			_right = newNode;
			return;
		}
		if(callback.call(_data, newNode._data)) {
			_left.insert(newNode, callback);
		}
		if(!callback.call(_data, newNode._data)) {
			_right.insert(newNode, callback);
		}
	}
	public Node<TYPE> find(TYPE searchTerm, CompareCallback<TYPE> pathCallback) {
		if(!pathCallback.call(searchTerm, _data)) return _left;
		else return _right;
	}
	public void printSelf(String spaces, String symbol, boolean hadRight, PrintCallback<TYPE> callback) {
		        System.out.print("\n" + spaces + symbol + callback.call(_data));
		        spaces += hadRight ? "│  " : "   ";
		        if(_left != null) _left.printSelf(spaces, _right != null ? "├──" : "└──", _right != null, callback);
		        if(_right != null) _right.printSelf(spaces, "└──", false, callback);
		}
}
