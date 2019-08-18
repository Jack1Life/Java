package streamTask4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Main {

	public static int task4(String way) {
		try {
			return Files.lines(Paths.get(way)).map(ln -> {
				Integer i = 0;
				int sign = 1;
				char[] numb = ln.toCharArray();
				for (char c : numb) {
					if ((c >= '0') && (c <= '9')) {
						i = (i * 10) + (int) (c - '0');
					} else if (c == '-') {
						sign *= -1;
					}
				}
				return i * sign;
			}).collect(Collectors.maxBy((a, b) -> (a - b))).get().intValue();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public static void main(String[] args) {
		System.out.println(task4("stream.txt"));
	}

}
