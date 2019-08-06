package tasks;

import java.math.BigInteger;

public class Factorial implements Runnable {

	private int number;

	public Factorial(int number) {
		super();
		this.number = number;
	}

	public Factorial() {
		super();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public BigInteger factorial(int n) {
		BigInteger fact = new BigInteger("1");
		for (int i = 1; i <= n; i++) {
			fact = fact.multiply(new BigInteger("" + i));
		}
		return fact;
	}

	public void run() {
		System.out.println(number + "! = " + factorial(number));
	}
}
