package tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class FileManager {

	private static boolean check(String name, String filterWord) {
		if (filterWord.lastIndexOf(".") >= 0) {
			int indx = name.lastIndexOf(filterWord.substring(0, 1));
			if (indx < 0) {
				return false;
			}
			String str = name.substring(indx);
			return str.equals(filterWord);
		} else {
			return (name.lastIndexOf(filterWord) >= 0);
		}

	}

	private static File[] fileFilter(File directory, String filterWord) {
		File[] fullList = directory.listFiles();
		int n = 0;
		for (File file : fullList) {
			if (check(file.getName(), filterWord)) {
				n++;
			}
		}
		File[] returnList = new File[n];
		n = 0;
		for (File file : fullList) {
			if (check(file.getName(), filterWord)) {
				returnList[n] = file;
				n++;
			}
		}
		return returnList;
	}

	private static void copy(InputStream is, OutputStream os) throws IOException {
		byte[] buffer = new byte[1024 * 1024];
		int readByte = 0;
		for (; (readByte = is.read(buffer)) > 0;) {
			os.write(buffer, 0, readByte);
		}
	}

	private static void copyFile(File in, File out) throws IOException {
		try (InputStream is = new FileInputStream(in); OutputStream os = new FileOutputStream(out)) {
			copy(is, os);
		} catch (IOException e) {
			throw e;
		}
	}

	public static void directorysCopy(File dirIn, File dirOut, String keyWord) throws IllegalArgumentException {

		if (!dirOut.exists()) {
			dirOut.mkdir();
		}
		if (!dirIn.exists() || !dirIn.isDirectory() || !dirOut.isDirectory()) {
			throw new IllegalArgumentException();
		}

		File[] copyFiles = fileFilter(dirIn, keyWord);
		for (File file : copyFiles) {
			try {
				copyFile(file, new File(dirOut.getAbsolutePath() + "\\" + file.getName()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static boolean isSeparator(char symb) {
		return (symb == ' ') || (symb == ',')
				|| (symb == '.' || (symb == '?') || (symb == '!') || (symb == ':') || (symb == ';'));
	}

	private static String[] getWords(File fl) throws IOException {
		String[] words = new String[0];
		StringBuilder oneWord = new StringBuilder(0);
		char[] buf = new char[1024 * 1024];
		int charAmm = 0;
		try (FileReader stream = new FileReader(fl);) {
			while ((charAmm = stream.read(buf)) > 0) {
				for (int i = 0; i < charAmm; i++) {
					if (isSeparator(buf[i]) && (oneWord.length() > 0)) {
						words = Arrays.copyOf(words, words.length + 1);
						words[words.length - 1] = oneWord.toString();
						oneWord.setLength(0);
					} else if (buf[i] != ' ') {
						oneWord.setLength(oneWord.length() + 1);
						oneWord.setCharAt(oneWord.length() - 1, buf[i]);
					}
				}

			}
		} catch (IOException e) {
			throw e;
		}
		return words;
	}

	private static boolean findWord(String[] words, String curWord) {
		for (String string : words) {
			if (string.equals(curWord)) {
				return true;
			}
		}
		return false;
	}

	public static void copyOverlap(File file1, File file2, File fileOut) throws IOException {
		String[] words1 = getWords(file1);
		StringBuilder currentWord = new StringBuilder(0);
		char[] buf = new char[1024 * 1024];
		int lastChar = 0;
		try (FileReader stream2 = new FileReader(file2); FileWriter stream3 = new FileWriter(fileOut);) {
			while ((lastChar = stream2.read(buf)) > 0) {
				for (int i = 0; i < lastChar; i++) {
					if (isSeparator(buf[i]) && (currentWord.length() > 0)) {
						if (findWord(words1, currentWord.toString())) {
							stream3.write((currentWord.toString() + " "));
						}
						currentWord.setLength(0);
					} else if (buf[i] != ' ') {
						currentWord.setLength(currentWord.length() + 1);
						currentWord.setCharAt(currentWord.length() - 1, buf[i]);
					}
				}
			}
		} catch (IOException e) {
			throw e;
		}
	}
}
