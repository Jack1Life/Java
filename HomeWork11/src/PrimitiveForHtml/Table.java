package PrimitiveForHtml;

import java.util.ArrayList;

public class Table implements HtmlObjects {
	private ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
	private String settings;
	private String name;

	public Table(ArrayList<ArrayList<String>> table, String settings, String name) {
		super();
		this.table = table;
		this.settings = settings;
		this.name = name;
	}

	public Table(int rows, int columns, String settings, String name) {
		super();
		this.settings = settings;
		this.name = name;
		for (int i = 0; i < rows; i++) {
			table.add(new ArrayList<String>());
		}
		for (ArrayList<String> arrayList : table) {
			for (int i = 0; i < columns; i++) {
				arrayList.add("");
			}
		}
	}

	public Table() {
		super();
	}

	public ArrayList<ArrayList<String>> getTable() {
		return table;
	}

	public void setTable(ArrayList<ArrayList<String>> table) {
		this.table = table;
	}

	public String getSettings() {
		return settings;
	}

	public void setSettings(String settings) {
		this.settings = settings;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void fillCell(int row, int col, String elem) {
		ArrayList<String> line = this.table.get(row);
		line.set(col, elem);
	}

	public void addRow() {
		this.table.add(new ArrayList<String>());
	}

	public void addColumn() {
		for (ArrayList<String> arrayList : table) {
			arrayList.add("");
		}
	}

	public String toHtml() {
		String html = "";
		String tag = "th";
		if (name.length() > 0) {
			html = Html.surroundInTag("tr", "", 
					Html.surroundInTag(tag, "colspan=\"" + this.table.get(0).size() + "\"", name));
		}
		for (ArrayList<String> arrayList : table) {
			String line = "";
			for (String string : arrayList) {
				line += Html.surroundInTag(tag, "", string);
			}
			html += Html.surroundInTag("tr", "", line);
			tag = "td";
		}
		return Html.surroundInTag("table", settings, html);
	}
}
