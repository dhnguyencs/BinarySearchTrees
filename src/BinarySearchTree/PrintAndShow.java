package BinarySearchTree;
import java.util.HashMap;

public class PrintAndShow<TYPE> implements PrintCallback<TYPE> {
	
	PrintCallback<TYPE> customToString = null;
	
	HashMap<TYPE, Boolean> newMap = new HashMap<TYPE, Boolean>();
	@Override
	public String call(TYPE A) {
		if(!newMap.containsKey(A)) {
			newMap.put(A, true);
			return customToString == null ? A.toString() : customToString.call(A) + " <--";
		}
		return customToString == null ? A.toString() : customToString.call(A);
	}
}