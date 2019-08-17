package task3;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Statistic st = new Statistic(new File("text.txt"));
		try {
			st.calculateStatistic();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(st.getStatistic());
	}

}
