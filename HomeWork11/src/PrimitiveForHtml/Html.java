package PrimitiveForHtml;

import java.util.ArrayList;

public class Html {
	private String title;
	private String meta;
	private ArrayList<HtmlObjects> content;

	public static String getPageInfo(String servName, int contLen) {
		String res = ("HTTP/1.1 200 OK\r\n" + "Server: " + servName + "\r\n" + "Content-Type: text/html\r\n"
				+ "Content-Length: " + contLen + "\r\n" + "Connection: close\r\n\r\n");
		return res;
	}

	public static String newLine() {
		return "<br>";
	}

	public static String Link(String link, String body) {
		return "<a href=\"" + link + "\">" + body + "<a>";
	}

	public static String surroundInTag(String tag, String parameters, String body) {
		String res = "<" + tag;
		if (parameters.length() > 0) {
			res += " " + parameters;
		}
		res += ">" + body + "</" + tag + ">";
		return res;
	}

	public Html(String title, String meta) {
		super();
		this.title = title;
		this.meta = meta;
		this.content = new ArrayList<HtmlObjects>();
	}

	public Html() {
		super();
		this.content = new ArrayList<HtmlObjects>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMeta() {
		return meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public ArrayList<HtmlObjects> getContent() {
		return content;
	}

	public void setContent(ArrayList<HtmlObjects> content) {
		this.content = content;
	}

	public void addHtmlObject(HtmlObjects ob) {
		content.add(ob);
	}
	
	public String getPage() {
		String page = "<html><head> <title>" + title + "</title>  <meta " + meta + "></head><body>";
		
		for (HtmlObjects object : content) {
			page += object.toHtml();
		}
		page += "</body></html>";
		return Html.getPageInfo("UniverServ", page.length()) + page;
	}
}
