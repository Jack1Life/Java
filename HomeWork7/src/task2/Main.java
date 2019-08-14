package task2;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		File fileIn = new File("task2/tikt.pdf");
		File fileOut = new File("task2/tiket2.pdf");
		FileCopy fl = new FileCopy(fileIn, fileOut);
		
		Thread copy = new Thread(fl);
		copy.start();
		try {
			copy.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}