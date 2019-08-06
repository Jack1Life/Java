package tasks;

import java.io.File;
import java.io.IOException;

public class Main {

	
	
	public static void main(String[] args) {
		File d1 = new File("task1");
		File d2 = new File("task2");
		d1.mkdir();
		FileManager.directorysCopy(d1, d2, "calc");
		File f1 = new File("text1.txt");
		File f2 = new File("text2.txt");
		File f3 = new File("text3.txt");
		try {
			FileManager.copyOverlap (f1, f2, f3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("copy complete");
	}

}