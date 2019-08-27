package task4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import PrimitiveForHtml.Html;
import PrimitiveForHtml.Table;
import StudentsData.Group;

public class Client implements Runnable {
	private Socket client;
	private Thread myThread;
	private ArrayList<Group> groups;
	private String baseAnswer;
	private Html startPage;

	public Client(Socket client, ArrayList<Group> groups) {
		super();
		this.client = client;
		this.groups = groups;
		this.myThread = new Thread(this);
		createStartPage();
		myThread.start();
	}

	private void createStartPage() {
		startPage = new Html("Univer", "charset='utf-16'");
		Table tab = new Table(groups.size() + 1, 3, "border='2' cellpadding='5' ", "Groups list");
		startPage.addHtmlObject(tab);
		tab.fillCell(0, 0, "Group Code");
		tab.fillCell(0, 1, "Faculty");
		tab.fillCell(0, 2, "Number of members");
		for (int i = 0; i < groups.size(); i++) {
			tab.fillCell(i + 1, 0, Html.Link("Group" + i, groups.get(i).getName()));
			tab.fillCell(i + 1, 1, groups.get(i).getFaculty());
			tab.fillCell(i + 1, 2, "" + groups.get(i).getStudents().size());
		}
		baseAnswer = startPage.getPage();
	}

	private void showStartPage() {
		baseAnswer = startPage.getPage();
	}

	private void showGroup(Group gr) {
		Html page = new Html(gr.getName(), "charset='utf-16'");
		Table tab = gr.studentsToTable();
		page.addHtmlObject(tab);
		baseAnswer = page.getPage();
	}

	private String findLine(String text, String start, String end) {
		int indx = text.indexOf(start);
		if (indx < 0) {
			return null;
		}
		String res = text.substring(indx + start.length());
		if ((indx = res.indexOf(end)) >= 0) {
			return res.substring(0, indx);
		}
		return res;
	}

	private int getNumber(String text, int begin) {
		int res = 0;
		for (char c = text.charAt(begin); (c >= '0') && (c <= '9'); c = text.charAt((begin += 1))) {
			res = (res * 10) + (int) c - 0x30;
		}
		return res;
	}

	private void requestParser(String req, OutputStream stream) {
		int indx;
		String refer = findLine(req, "GET /", " HTTP");
		System.out.println(refer);
		System.out.println(req);
		if (refer == null) {
			return;
		}
		try {
			if (refer.length() == 0) {
				showStartPage();
				stream.write(baseAnswer.getBytes());
				stream.flush();
			} else if ((indx = refer.indexOf("Group")) >= 0) {
				indx += "Group".length() - 1;
				showGroup(groups.get(getNumber(refer, indx)));
				stream.write(baseAnswer.getBytes());
				stream.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try (InputStream is = client.getInputStream(); OutputStream os = client.getOutputStream()) {
			while (!client.isClosed()) {
				if (is.available() > 0) {
					byte[] reqest = new byte[is.available() + 1];
					is.read(reqest);
					requestParser(new String(reqest), os);
				}
			}
			System.out.println("Conection closed.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
