package task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy implements Runnable {
	private File in;
	private File out;
	private long allSize;
	private long currentSize;

	public FileCopy(File in, File out) {
		super();
		this.in = in;
		this.out = out;
	}

	public FileCopy() {
		super();
	}

	public File getIn() {
		return in;
	}

	public void setIn(File in) {
		this.in = in;
	}

	public File getOut() {
		return out;
	}

	public void setOut(File out) {
		this.out = out;
	}

	public synchronized long getProgress() {
		return currentSize;
	}

	public synchronized long getAllSize() {
		return allSize;
	}
	private void copy(InputStream is, OutputStream os) throws IOException {
		byte[] buffer = new byte[1024 * 1024];
		int readByte = 0;
		for (; (readByte = is.read(buffer)) > 0;) {
			os.write(buffer, 0, readByte);
			currentSize += readByte;
		}
	}

	private void copyFile(File in, File out) throws IOException {
		try (InputStream is = new FileInputStream(in); OutputStream os = new FileOutputStream(out)) {
			copy(is, os);
		} catch (IOException e) {
			throw e;
		}
	}

	public void run() {
		allSize = this.in.length();
		currentSize = 0;
		Thread t = new Thread(new CheckProgress(this));
		t.start();
		try {
			copyFile(in, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("File " + in.getName() + " is copied");
	}

}
