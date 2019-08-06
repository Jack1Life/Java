package task1;

public class Ship {
	private String name;
	private int boxesNum;

	public Ship(String name, int boxesNum) {
		super();
		this.name = name;
		this.boxesNum = boxesNum;
	}

	public Ship() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBoxesNum() {
		return boxesNum;
	}

	public void setBoxesNum(int boxesNum) {
		this.boxesNum = boxesNum;
	}

}