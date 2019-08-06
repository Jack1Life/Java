package Tasks;

public class Vector3d {
	private double x;
	private double y;
	private double z;

	public Vector3d(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3d() {
		super();
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public void addVector(Vector3d vect) {
		x += vect.getX();
		y += vect.getY();
		z += vect.getZ();
	}

	public double scalarMult(Vector3d vect) {
		return (x * vect.getX() + y * vect.getY() + z * vect.getZ());
	}

	public Vector3d vectorMult(Vector3d vect) {
		return new Vector3d((y * vect.getZ() - z * vect.getY()), (z * vect.getX() - x * vect.getZ()),
				(x * vect.getY() - y * vect.getX()));
	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + ", " + z + "]";
	}
}