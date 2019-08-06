package Tasks;

public class Main {

	public static void main(String[] args) {
		Shape[] figurs = new Shape[5];
		Board myBoard = new Board();
		figurs[0] = new Circle();
		figurs[1] = new Triangle();
		figurs[2] = new Quadrangle();
		
		myBoard.setPart1(figurs[0]);
		System.out.println(myBoard.getBoardInfo());
		myBoard.setPart2(figurs[2]);
		myBoard.deletePart1();
		System.out.println(myBoard.getBoardInfo());
	}

}
