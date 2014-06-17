package konvexeHuelle;

import java.util.ArrayList;
import java.util.Collections;

public class KonvexeHuelle {

	public KonvexeHuelle() {
		ArrayList<Point> points = new ArrayList<Point>();
		
		initArr(points);
		
		//grahamScanAlg(points);
		jarvisMarchAlg(points);
	}
	
	
	private ArrayList<Point> calculateJarvis(ArrayList<Point> points, Point minimum) {
		ArrayList<Point> huelle = new ArrayList<Point>();
		ArrayList<Point> temp = new ArrayList<Point>();
		boolean found = false;
		
		huelle.add(minimum);
		for (int i = 0; i < points.size(); i++) {
			temp = normalize(points, huelle.get(huelle.size() - 1));
			found = false;
			for (int j = 0; j < temp.size(); j++) {					
				for (int z = 0; z < temp.size(); z++) {
					if(temp.get(j).compareTo(temp.get(z)) < 0){
						found = true;
						break;
					}
				}
				if(!found){
					huelle.add(points.get(j));
					points.remove(j);
					break;
				}
				found = false;
			}
			
			if(huelle.get(huelle.size() - 1).equals(minimum)) break;
		}
		
		return huelle;
	}

	private ArrayList<Point> calculateGraham(ArrayList<Point> points) {
		ArrayList<Point> rc = new ArrayList<Point>();
		int before;
		
		for(int i = 0; i < points.size() - 1; i++){
			if((points.get(i).compareTo(points.get(i + 1)) < 0)){
				rc.add(points.get(i));
			}else{
				before = rc.size();
				for(int j = i; j < points.size() - 1; j++){
					rc.add(points.get(j));
					if((points.get(j).compareTo(points.get(j + 1)) < 0)){
						for (int z = before; z < rc.size() - 1;) {
							rc.remove(z);
						}
						i = j;
						break;
					}					
				}
			}
		}
		return rc;
	}

	private ArrayList<Point> normalize(ArrayList<Point> points, Point minimum) {
		ArrayList<Point> rc = new ArrayList<Point>();
		
		for (int i = 0; i < points.size(); i++) {
			rc.add(new Point(points.get(i).getX() - minimum.getX(), points.get(i).getY() - minimum.getY()));
		}
		
		return rc;
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

	private void jarvisMarchAlg(ArrayList<Point> points) {
		ArrayList<Point> huelle = new ArrayList<Point>();
		Point minimum;
		
		print(points);
		minimum = findMin(points);
		huelle = calculateJarvis(points, minimum);
		print(huelle);
	}

	private void grahamScanAlg(ArrayList<Point> points) {
		ArrayList<Point> huelle = new ArrayList<Point>();
		Point minimum;
		
		minimum = findMin(points);
		//System.out.println(minimum.getX() + " / " + minimum.getY());
		points = normalize(points, minimum);
		//print(points);
		Collections.sort(points);
		print(points);
		huelle = calculateGraham(points);
		print(huelle);
	}

	private void initArr(ArrayList<Point> points ) {
//		points.add(new Point(3.9, 5.1));
//		points.add(new Point(6, 2));
//		points.add(new Point(4.4, 3.5));
//		points.add(new Point(2.3, 4.5));
//		points.add(new Point(4, 3));
//		points.add(new Point(5.8, 3.6));
//		points.add(new Point(5.4, 4));
//		points.add(new Point(2, 1));
//		points.add(new Point(4.8, 5.3));
		for (int i = 0; i < 21; i++) {
			double x = 10 * Math.random();
			double y = 10 * Math.random();
			points.add(new Point(x, y));
		}
	}

	public static void main(String[] args) {
		KonvexeHuelle kh = new KonvexeHuelle();
	}

}
