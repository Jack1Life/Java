package tasks;

public class ShellSort {
	private int[] array;
	private volatile int steps;
	private int stepAmm;
	private boolean stepNext;
	
	public ShellSort(int[] array) {
		super();
		this.array = array;
	}

	public ShellSort() {
		super();
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public synchronized boolean decrementStep() {
		steps--;
		return true;
	}
	
	public void shellSort() {
		for (int i = array.length / 2; i > 0; i /= 2) {
			steps = 0;
			for(int j = 0; j < i; j++) {
				steps++;
				Thread t = new Thread(new InsertsSort(array, i, j, this));
				t.start();
			}
			while(steps > 0);
		}
	}
}