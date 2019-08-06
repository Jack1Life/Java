package tasks;

public class Adder implements Runnable {

	private int[] array;
	private int start;
	private int step;
	private Summator sum;

	public Adder(int[] array, int start, int step, Summator sum) {
		super();
		this.array = array;
		this.start = start;
		this.step = step;
		this.sum = sum;
	}

	public Adder() {
		super();
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}


	public void run() {
		int summ = 0;
		for (int j = start; j < array.length; j += step) {
			summ += array[j];
		}
		sum.setRes(summ);
	}
}
