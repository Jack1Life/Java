package tasks;

public class InsertsSort implements Runnable {

	private int[] array;
	private int step;
	private int start;
	private ShellSort shell;

	public InsertsSort(int[] array, int step, int start, ShellSort shell) {
		super();
		this.array = array;
		this.step = step;
		this.start = start;
		this.shell = shell;
	}

	public InsertsSort() {
		super();
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	private boolean compare(int indx1, int indx2) {
		if (this.array[indx1] > this.array[indx2]) {
			return true;
		} else {
			return false;
		}

	}

	private void swap(int indx1, int indx2) {
		int temp = this.array[indx1];
		this.array[indx1] = this.array[indx2];
		this.array[indx2] = temp;
	}

	public void run() {
		int curIndx = 0;
		boolean res = false;
		for (int i = start + step; i < array.length; i += step) {
			curIndx = i;
			for (int j = curIndx - step; j >= start; j -= step) {
				if (!compare(curIndx, j)) {
					swap(curIndx, j);
					curIndx -= step;
				} else {
					break;
				}
			}
		}
		while (!shell.decrementStep());
	}
}