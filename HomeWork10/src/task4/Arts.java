package task4;

import java.util.HashMap;

public class Arts {
	private static String[][] letters = 
		{
		{
			"    *    ",
			"   * *   ",
			"  *****  ",
			" *     * ",
			"*       *"
		},
			
		{
			" *     * ",
			" *     * ",
			" ******* ",
			" *     * ",
			" *     * "
		}
		};
	private static int High = 5;
	
	public static HashMap<Character, String[]> getLetters(){
		HashMap<Character, String[]> codes = new HashMap<Character, String[]>();
		codes.put('A', letters[0]);
		codes.put('H', letters[1]);
		return codes;
	}

	public static int getHigh() {
		return High;
	}
}
