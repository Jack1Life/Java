package tasks;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Main {

	private static void task1() {
		for (int i = 0; i < 100; i++) {
			Thread curThread = new Thread(new Factorial(i));
			curThread.start();
		}
	}

	private static void task2() {
		int sum = 0;
		int[] mass = new int[10000000];
		for (int i = 0; i < mass.length; i++) {
			mass[i] = 1;
		}

		Date time1 = new Date();
		sum = new Summator(mass).getSumm();
		Date time2 = new Date();
		System.out.println(sum);
		System.out.println(time2.getTime() - time1.getTime());

	}

	private static void task3() {
		int[] mass = new int[1000];
		for (int i = 0; i < mass.length; i++) {
			mass[i] = mass.length - i;
			System.out.print(mass[i] + ", ");
		}
		System.out.println();
		ShellSort shell = new ShellSort(mass);
		shell.shellSort();
		for (int i : mass) {
			System.out.print(i + ", ");
		}

	}

	private static void task4() {
		File dirIn = new File("task4 in");
		File dirOut = new File("task4 out");
		try {
			FileManager.copyDir(dirIn, dirOut);
		} catch (IllegalArgumentException e) {
			System.out.println("Wrong directories");
		} catch (IOException e) {
			System.out.println("Data error");
		}
	}
	private static void task5() {
		Scanner sc = new Scanner(System.in);
		String str = "";
		FileController dirContr = new FileController(new File("task4 in"));
		Thread control = new Thread(dirContr);
		control.start();
		while(true) {
			str = sc.nextLine();
			if(str.equals("exit")) {
				control.interrupt();
				return;
			}
		}
	}
	public static void main(String[] args) {
		task3();
	}

}