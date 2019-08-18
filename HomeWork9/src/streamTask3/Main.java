package streamTask3;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

	public static int[] task3(String str) {
		ArrayList<char[]> list = new ArrayList<char[]>();
		list.add(str.toCharArray());

		return list.stream().map(cm -> {
			int[] intArr = new int[cm.length];
			for (int i = 0; i < cm.length; i++) {
				intArr[i] = (int) cm[i];
			}
			return intArr;
		}).collect(Collectors.minBy((a, b) -> 1)).get();
	}

	public static void main(String[] args) {
		int[] myMass = task3("Aafr1234567890");
		for (int i : myMass) {
			System.out.print(i + "   ");
		}
	}

}
