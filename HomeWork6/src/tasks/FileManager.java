package tasks;

import java.io.File;
import java.io.IOException;

public class FileManager {

	public static void copyDir(File in, File out) throws IOException, IllegalArgumentException {
		if (!out.exists()) {
			out.mkdir();
		}

		if (!in.isDirectory() || !out.isDirectory() || !in.exists()) {
			throw new IllegalArgumentException();
		}

		File[] fileList = in.listFiles();
		for (File file : fileList) {
			File fileCopy = new File((out.getName() + "/" + file.getName()));
			Thread th = new Thread(new FileCopy(file, fileCopy));
			th.start();
		}
	}

}