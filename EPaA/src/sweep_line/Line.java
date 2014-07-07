package sweep_line;

public class Line implements Comparable<Line>{
	
	private Punkt start;
	private Punkt ende;
	
	public Line(Punkt start, Punkt ende) {
		this.setStart(start);
		this.setEnde(ende);
	}

	public Punkt getStart() {
		return start;
	}

	public void setStart(Punkt start) {
		this.start = start;
	}

	public Punkt getEnde() {
		return ende;
	}

	public void setEnde(Punkt ende) {
		this.ende = ende;
	}

	public int compareTo(Line o) {
		return Double.compare(this.getStart().getX(), o.getStart().getX());
	}

}
