package BinarySearchTree;
import java.util.Random;

public class Main {
	public static String hackyClearConsole = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
	public static void main(String[] args) {
		Random rand = new Random();
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		CompareCallback<Integer> newCallBack = (a, b) -> { return a < b; };
		PrintAndShow<Integer> showPrinted = new PrintAndShow<Integer>();
		System.out.print(hackyClearConsole);
		int amount = 20;
		for(int i = 0; i < amount; i++) {
			newTree.insert(rand.nextInt(1000), newCallBack);
//			newTree.printTree((a)->{
//				return a.toString();
//			});	
			newTree.printTreeAndShow(showPrinted);
			try {
				Thread.sleep(1000);
				if(i < amount - 1) System.out.print(hackyClearConsole);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		

		
		System.out.println("\n" + newTree.find(10, (a, b) -> {
			return a.equals(b);
		}, newCallBack));
	}

}
