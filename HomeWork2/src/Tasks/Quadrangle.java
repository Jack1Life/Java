package Tasks;

public class Quadrangle extends Shape {
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private Point pointD;

	public Quadrangle(Point pointA, Point pointB, Point pointC, Point pointD) {
		super();
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
		this.pointD = pointD;
	}

	public Quadrangle() {
		super();
		this.pointA = new Point(-1, 1);
		this.pointB = new Point(1, 1);
		this.pointC = new Point(1, -1);
		this.pointD = new Point(-1, -1);
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

	public Point getPointD() {
		return pointD;
	}

	public void setPointD(Point pointD) {
		this.pointD = pointD;
	}

	double getLength(Point point1, Point point2) {
		return Math.sqrt((point1.getX() - point2.getX()) * (point1.getX() - point2.getX())
				+ (point1.getY() - point2.getY()) * (point1.getY() - point2.getY()));
	}

	double getPerimetr() {
		double ab = getLength(pointA, pointB);
		double cb = getLength(pointC, pointB);
		double dc = getLength(pointD, pointC);
		double ad = getLength(pointA, pointD);
		return (ab + cb + dc + ad);
	}

	double getArea() {
		double ab = getLength(pointA, pointB);
		double cb = getLength(pointC, pointB);
		double dc = getLength(pointD, pointC);
		double ad = getLength(pointA, pointD);
		double semiP = (ab + cb + dc + ad) / 2;
		return Math.sqrt(((semiP - ab) * (semiP - cb) * (semiP - dc) * (semiP - ad)));
	}

	String getInfo() {
		return "Quadrangle. Point A" + pointA.toString() + "Point B" + pointB.toString() + "Point C" + pointC.toString()
				+ "Point D" + pointD.toString();
	}
}
