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
		double temp = (arg0.getY() * x - arg0.getX() * y);
		System.out.println(temp);
		temp = Math.signum(temp);
		
		return Double.compare(temp, 0.0);
	}

}
