package Tasks;

public class Triangle extends Shape {
	private Point pointA;
	private Point pointB;
	private Point pointC;

	public Triangle(Point pointA, Point pointB, Point pointC) {
		super();
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
	}

	public Triangle() {
		super();
		this.pointA = new Point(0, 0);
		this.pointB = new Point(0, 1);
		this.pointC = new Point(1, 0);
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	double getPerimetr() {
		double ab = Math.sqrt((pointA.getX() - pointB.getX()) * (pointA.getX() - pointB.getX())
				+ (pointA.getY() - pointB.getY()) * (pointA.getY() - pointB.getY()));
		double cb = Math.sqrt((pointC.getX() - pointB.getX()) * (pointC.getX() - pointB.getX())
				+ (pointC.getY() - pointB.getY()) * (pointC.getY() - pointB.getY()));
		double ac = Math.sqrt((pointA.getX() - pointC.getX()) * (pointA.getX() - pointC.getX())
				+ (pointA.getY() - pointC.getY()) * (pointA.getY() - pointC.getY()));
		return (ab + cb + ac);
	}

	double getArea() {
		return Math.abs((pointB.getX() - pointA.getX()) * (pointC.getY() - pointA.getY())
				- (pointC.getX() - pointA.getX()) * (pointB.getY() - pointA.getY())) / 2;
	}

	String getInfo() {
		return "Triangle. Point A" + pointA.toString() + "Point B" + pointB.toString() + "Point C" + pointC.toString();
	}
}
