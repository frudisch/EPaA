package sweep_line;

import java.util.ArrayList;
import java.util.Collections;

public class GeringsterAbstand {
	
	public static void main(String[] args) {
		new GeringsterAbstand();
	}

	public GeringsterAbstand() {
		Punkt[] arr = init();
		
		System.out.println(calculate(arr));
		System.out.println(calcaluteKacke(arr));
	}
	
	
	private Punkt[] init() {
		ArrayList<Punkt> list = new ArrayList<Punkt>();
		
		for (int i = 0; i < 1000; i++) {
			double x = Math.random()*10000000;
			double y = Math.random()*10000000;
			list.add(new Punkt(x, y));
		}
		return list.toArray(new Punkt[list.size()]);
	}

	private double calcaluteKacke(Punkt[] array) {
		double minAbstand = Double.MAX_VALUE, temp;
		int j;
		int counter = 0;
		ArrayList<Punkt> list = new ArrayList<Punkt>();
		
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < array.length; i++) {
			array[i] = list.get(i);
		}
		
		for (int i = 0; i < array.length; i++) {
			for (int k = i + 1; k < array.length; k++) {
				temp = berechne(array[i].getX(), array[i].getY(), array[k].getX(), array[k].getY());
				if(minAbstand > temp) minAbstand = temp;
				counter++;
			}
		}
		System.out.println(counter + " / " + array.length);
		return minAbstand;
	}

	private double calculate(Punkt[] array) {
		double minAbstand, temp;
		int j;
		int counter = 0;
		ArrayList<Punkt> list = new ArrayList<Punkt>();
		
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < array.length; i++) {
			array[i] = list.get(i);
		}
		
		minAbstand = berechne(array[0].getX(), array[0].getY(), array[1].getX(), array[1].getY());
		for (int i = 0; i < array.length - 1; i++) {
			j = i + 1;
			while(j < array.length && minAbstand >= array[j].getX() - array[i].getX() ){
				temp = berechne(array[i].getX(), array[i].getY(), array[j].getX(), array[j].getY());
				if(minAbstand > temp){
					minAbstand = temp;
				}
				j++;
				++counter;
			}
		}
		
		System.out.println(counter + " / " + array.length);
		return minAbstand;
	}

	private double berechne(double x1, double y1, double x2, double y2) {
		double rc =  Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
		return rc;
	}

}
