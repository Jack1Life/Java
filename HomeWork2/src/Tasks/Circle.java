package Tasks;

public class Circle extends Shape {
	private Point centrPoint;
	private Point circlePoint;

	public Circle(Point centrPoint, Point circlePoint) {
		super();
		this.centrPoint = centrPoint;
		this.circlePoint = circlePoint;
	}

	public Circle() {
		super();
		this.centrPoint = new Point(0, 0);
		this.circlePoint = new Point(1, 0);;
	}

	public Point getCentrPoint() {
		return centrPoint;
	}

	public void setCentrPoint(Point centrPoint) {
		this.centrPoint = centrPoint;
	}

	public Point getCirclePoint() {
		return circlePoint;
	}

	public void setCirclePoint(Point circlePoint) {
		this.circlePoint = circlePoint;
	}

	double getRadius() {
		return Math.sqrt((centrPoint.getX() - circlePoint.getX()) * (centrPoint.getX() - circlePoint.getX())
				+ (centrPoint.getY() - circlePoint.getY()) * (centrPoint.getY() - circlePoint.getY()));
	}
	
	double getPerimetr() {
		return (2 * Math.PI * getRadius());
	}

	double getArea() {
		double rQad = (centrPoint.getX() - circlePoint.getX()) * (centrPoint.getX() - circlePoint.getX())
				+ (centrPoint.getY() - circlePoint.getY()) * (centrPoint.getY() - circlePoint.getY());
		return (Math.PI * rQad);
	}

	String getInfo() {
		return "Circle. Centr" + centrPoint.toString() + " Radius = " + getRadius();
	}
}