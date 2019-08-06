package Tasks;


public class Board {
	private Shape part1;
	private Shape part2;
	private Shape part3;
	private Shape part4;

	public Board(Shape part1, Shape part2, Shape part3, Shape part4) {
		super();
		this.part1 = part1;
		this.part2 = part2;
		this.part3 = part3;
		this.part4 = part4;
	}

	public Board() {
		super();
		part1 = new Nothing();
		part2 = new Nothing();
		part3 = new Nothing();
		part4 = new Nothing();
	}

	public Shape getPart1() {
		return part1;
	}

	public void setPart1(Shape part1) {
		this.part1 = part1;
	}

	public Shape getPart2() {
		return part2;
	}

	public void setPart2(Shape part2) {
		this.part2 = part2;
	}

	public Shape getPart3() {
		return part3;
	}

	public void setPart3(Shape part3) {
		this.part3 = part3;
	}

	public Shape getPart4() {
		return part4;
	}

	public void setPart4(Shape part4) {
		this.part4 = part4;
	}

	public void deletePart1() {
		part1 = new Nothing();
	}

	public void deletePart2() {
		part2 = new Nothing();
	}

	public void deletePart3() {
		part3 = new Nothing();
	}

	public void deletePart4() {
		part4 = new Nothing();
	}

	public String getBoardInfo() {
		return "Part1: " + part1.getInfo() + "\nPart2: " + part2.getInfo() + "\nPart3: " + part3.getInfo() + "\nPart4: "
				+ part4.getInfo() + "\nTotal area: "
				+ (part1.getArea() + part2.getArea() + part3.getArea() + part4.getArea());
	}

}
