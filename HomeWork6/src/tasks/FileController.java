package tasks;

import java.io.File;

public class FileController implements Runnable {
	private File dir;

	public FileController(File dir) {
		super();
		if (!dir.exists()) {
			dir.mkdir();
		}
		this.dir = dir;
	}

	public FileController() {
		super();
	}

	public File getDir() {
		return dir;
	}

	public void setDir(File dir) {
		this.dir = dir;
	}

	private boolean findFile(File[] fList, File f) {
		String myFile = f.getName();
		String curFile;
		for (File file : fList) {
			curFile = file.getName();
			if (curFile.equals(myFile)) {
				return true;
			}
		}
		return false;
	}

	public void run() {
		File[] FileList = dir.listFiles();
		Thread t = Thread.currentThread();
		while (true) {
			if (t.isInterrupted()) {
				break;
			}
			File[] curFileList = dir.listFiles();
			for (File file : curFileList) {
				if (!findFile(FileList, file)) {
					System.out.println("Added new file: " + file.getName());
				}
			}
			for (File file : FileList) {
				if (!findFile(curFileList, file)) {
					System.out.println("Removed file: " + file.getName());
				}
			}
			FileList = curFileList;
			try {
				t.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("exit from controll");
				break;
			}
		}
	}
}
