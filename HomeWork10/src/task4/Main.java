package task4;

import java.util.HashMap;

public class Main {
	
	public static void task4(String text) {
		HashMap<Character, String[]> codes = Arts.getLetters();
		for(int i = 0; i < Arts.getHigh(); i++) {
			for (char c : text.toCharArray()) {
				if(codes.containsKey(c)) {
					System.out.print(codes.get(c)[i]);
				}
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		task4("AHAHA");
	}

}
