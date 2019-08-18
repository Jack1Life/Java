package task4;

import java.util.ArrayDeque;

public class Main {

	public static String task4(int colaNum) {
		String queueString = "Double Cola Bar";
		Friends firstInQueue;
		ArrayDeque<Friends> doubleColaQueue = new ArrayDeque<Friends>();
		doubleColaQueue.addLast(Friends.SHELDON);
		doubleColaQueue.addLast(Friends.LEONARD);
		doubleColaQueue.addLast(Friends.VOLOVITC);
		doubleColaQueue.addLast(Friends.KUTARAPALLI);
		doubleColaQueue.addLast(Friends.PENNY);

		for (int i = 0; i < colaNum; i++) {
			firstInQueue = doubleColaQueue.pollFirst();
			doubleColaQueue.addLast(firstInQueue);
			doubleColaQueue.addLast(firstInQueue);
		}
		for (; doubleColaQueue.size() != 0;) {
			queueString += System.lineSeparator() + "^" + System.lineSeparator()
					+ doubleColaQueue.pollFirst().getFriend();
		}

		return queueString;
	}

	public static void main(String[] args) {
		System.out.println(task4(6));
	}

}
