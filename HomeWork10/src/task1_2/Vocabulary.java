package task1_2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Vocabulary {
	private HashMap<String, String> vocabulary = new HashMap<String, String>();

	public Vocabulary() {
		super();
	}

	public Vocabulary(HashMap<String, String> vocabulary) {
		super();
		this.vocabulary = vocabulary;
	}

	public Vocabulary(File file) {
		super();
		fromFile(file.getAbsolutePath());
	}

	public HashMap<String, String> getVocabulary() {
		return vocabulary;
	}

	public void setVocabulary(HashMap<String, String> vocabulary) {
		this.vocabulary = vocabulary;
	}

	public void addWord(String engWord, String ukrWord) {
		this.vocabulary.put(engWord, ukrWord);
	}

	public void fromFile(String path) {

		try {
			ArrayList<String> wordList = Files.lines(Paths.get(path))
					.collect(Collectors.toCollection(ArrayList::new));
			for (String string : wordList) {
				String[] temp = string.split("[ ]");
				vocabulary.put(temp[0], temp[1]);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void toFile(String path) {
		File out = new File(path);
		Set<String> keys = vocabulary.keySet();

		if (out.isDirectory()) {
			System.out.println("Wrong! File is directory!");
			return;
		}
		try (PrintWriter pw = new PrintWriter(out)) {
			if (!out.exists()) {
				out.createNewFile();
			}
			for (String string : keys) {
				pw.println(string + " " + vocabulary.get(string));
			}
		} catch (Exception e) {
			System.out.println("Write ukr error!");
		}
	}

	public void scanWords() {
		Scanner sc = new Scanner(System.in);
		String word = "";
		String trans = "";
		while (true) {
			System.out.println("Enter a word or Q for exit:");
			word = sc.nextLine();
			if (word.equals("Q")) {
				break;
			}
			System.out.println("Enter a translate or Q for exit:");
			trans = sc.nextLine();
			if (trans.equals("Q")) {
				break;
			}
			this.vocabulary.put(word, trans);
		}
	}
}
