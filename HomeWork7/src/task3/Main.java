package task3;

import java.io.File;

public class Main {

	
	public static void main(String[] args) {
		File dir = new File("/home");
		String target = "lkm";
		SearchFile search = new SearchFile(target, dir);
		String[] res = search.findFile();
		
		for (String string : res) {
			System.out.println(string);
		}
		if(res.length == 0) {
			System.out.println("No such files");
		}
	}

}