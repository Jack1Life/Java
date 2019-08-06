package task2;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		File fileIn = new File("task2/vid.mp4");
		File fileOut = new File("task2/vol02.mp4");
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