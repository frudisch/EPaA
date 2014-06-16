package konvexeHuelle;

import java.util.ArrayList;
import java.util.Collections;

public class KonvexeHuelle {

	public KonvexeHuelle() {
		ArrayList<Point> points = new ArrayList<Point>();
		ArrayList<Point> huelle = new ArrayList<Point>();
		Point minimum;
		
		initArr(points);
		minimum = findMin(points);
		//System.out.println(minimum.getX() + " / " + minimum.getY());
		normalize(points, minimum);
		//print(points);
		Collections.sort(points);
		//print(points);
		huelle = calculate(points);
		print(huelle);
	}

	private ArrayList<Point> calculate(ArrayList<Point> points) {
		ArrayList<Point> rc = new ArrayList<Point>();
		
		for(int i = 0; i < points.size() - 1; i++){
			if((points.get(i).compareTo(points.get(i + 1)) < 0)){
				rc.add(points.get(i));
			}else{
				for(int j = i + 1; j < points.size() - 1; j++){
					if((points.get(i).compareTo(points.get(j + 1)) < 0)){
						rc.add(points.get(j));
						i = j;
						break;
					}
				}
			}
		}
		return rc;
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
			System.out.println("(" + points.get(i).getX() + "," + points.get(i).getY() + ")");
		}
		System.out.println("\n");
		
	}
	private void initArr(ArrayList<Point> points ) {
		points.add(new Point(3.9, 5.1));
		points.add(new Point(6, 2));
		points.add(new Point(4.4, 3.5));
		points.add(new Point(2.3, 4.5));
		points.add(new Point(4, 3));
		points.add(new Point(5.8, 3.6));
		points.add(new Point(5.4, 4));
		points.add(new Point(2, 1));
		points.add(new Point(4.8, 5.3));
	}

	public static void main(String[] args) {
		KonvexeHuelle kh = new KonvexeHuelle();
	}

}
