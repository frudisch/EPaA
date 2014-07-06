package konvexeHuelle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class KonvexeHuelle {

	public KonvexeHuelle() {
		ArrayList<Point> points1 = new ArrayList<Point>();
		ArrayList<Point> points2 = new ArrayList<Point>();
		ArrayList<Point> points3 = new ArrayList<Point>();
		long start = 0, end = 0;
		
		initArr(points1, points2, points3);
		
//		start = System.currentTimeMillis();
//		jarvisMarchAlg(points1);
//		end = System.currentTimeMillis();
//		System.out.println("Jarvis: "  + ((end - start) / 1000.0));
//		
		start = System.currentTimeMillis();
		grahamScanAlg(points2);
		end = System.currentTimeMillis();
		
		System.out.println("Graham: "  + ((end - start) / 1000.0));
		
//		hullAlg(points3);
	}
	
	private ArrayList<Point> calculateJarvis(ArrayList<Point> points, int minimum) {
		ArrayList<Point> huelle = new ArrayList<Point>();
		ArrayList<Point> temp = new ArrayList<Point>();
		int pos;
		
		huelle.add(points.get(minimum));
		do {
			temp = normalize(points, huelle.get(huelle.size() - 1));
			pos = 0;
			if(!checkCondition(temp.get(0), new Point(0.0, 0.0))) pos = 1;
			for (int j = 1; j < temp.size(); j++) {	
				if(temp.get(pos).compareTo(temp.get(j)) < 0){
					pos = j;
				}
			}
			
			huelle.add(points.get(pos));
			points.remove(pos);
			
		} while(checkCondition(huelle.get(huelle.size() - 1), huelle.get(0)));
		
		return huelle;
	}

	private boolean checkCondition(Point point, Point minimum) {
		
//		System.out.println("X: " + point.getX() + " und " + minimum.getX());
//		System.out.println("Y: " + point.getY() + " und " + minimum.getY());
//		System.out.println("Diff x: "+Math.abs(point.getX() - minimum.getX()));
//		System.out.println("Diff y: "+Math.abs(point.getY() - minimum.getY()));
		
		if(Math.abs(point.getX() - minimum.getX()) < 0.00000001 && Math.abs(point.getY() - minimum.getY()) < 0.0000001)return false;
		return true;
	}


	private ArrayList<Point> calculateGraham(ArrayList<Point> points) {
		ArrayList<Point> huelle = new ArrayList<Point>();
		
		huelle.add(points.get(0));
		for(int i = 1; i < points.size() - 1; ){
			if(calculate(points.get(i-1), points.get(i+1), points.get(i))){
				huelle.add(points.get(i));
				++i;
			}else{
				points.remove(i);
				--i;
			}
		}
		return huelle;
	}
	
	private boolean calculate(Point a, Point b, Point c){
		double erg = (b.getX() - a.getX())*(c.getY() - a.getY()) - (c.getX() - a.getX())*(b.getY() - a.getY());
		
		if(erg > 0 ) return true;
		else return false;
	}

	private void reverse(ArrayList<Point> huelle, int start) {
		for (int i = huelle.size() - 2; i > start; i--) {
			huelle.remove(i);
		}
	}


	private ArrayList<Point> normalize(ArrayList<Point> points, Point minimum) {
		ArrayList<Point> rc = new ArrayList<Point>();
		
		for (int i = 0; i < points.size(); i++) {
			rc.add(new Point(points.get(i).getX() - minimum.getX(), points.get(i).getY() - minimum.getY()));
		}
		
		return rc;
	}

	private int findMin(ArrayList<Point> points ) {
		Point temp;
		int rc = 0;
		temp = points.get(0);
		for (int i = 1; i < points.size(); i++) {
			if(temp.getY() > points.get(i).getY()){
				temp = points.get(i);
				rc = i;
			}
		}
		return rc;
	}
	
	private void print(ArrayList<Point> points) {
		for (int i = 0; i < points.size(); i++) {
			System.out.println("(" + points.get(i).getX() + "," + points.get(i).getY() + ")");
		}
		System.out.println("\n");
		
	}

	private void jarvisMarchAlg(ArrayList<Point> points) {
		ArrayList<Point> huelle = new ArrayList<Point>();
		int minimum;
		
		minimum = findMin(points);
		huelle = calculateJarvis(points, minimum);

		
	}

	private void grahamScanAlg(ArrayList<Point> points) {
		ArrayList<Point> huelle = new ArrayList<Point>();
		int minimum;
		Point min;
		
		minimum = findMin(points);
		min = points.get(minimum);
		points = normalize(points, points.get(minimum));
		Collections.sort(points);
		huelle = calculateGraham(points);
		huelle = unnormalize(points, min);
	}

	private ArrayList<Point> unnormalize(ArrayList<Point> points, Point min) {
			ArrayList<Point> rc = new ArrayList<Point>();
		
		for (int i = 0; i < points.size(); i++) {
			rc.add(new Point(points.get(i).getX() + min.getX(), points.get(i).getY() + min.getY()));
		}
		
		return rc;
	}


	private void initArr(ArrayList<Point> points1, ArrayList<Point> points2, ArrayList<Point> points3 ) {
//		points.add(new Point(3.9, 5.1));
//		points.add(new Point(6, 2));
//		points.add(new Point(4.4, 3.5));
//		points.add(new Point(2.3, 4.5));
//		points.add(new Point(4, 3));
//		points.add(new Point(5.8, 3.6));
//		points.add(new Point(5.4, 4));
//		points.add(new Point(2, 1));
//		points.add(new Point(4.8, 5.3));
		
//		points.add(new Point(5.339623281898355,1.1432026704372678));
//		points.add(new Point(5.619436397151166,5.1961454604133746));
//		points.add(new Point(0.09065806591535774,8.20588352820925));
//		points.add(new Point(8.051736919365775,6.91638422699321));
//		points.add(new Point(9.805361882186162,1.7533120849712092));
//		points.add(new Point(9.320468758707593,9.489755958994426));
//		points.add(new Point(2.2789289998264586,5.776903896203322));
//		points.add(new Point(1.4007761490990267,9.66730903180209));
//		points.add(new Point(4.20923170375641,9.886445089709252));
//		points.add(new Point(7.175052792315467,6.689557884037573));
//		points.add(new Point(6.861440473070529,9.896074469015995));
//		points.add(new Point(1.4497211375805419,6.374993777574095));
//		points.add(new Point(1.3173464063646967,1.6449478215180091));
//		points.add(new Point(2.399760522111545,5.166447944002396));
//		points.add(new Point(1.4139413442519744,6.686921334857699));
		
		Random rnd = new Random(1000);
		for (int i = 0; i < 20; i++) {
			double x = 1000 * rnd.nextDouble();
			double y = 1000 * rnd.nextDouble();
			points1.add(new Point(x, y));
			points2.add(new Point(x, y));
			points3.add(new Point(x, y));
		}
	}

	public static void main(String[] args) {
		KonvexeHuelle kh = new KonvexeHuelle();
	}

}
