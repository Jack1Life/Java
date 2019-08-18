package task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
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
			ArrayList<String> wordList = Files.lines(Paths.get(path)).collect(Collectors.toCollection(ArrayList::new));
			for (String string : wordList) {
				String[] temp = string.split("[ ]");
				vocabulary.put(temp[0], temp[1]);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
