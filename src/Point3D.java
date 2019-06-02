public class Point3D extends Point {
	private double z;
	
	public Point3D() {
		super();
		z = 0;
	}
	
	public Point3D(Point3D otherPoint3D) {
		super.setX(otherPoint3D.getX());
		super.setY(otherPoint3D.getY());
		this.z = otherPoint3D.z;
	}
	
	public Point3D(double x, double y, double z) {
		super(x, y);
		this.z = z;
	}
	
	public void setX(double x) {
		super.setX(x);
	}
	
	public void setY(double y) {
		super.setY(y);
	}
	
	public void setZ(double z) {
		this.z = z;
	}
	
	public double getX() {
		return super.getX();
	}
	
	public double getY() {
		return super.getY();
	}
	
	public double getZ() {
		return z;
	}
}
