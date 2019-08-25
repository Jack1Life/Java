package task1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

	public static boolean urlIsAvailable(URL url) {
		URLConnection urlc;
		try {
			urlc = url.openConnection();
			if (urlc.getContentType() == null) {
				return false;
			} else {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}

	public static ArrayList<String> task1(File fl) {
		try {
			return Files.lines(Paths.get(fl.getAbsolutePath())).map(ln -> {
				String res = "" + ln + " ";
				try {
					URL url = new URL(ln);
					if (urlIsAvailable(url)) {
						res += "is available!";
					} else {
						res += "is NOT available!";
					}
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				return res;
			}).collect(Collectors.toCollection(ArrayList::new));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		ArrayList<String> urls = task1(new File("links.txt"));
		for (String string : urls) {
			System.out.println(string);
		}
	}

}
