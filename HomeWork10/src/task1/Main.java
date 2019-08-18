package task1;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		Vocabulary vc = new Vocabulary(new File("words.txt"));
		Translater tr = new Translater(new File("English.in"), new File("Ukrainian.out"), vc);
		tr.translate();
	}
}
