package task3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Main {

	public static TreeSet<Map.Entry<Object, Integer>> task3(Object[] mass) {
		HashMap<Object, Integer> map = new HashMap<Object, Integer>();
		TreeSet<Map.Entry<Object, Integer>> sorted = new TreeSet<Map.Entry<Object, Integer>>((a, b) -> {
			if (a.getValue() == b.getValue()) {
				return 1;
			}
			return b.getValue() - a.getValue();
		});

		for (Object object : mass) {
			if (map.containsKey(object)) {
				map.put(object, map.get(object) + 1);
			} else {
				map.put(object, 1);
			}
		}
		for (Map.Entry<Object, Integer> elem : map.entrySet()) {
			sorted.add(elem);
		}
		return sorted;
	}

	public static void main(String[] args) {
		Integer[] array = { 1, 1, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 2, 99, 99, 99, 111, 11, -44, -44 };

		for (Map.Entry<Object, Integer> entry : task3(array)) {
			System.out.println((Integer) entry.getKey() + " -> " + entry.getValue());
		}

	}

}
