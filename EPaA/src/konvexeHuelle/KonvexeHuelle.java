package konvexeHuelle;

import java.util.ArrayList;
import java.util.Collections;

public class KonvexeHuelle {

	public KonvexeHuelle() {
		ArrayList<Point> points = new ArrayList<Point>();
		Point minimum;
		
		initArr(points);
		minimum = findMin(points);
		normalize(points, minimum);
		print(points);
		Collections.sort(points);
		print(points);
		calculate(points);
		print(points);
	}

	private void calculate(ArrayList<Point> points) {
		int temp;
		
		for(int i = 0; i < points.size(); i++){
			for (int j = i; j < points.size(); j++) {
				
			}
		}
	}

	private void normalize(ArrayList<Point> points, Point minimum) {
		for (int i = 0; i < points.size(); i++) {
			points.get(i).setX(points.get(i).getX() - minimum.getX());
			points.get(i).setY(points.get(i).getY() - minimum.getY());
		}
	}

	private Point findMin(ArrayList<Point> points ) {
		Point temp;
		temp = points.get(0);
		for (int i = 1; i < points.size(); i++) {
			if(temp.getY() > points.get(i).getY()){
				temp = points.get(i);
			}
		}
		return temp;
	}
	
	private void print(ArrayList<Point> points) {
		for (int i = 0; i < points.size(); i++) {
			System.out.println(i + ". Punkt: " + points.get(i).getX() + " / " + points.get(i).getY());
		}
		
	}
	private void initArr(ArrayList<Point> points ) {
		
	}

	public static void main(String[] args) {
		KonvexeHuelle kh = new KonvexeHuelle();
	}

}
