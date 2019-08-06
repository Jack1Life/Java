package task2;

public class CheckProgress implements Runnable {
	private FileCopy copyProc;

	public CheckProgress(FileCopy copyProc) {
		super();
		this.copyProc = copyProc;
	}

	public CheckProgress() {
		super();
	}

	public FileCopy getCopyProc() {
		return copyProc;
	}

	public void setCopyProc(FileCopy copyProc) {
		this.copyProc = copyProc;
	}

	public void run() {
		long allBytes = copyProc.getAllSize();
		long progress = (copyProc.getProgress() * 100) / allBytes;
		long progressPrev = 0;
		for (; progress < 100;) {
			progress = (copyProc.getProgress() * 100) / allBytes;
			if (progressPrev != progress) {
				System.out.println("Progress: " + progress);
				progressPrev = progress;
			}
		}

	}
}

