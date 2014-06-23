package konvexeHuelle;

public class Point implements Comparable<Point>{

	private double x;
	private double y;

	public Point(double x, double y) {
		this.setX(x);
		this.setY(y);
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

	public int compareTo(Point arg0) {
		if ((arg0.getY() * x - arg0.getX() * y) < 0) return -1;
		else if((arg0.getY() * x - arg0.getX() * y) == 0) return 0;
		else return 1;
	}

}
