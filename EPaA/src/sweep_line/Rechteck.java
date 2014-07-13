package sweep_line;

public class Rechteck implements Comparable<Rechteck>{
	
	private Punkt x1, x2, x3, x4;
	
	public Rechteck(Punkt x1, Punkt x2, Punkt x3, Punkt x4){
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.x4 = x4;
	}

	public Punkt getX1() {
		return x1;
	}

	public void setX1(Punkt x1) {
		this.x1 = x1;
	}

	public Punkt getX2() {
		return x2;
	}

	public void setX2(Punkt x2) {
		this.x2 = x2;
	}

	public Punkt getX3() {
		return x3;
	}

	public void setX3(Punkt x3) {
		this.x3 = x3;
	}

	public Punkt getX4() {
		return x4;
	}

	public void setX4(Punkt x4) {
		this.x4 = x4;
	}

	public int compareTo(Rechteck o) {
		return Double.compare(this.x1.getX(), o.x1.getX());
	}

}
