package task1;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	
	public static void main(String[] args) {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			myList.add(i + 320);
		}
		myList.remove(0);
		myList.remove(0);
		myList.remove(myList.size() - 1);
		Iterator<Integer> listIter = myList.iterator();
		for(; listIter.hasNext();) {
			System.out.println(listIter.next());
		}
	}

}
