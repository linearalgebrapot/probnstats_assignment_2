
public class Point {
	public double value, x, y;
	
	public Point() {
		value=0;
		x=0;
		y=0;
	}
	
	public Point(Point p) {
		this.value = p.value;
		this.x = p.x;
		this.y = p.y;
	}
}
