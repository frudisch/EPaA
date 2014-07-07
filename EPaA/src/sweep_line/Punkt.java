package sweep_line;

public class Punkt implements Comparable<Punkt> {
	private double x;
	private double y;

	public Punkt(double x, double y) {
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

	public int compareTo(Punkt o) {
		return Double.compare(this.x, o.getX());
	}
}
