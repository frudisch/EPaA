package sweep_line;

public class GeringsterAbstand {

	public GeringsterAbstand() {
		
	}
	
	private void calculate(Punkt[] array) {
		double minAbstand;
		
		minAbstand = berechne(array[0].getX(), array[0].getY(), array[1].getX(), array[1].getY());
		for (int i = 1; i < array.length; i++) {
			
		}
	}

	private double berechne(double x1, double y1, double x2, double y2) {
		double rc =  Math.sqrt((x1 - y1) * (x1 - y1) + (x2 - y2) * (x2 - y2));
		return rc;
	}

}
