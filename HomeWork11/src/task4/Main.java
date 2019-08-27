package task4;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import PrimitiveForHtml.Html;
import PrimitiveForHtml.Table;
import StudentsData.FileSystem;
import StudentsData.Group;

public class Main {

	public static Html createStartPage(String dir) {
		FileSystem fs = new FileSystem(new File(dir));
		ArrayList<Group> groups = fs.getAllGroups();
		Html startPage = new Html("Groups", "charset='utf-16'");
		Table tab = new Table(groups.size() + 1, 2, "border='2' cellpadding='5' ", "Groups list");
		startPage.addHtmlObject(tab);
		
		tab.fillCell(0, 0, "Group Code");
		tab.fillCell(0, 1, "Faculty");
		for (int i = 0; i < groups.size(); i++) {
			tab.fillCell(i + 1, 0, Html.Link("Group" + i, groups.get(i).getName()));
			tab.fillCell(i + 1, 1, groups.get(i).getFaculty());
		}
		return startPage;
	}

	public static void main(String[] args) {
		FileSystem fs = new FileSystem(new File("RTF"));
		ArrayList<Group> groups = fs.getAllGroups();
		try (ServerSocket soc = new ServerSocket(8080)) {
			while (true) {
				Socket cl = soc.accept();
				Client cli = new Client(cl, groups);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
