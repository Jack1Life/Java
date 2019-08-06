package Tasks;

public final class Point {
	final double x;
	final double y;

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public Point setX(double x) {
		return new Point(x, this.y);
	}

	public double getY() {
		return y;
	}

	public Point setY(double y) {
		return new Point(this.x, y);
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ") ";
	}

}
