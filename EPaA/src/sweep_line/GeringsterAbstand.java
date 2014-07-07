package sweep_line;

import java.util.ArrayList;
import java.util.Collections;

public class GeringsterAbstand {

	public GeringsterAbstand() {
		
	}
	
	private void calculate(Punkt[] array) {
		double minAbstand, temp;
		ArrayList<Punkt> list = new ArrayList<Punkt>();
		
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < array.length; i++) {
			array[i] = list.get(i);
		}
		
		minAbstand = berechne(array[0].getX(), array[0].getY(), array[1].getX(), array[1].getY());
		for (int i = 1; i < array.length - 1; i++) {
			temp = berechne(array[i].getX(), array[i].getY(), array[i + 1].getX(), array[i + 1].getY());
			if(minAbstand > temp){
				minAbstand = temp;
			}else{
				while(i+1 < array.length && minAbstand <= array[i].getX() - array[i + 1].getX() ){
					++i;
					temp = berechne(array[i].getX(), array[i].getY(), array[i + 1].getX(), array[i + 1].getY());
					if(minAbstand > temp){
						minAbstand = temp;
					}
				}
			}
		}
	}

	private double berechne(double x1, double y1, double x2, double y2) {
		double rc =  Math.sqrt((x1 - y1) * (x1 - y1) + (x2 - y2) * (x2 - y2));
		return rc;
	}

}
