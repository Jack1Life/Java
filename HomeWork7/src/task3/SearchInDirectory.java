package task3;

import java.io.File;
import java.util.Arrays;

public class SearchInDirectory implements Runnable {
	private File way;
	private String target;
	private String result;

	public SearchInDirectory(File way, String target) {
		super();
		this.way = way;
		this.target = target;
	}

	public SearchInDirectory() {
		super();
	}

	public File getWay() {
		return way;
	}

	public void setWay(File way) {
		this.way = way;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getResult() {
		return result;
	}

	public void run() {
		Thread[] threadDirs = new Thread[1];
		SearchInDirectory[] searchs = new SearchInDirectory[1];
		int counter = 0;
		if (!way.isDirectory()) {
			if(way.getName().equals(target)) {
				result = way.getAbsolutePath();
			}
			return;
		}
		File[] list = way.listFiles();
		for (File file : list) {
			if (file.isDirectory()) {
				searchs[counter] = new SearchInDirectory(file, target);
				threadDirs[counter] = new Thread(searchs[counter]);
				threadDirs[counter].start();
				counter++;
				threadDirs = Arrays.copyOf(threadDirs, counter + 1);
				searchs = Arrays.copyOf(searchs, counter + 1);
			} else if(file.getName().equals(target)) {
				result = way.getAbsolutePath();
				return;
			}
		}
		for(int i = 0; i < (threadDirs.length - 1); i++) {
			try {
				threadDirs[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(searchs[i].getResult() != null) {
				result = searchs[i].getResult();
				return;
			}
		}
	}
}
