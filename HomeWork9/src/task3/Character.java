package task3;

public class Character {
	private char character;
	private int num;

	public Character(char character, int num) {
		super();
		this.character = character;
		this.num = num;
	}

	public Character() {
		super();
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public void incrementNum()
	{
		this.num++;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += this.character;
		str += ": ";
		str += this.num;
		return str;
	}
}
