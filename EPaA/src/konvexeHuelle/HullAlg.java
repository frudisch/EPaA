package konvexeHuelle;
import java.util.Random;

public class HullAlg {
	
	public static void main(String[] args) {
		Point[] points = new Point[15];
		
		Random rand = new Random(150);
		for (int i = 0; i < points.length; i++) {
			points[i] = new Point(rand.nextDouble()*10, rand.nextDouble()*10);
		}
		
		HullAlg test = new HullAlg();
		test.print(points);
		points = test.huelle(points);
		test.print(points);
	}
	
	
	public Point[] huelle(Point[] points){
		int minInd = findMin(points);
		int maxInd = findMax(points);
		
		Point[] a = leftMax(minInd, maxInd, points);
		Point[] b = leftMax(maxInd, minInd, points);
		
		Point[] temp = {points[minInd], points[maxInd]};
		
		return concat(concat(a, b), temp);
	}
	private int findMax(Point[] points) {
		double max = points[0].getX();
		int rc = 0;
		
		for (int i = 1; i < points.length; i++) {
			if(points[i].getX() > max){
				rc = i;
				max = points[i].getX();
			}
		}
		
		return rc;
	}
	private int findMin(Point[] points) {
		double min = points[0].getX();
		int rc = 0;
		
		for (int i = 1; i < points.length; i++) {
			if(points[i].getX() < min){
				rc = i;
				min = points[i].getX();
			}
		}
		
		return rc;
	}
	private Point[] leftMax(int minInd, int maxInd, Point[] points) {
		boolean found = false;
		int tempInd = 0;
		double tempFl = 0;
		double tempFlLinks;
		double tempFlRechts;
		
		for (int i = 0; i < points.length; i++) {
			if(flaeche(points[minInd], points[maxInd], points[i]) > tempFl){
				tempFl = flaeche(points[minInd], points[maxInd], points[i]);
				tempInd = i;
				found = true;
			}
		}
		
		if(found){
			Point[] temp = new Point[1];
			temp[0] = points[tempInd];
			
			for (int i = 0; i < points.length; i++) {
				tempFl = flaeche(points[minInd], points[maxInd], points[i]);
				tempFlLinks = flaeche(points[minInd], points[tempInd], points[i]);
				tempFlRechts = flaeche(points[tempInd], points[maxInd], points[i]);
				
				if(tempFl > 0.0 && tempFlRechts < 0.0 && tempFlLinks < 0.0){
					points = remove(points, i);
					if(minInd > i)	--minInd;
					if(maxInd > i) --maxInd;
					if(tempInd > i) --tempInd;
				}
			}
			
			Point[] a = leftMax(minInd, tempInd, points);
			Point[] b = leftMax(tempInd, maxInd, points);
			return concat(concat(a,b), temp);
		} else {
			return new Point[0];
		}
		
	}
	
	private Point[] remove(Point[] points, int i) {
		Point[] rc = new Point[points.length - 1];
		for (int j = 0; j < i; j++) {
			rc[j] = points[j];
		}
		for (int j = i + 1; j < points.length; j++) {
			rc[j - 1] = points[j];
		}
		return rc;
	}

	private Point[] concat(Point[] a, Point[] b) {
		Point[] rc = new Point[a.length + b.length];
		for (int i = 0; i < a.length; i++) {
			rc[i] = a[i];
		}
		for (int i = a.length; i < rc.length; i++) {
			rc[i] = b[i-a.length];
		}
		
		
		return rc;
	}
	private boolean determinante(Point a, Point b, Point c){
		if((b.getX() - a.getX())*(c.getY() - a.getY()) - (c.getX() - a.getX())*(b.getY() - a.getY()) < 0) return false; //c rechts
		return true; //c links
	}
	
	private double flaeche(Point a , Point b, Point c){
		return (b.getX() - a.getX())*(c.getY() - a.getY()) - (c.getX() - a.getX())*(b.getY() - a.getY());
	}
	
	private void print(Point[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.println("("+arr[i].getX()+","+arr[i].getY()+")");
		}
		System.out.println("\n");
	}
}
