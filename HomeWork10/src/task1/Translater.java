package task1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Translater {
	private File eng;
	private File ukr;
	private Vocabulary vocabulary;

	public Translater(File eng, File ukr, Vocabulary vocabulary) {
		super();
		this.eng = eng;
		this.ukr = ukr;
		this.vocabulary = vocabulary;
	}

	public Translater() {
		super();
	}

	public File getEng() {
		return eng;
	}

	public void setEng(File eng) {
		this.eng = eng;
	}

	public File getUkr() {
		return ukr;
	}

	public void setUkr(File ukr) {
		this.ukr = ukr;
	}

	public Vocabulary getVocabulary() {
		return vocabulary;
	}

	public void setVocabulary(Vocabulary vocabulary) {
		this.vocabulary = vocabulary;
	}

	private void writeTranslate(ArrayList<String> words) {
		HashMap<String, String> voc = vocabulary.getVocabulary();
		try (PrintWriter pw = new PrintWriter(ukr)) {
			for (String str : words) {
				if (voc.containsKey(str)) {
					pw.print(voc.get(str) + " ");
				}
				pw.println();
			}
		} catch (Exception e) {
			System.out.println("Write ukr error!");
		}
	}

	public void translate() {
		if (!eng.exists() || eng.isDirectory() || ukr.isDirectory()) {
			System.out.println("Wrong files");
			return;
		}
		try {
			if (!ukr.exists()) {
				ukr.createNewFile();
			}
			ArrayList<String> wordEng = Files.lines(Paths.get(eng.getAbsolutePath()))
					.map(n -> n.toLowerCase())
					.collect(Collectors.toCollection(ArrayList::new));
			writeTranslate(wordEng);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
