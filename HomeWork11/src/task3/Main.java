package task3;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Main {

	public static String getUrlFromStream(InputStream steram) {
		String url = "";
		try {
			steram.read();
			if (((char) steram.read()) != 'h') {
				return url;
			}
			for (int i = 0; i < 5; i++) {
				steram.read();
			}
			for (int c; (c = steram.read()) != -1;) {
				if ((char) c == '"' || (char) c == '#' || (char) c == '\'') {
					break;
				}
				url += (char) c;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return url;
	}

	public static ArrayList<String> task3(URL url) {
		ArrayList<String> res = new ArrayList<String>();
		try {
			URLConnection urlc = url.openConnection();
			InputStream ins = urlc.getInputStream();
			String link;
			char prev = ' ';
			for (int c = ' '; (c = ins.read()) != -1;) {
				if ((prev == '<') && ((char) c == 'a')) {
					link = getUrlFromStream(ins);
					if (link.length() != 0) {
						res.add(link);
					}
					prev = '"';
				} else {
					prev = (char) c;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static void main(String[] args) {
		try {
			URL site = new URL("https://www.ibm.com/developerworks/ru/library/l-linux_kernel_29/");
			ArrayList<String> links = task3(site);
			for (String string : links) {
				System.out.println(string);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}

}
