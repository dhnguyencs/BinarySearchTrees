package BinarySearchTree;
import java.util.HashMap;

public class PrintAndShow<TYPE> implements PrintCallback<TYPE> {
//	TYPE currentDat = null;
	HashMap<TYPE, Boolean> newMap = new HashMap<TYPE, Boolean>();
	@Override
	public String call(TYPE A) {
		if(!newMap.containsKey(A)) {
			newMap.put(A, true);
			return A.toString() + " <--";
		}
		return A.toString();
	}
}