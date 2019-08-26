package PrimitiveForHtml;

public class Text implements HtmlObjects {
	String text;
	String settings;

	public Text(String text, String settings) {
		super();
		this.text = text;
		this.settings = settings;
	}

	public Text() {
		super();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSettings() {
		return settings;
	}

	public void setSettings(String settings) {
		this.settings = settings;
	}

	public String toHtml() {
		return "<p" + settings + ">" + this.text + "</p>";
	}
}
