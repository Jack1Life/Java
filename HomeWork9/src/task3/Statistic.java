package task3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.TreeSet;

public class Statistic {
	private File text;
	private ArrayList<Character> container = new ArrayList<Character>();
	private TreeSet<Character> statisticTree = new TreeSet<Character>((a, b) -> {
		if (a.getNum() == b.getNum()) {
			return -1;
		}
		return -(a.getNum() - b.getNum());
	});
	private String statistic;

	public Statistic(File text) {
		super();
		this.text = text;
		this.statistic = "";
	}

	public Statistic() {
		super();
		this.statistic = "";
	}

	public File getText() {
		return text;
	}

	public void setText(File text) {
		this.text = text;
	}

	public TreeSet<Character> getStatisticTree() {
		return statisticTree;
	}

	public String getStatistic() {
		return statistic;
	}

	private Character findSymb(char s) {
		for (Character character : container) {
			if (character.getCharacter() == s) {
				return character;
			}
		}
		return null;
	}

	private int getStatistic(byte[] buf) {
		int size = 0;
		Character symb;
		for (int i = 0; i < buf.length; i++) {
			if (((char) buf[i] > 'z') || ((char) buf[i] < 'A')) {
				continue;
			}
			size++;
			if ((symb = findSymb((char) buf[i])) == null) {
				container.add(new Character((char) buf[i], 1));
			} else {
				symb.incrementNum();
			}
		}
		return size;
	}

	public int calculateStatistic() throws IOException {
		int size = 0;
		byte[] buffer = new byte[1024 * 1024];
		double procent = 0;
		double total = 0;
		try (InputStream is = new FileInputStream(text)) {
			for (; is.read(buffer) > 0;) {
				size += getStatistic(buffer);
			}

		} catch (IOException e) {
			throw e;
		}
		for (Character character : container) {
			statisticTree.add(character);
		}

		for (Character character : statisticTree) {
			procent = (character.getNum() * 100);
			total += procent;
			statistic += (character.getCharacter() + ": " + character.getNum() + " = " + procent / size + "% ")
					+ System.lineSeparator();
		}
		statistic += "Total letter ammount: " + size + " = " + total / size + "%";
		return size;
	}
}
