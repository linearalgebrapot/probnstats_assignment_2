public class Point implements Comparable<Point> {
	private double x, y;
	
	public Point() {
		x = 0;
		y = 0;
	}
	
	public Point(Point otherPoint) {
		this.x = otherPoint.x;
		this.y = otherPoint.y;
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

	@Override
	public int compareTo(Point otherPoint) {
		if (this.x < otherPoint.x) return -1;
		else if (this.x == otherPoint.x) {
			if (this.y < otherPoint.y) return -1;
			else if (this.y == otherPoint.y) return 0;
			else return 1;
		}
		else return 1;
	}
}